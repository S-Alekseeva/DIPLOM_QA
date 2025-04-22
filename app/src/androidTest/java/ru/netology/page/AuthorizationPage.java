package ru.netology.page;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.netology.data.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.data.DataHelper;
import ru.netology.elements.AuthorizationScreenElements;
import ru.netology.elements.MainScreenElements;

public class AuthorizationPage {

    MainPage mainPage = new MainPage();
    AuthorizationScreenElements authorizationScreenElements = new AuthorizationScreenElements();
    MainScreenElements mainScreenElements = new MainScreenElements();

    public void checkLoadScreen() {
        Allure.step("Проверка загрузки экрана авторизации");
        elementWaiting(withId(R.id.enter_button), 5000);
    }

    public void authorizationScreen() {
        Allure.step("Проверка элементов экрана авторизации");
        authorizationScreenElements.getAuthorization().check(matches(isDisplayed()));
        authorizationScreenElements.getLoginField().check(matches(isDisplayed()));
        authorizationScreenElements.getPasswordField().check(matches(isDisplayed()));
        authorizationScreenElements.getButton().check(matches(isDisplayed()));
    }

    public void validAuthorization(DataHelper.AuthInfo info) {
        Allure.step("Ввод валидного логина и пароля");
        authorizationScreenElements.getLoginField().perform(
                typeText(info.getLogin()), (closeSoftKeyboard()));
        authorizationScreenElements.getPasswordField().perform(
                typeText(info.getPassword()), (closeSoftKeyboard()));
        authorizationScreenElements.getButton().perform(click());
        mainPage.checkMainScreenLoaded();
        mainScreenElements.getTradeMark().check(matches(isDisplayed()));
    }

    public void authorizationEmptyFields(DataHelper.AuthInfo emptyFields) {
        Allure.step("Оставить незаполненными поля логин и пароль");
        authorizationScreenElements.getLoginField().perform(
                typeText(emptyFields.getLogin())).perform(closeSoftKeyboard());
        authorizationScreenElements.getPasswordField().perform(
                typeText(emptyFields.getPassword())).perform(closeSoftKeyboard());
        authorizationScreenElements.getButton().perform(click());
    }

    public void authorizationEmptyLoginField(DataHelper.AuthInfo emptyLoginField) {
        Allure.step("Оставить незаполненным поле логин");
        authorizationScreenElements.getLoginField().perform(
                typeText(emptyLoginField.getLogin())).perform(closeSoftKeyboard());
        authorizationScreenElements.getPasswordField().perform(
                typeText(emptyLoginField.getPassword())).perform(closeSoftKeyboard());
        authorizationScreenElements.getButton().perform(click());
    }

    public void authorizationEmptyPasswordField(DataHelper.AuthInfo emptyPasswordField) {
        Allure.step("Оставить незаполненным поле пароль");
        authorizationScreenElements.getLoginField().perform(
                typeText(emptyPasswordField.getLogin())).perform(closeSoftKeyboard());
        authorizationScreenElements.getPasswordField().perform(
                typeText(emptyPasswordField.getPassword())).perform(closeSoftKeyboard());
        authorizationScreenElements.getButton().perform(click());
    }

    public void authorizationIncorrectLogin(DataHelper.AuthInfo incorrectLogin) {
        Allure.step("Ввод невалидного логина");
        authorizationScreenElements.getLoginField().perform(
                typeText(incorrectLogin.getLogin())).perform(closeSoftKeyboard());
        authorizationScreenElements.getPasswordField().perform(
                typeText(incorrectLogin.getPassword())).perform(closeSoftKeyboard());
        authorizationScreenElements.getButton().perform(click());
    }

    public void authorizationIncorrectPassword(DataHelper.AuthInfo incorrectPassword) {
        Allure.step("Ввод невалидного пароля");
        authorizationScreenElements.getLoginField().perform(
                typeText(incorrectPassword.getLogin())).perform(closeSoftKeyboard());
        authorizationScreenElements.getPasswordField().perform(
                typeText(incorrectPassword.getPassword())).perform(closeSoftKeyboard());
        authorizationScreenElements.getButton().perform(click());
    }

    public void authorizationIncorrectLoginAndPassword(DataHelper.AuthInfo incorrectLoginAndPassword) {
        Allure.step("Ввод невалидного логина и пароля");
        authorizationScreenElements.getLoginField().perform(
                typeText(incorrectLoginAndPassword.getLogin())).perform(closeSoftKeyboard());
        authorizationScreenElements.getPasswordField().perform(
                typeText(incorrectLoginAndPassword.getPassword())).perform(closeSoftKeyboard());
        authorizationScreenElements.getButton().perform(click());
    }

    public void authorizationIncorrectLoginAndPasswordV(DataHelper.AuthInfo incorrectLoginAndPasswordV) {
        Allure.step("Ввод невалидного логина и пароля");
        authorizationScreenElements.getLoginField().perform(
                typeText(incorrectLoginAndPasswordV.getLogin())).perform(closeSoftKeyboard());
        authorizationScreenElements.getPasswordField().perform(
                typeText(incorrectLoginAndPasswordV.getPassword())).perform(closeSoftKeyboard());
        authorizationScreenElements.getButton().perform(click());
    }

    public void authorizationAuthInfoSpaces(DataHelper.AuthInfo authInfoSpaces) {
        Allure.step("Ввод валидного логина и пароля с пробелами в полях");
        authorizationScreenElements.getLoginField().perform(
                typeText(authInfoSpaces.getLogin())).perform(closeSoftKeyboard());
        authorizationScreenElements.getPasswordField().perform(
                typeText(authInfoSpaces.getPassword())).perform(closeSoftKeyboard());
        authorizationScreenElements.getButton().perform(click());
    }
}