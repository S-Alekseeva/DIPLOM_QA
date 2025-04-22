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
import ru.netology.page.MainPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainUnitTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    MainPage mainPage = new MainPage();
    LoadingScreen loadingScreen = new LoadingScreen();

    @Before
    public void LoadingScreen() {
        loadingScreen.readyMainScreen();
    }


    @Test
    @DisplayName("Просмотр новостей в разделе News вкладки Main")
    @AllureId("TC-10")
    public void checkingViewNewsUnitMain() {
        mainPage.viewNewsUnitMain();
    }

//    @Test
//    @DisplayName("Просмотр новостей в разделе News вкладки Main")
//    @AllureId("TC-10")
//    public void checkingEmptyNewsListScreen() {
//        mainPage.emptyNewsListScreen();
//    }
}