package ru.netology.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.AllureId;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.data.LoadingScreen;
import ru.netology.page.AboutPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutUnitTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    LoadingScreen loadingScreen = new LoadingScreen();
    AboutPage aboutPage = new AboutPage();

    @Before
    public void LoadingScreen() {
        loadingScreen.readyAboutScreen();
    }

    @Test
    @DisplayName("Выход в главное меню из вкладки About")
    @AllureId("TC-48")
    public void checkingExitMainMenu() {
        aboutPage.exitMainMenu();
    }
}