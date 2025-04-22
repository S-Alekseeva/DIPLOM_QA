package ru.netology.page;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.netology.data.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.elements.AboutScreenElements;

public class AboutPage {

    AboutScreenElements aboutScreenElements = new AboutScreenElements();
    MainPage mainPage = new MainPage();

    public void checkAboutScreenLoaded() {
        Allure.step("Проверка элементов экрана about");
        elementWaiting(withId(R.id.about_version_title_text_view), 5000);
        aboutScreenElements.getPrivacyPolicy().check(matches(isDisplayed()));
        aboutScreenElements.getTermsOfUse().check(matches(isDisplayed()));
    }

    public void exitMainMenu() {
        Allure.step("Переход в главное меню");
        checkAboutScreenLoaded();
        aboutScreenElements.getBackButton().check(matches(isDisplayed()));
        aboutScreenElements.getBackButton().perform(click());
        mainPage.mainScreen();
    }
}