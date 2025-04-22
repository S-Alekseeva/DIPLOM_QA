package ru.netology.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
import ru.netology.data.OtherData;
import ru.netology.page.ControlPanelPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CreatingNewsCPUnitTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;

    ControlPanelPage controlPanelPage = new ControlPanelPage();

    OtherData otherData = new OtherData();

    String emptyFieldMessage = "Fill empty fields";

    String cancelMessage = "The changes won't be saved, do you really want to log out?";

    LoadingScreen loadingScreen = new LoadingScreen();

    @Before
    public void LoadingScreen() {
        loadingScreen.readyControlPanelScreen();
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
    @DisplayName("Создание новости в Control Panel")
    @AllureId("TC-42")
    public void newsCreationControlPanel() {
        controlPanelPage.clickCreateNewsButton();
        controlPanelPage.fillInFormCreatingNews(otherData.category3, otherData.title3,
                otherData.publicationDate3, otherData.time3, otherData.description3);
        controlPanelPage.clickToggleSwitchesActive();
        controlPanelPage.clickSaveButton();
        controlPanelPage.checkControlPanelScreenLoaded();
    }

    @Test
    @DisplayName("Создание новости с пустыми полями в Control Panel")
    @AllureId("TC-43")
    public void newsEmptyCreationControlPanel() {
        controlPanelPage.clickCreateNewsButton();
        controlPanelPage.fillInFormCreatingNews(otherData.category4, otherData.title4,
                otherData.publicationDate4, otherData.time4, otherData.description4);
        controlPanelPage.clickToggleSwitchesActive();
        controlPanelPage.clickSaveButton();
        onView(withText(emptyFieldMessage))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Отмена создания новости в Control Panel")
    @AllureId("TC-44")
    public void cancelNewsCreationControlPanel() {
        controlPanelPage.clickCreateNewsButton();
        controlPanelPage.clickCancelButton();
        onView(withText(cancelMessage))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        controlPanelPage.clickOkButton();
        controlPanelPage.checkControlPanelScreenLoaded();
    }

    @Test
    @DisplayName("Возобновление создания новости в Control Panel")
    @AllureId("TC-45")
    public void resumingNewsCreationControlPanel() {
        controlPanelPage.clickCreateNewsButton();
        controlPanelPage.clickCancelButton();
        onView(withText(cancelMessage))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        controlPanelPage.clickCancelButton();
        controlPanelPage.checkCreatingNewsScreenLoaded();
    }
}