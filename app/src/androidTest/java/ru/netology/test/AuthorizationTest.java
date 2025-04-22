package ru.netology.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.netology.data.DataHelper.authInfo;
import static ru.netology.data.DataHelper.authInfoSpaces;
import static ru.netology.data.DataHelper.emptyFields;
import static ru.netology.data.DataHelper.emptyLoginField;
import static ru.netology.data.DataHelper.emptyPasswordField;
import static ru.netology.data.DataHelper.incorrectLogin;
import static ru.netology.data.DataHelper.incorrectLoginAndPassword;
import static ru.netology.data.DataHelper.incorrectLoginAndPasswordV;
import static ru.netology.data.DataHelper.incorrectPassword;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.AllureId;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.data.LoadingScreen;
import ru.netology.page.AuthorizationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;

    AuthorizationPage authorizationPage = new AuthorizationPage();

    LoadingScreen loadingScreen = new LoadingScreen();


    String messageEmpty = "Login and password cannot be empty";
    String messageWrong = "Something went wrong. Try again later.";

    @Before
    public void LoadingScreen() {
        loadingScreen.readyAuthorizationScreen();
    }

    public void setUp() {
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    @DisplayName("Успешная авторизация")
    @AllureId("TC-1")
    public void successfulAuthorizationTest() {

        authorizationPage.validAuthorization(authInfo());
    }

    @Test
    @DisplayName("Авторизация с пустыми полями логин и пароль")
    @AllureId("TC-2")
    public void authorizationTestEmptyFields() {

        authorizationPage.authorizationEmptyFields(emptyFields());
        onView(withText(messageEmpty))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с пустым полем логин")
    @AllureId("TC-3")
    public void authorizationTestEmptyLoginField() {

        authorizationPage.authorizationEmptyLoginField(emptyLoginField());
        onView(withText(messageEmpty))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с пустым полем пароль")
    @AllureId("TC-4")
    public void authorizationTestEmptyPasswordField() {

        authorizationPage.authorizationEmptyPasswordField(emptyPasswordField());
        onView(withText(messageEmpty))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с невалидным логином и валидным паролем")
    @AllureId("TC-5")
    public void authorizationTestIncorrectLogin() {

        authorizationPage.authorizationIncorrectLogin(incorrectLogin());
        onView(withText(messageWrong))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с валидным логином и невалидным паролем")
    @AllureId("TC-6")
    public void authorizationTestIncorrectPassword() {

        authorizationPage.authorizationIncorrectPassword(incorrectPassword());
        onView(withText(messageWrong))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с невалидными логином и паролем")
    @AllureId("TC-7")
    public void authorizationTestIncorrectLoginAndPassword() {

        authorizationPage.authorizationIncorrectLoginAndPassword(incorrectLoginAndPassword());
        onView(withText(messageWrong))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с невалидными логином и паролем")
    @AllureId("TC-8")
    public void authorizationTestIncorrectLoginAndPasswordV() {

        authorizationPage.authorizationIncorrectLoginAndPasswordV(incorrectLoginAndPasswordV());
        onView(withText(messageWrong))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с вводом валидных данных и пробелами в полях")
    @AllureId("TC-9")
    public void authorizationTestAuthInfoSpaces() {

        authorizationPage.authorizationAuthInfoSpaces(authInfoSpaces());
        onView(withText(messageWrong))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }
}