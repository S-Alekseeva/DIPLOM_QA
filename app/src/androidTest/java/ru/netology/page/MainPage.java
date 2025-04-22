package ru.netology.page;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.netology.data.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.netology.elements.AuthorizationScreenElements;
import ru.netology.elements.MainScreenElements;
import ru.netology.elements.NewsScreenElements;

public class MainPage {

    MainScreenElements mainScreenElements = new MainScreenElements();

    NewsScreenElements newsScreenElements = new NewsScreenElements();

    AuthorizationScreenElements authorizationScreenElements = new AuthorizationScreenElements();

    public void checkMainScreenLoaded() {
        Allure.step("Проверка загрузки основного экрана");
        elementWaiting(withText("News"), 5000);
    }

    public void mainScreen() {
        Allure.step("Проверка элементов основного экрана");
        mainScreenElements.getTradeMark().check(matches(isDisplayed()));
        mainScreenElements.getNews().check(matches(isDisplayed()));
    }

    public void viewNewsUnitMain() {
        Allure.step("Просмотр новостей");
        mainScreenElements.getNews().check(matches(isDisplayed()));
        mainScreenElements.getExpandMaterialButton().check(matches(isDisplayed()));
        mainScreenElements.getExpandMaterialButton().perform(click());
        mainScreenElements.getExpandMaterialButton().perform(click());
        mainScreenElements.getNewsList().check(matches(isDisplayed()));
        mainScreenElements.getAllNewsButton().check(matches(isDisplayed()));
        mainScreenElements.getAllNewsButton().perform(click());
        mainScreenElements.getNewsAllNews().check(matches(isDisplayed()));
        mainScreenElements.getSortNews().check(matches(isDisplayed()));
        mainScreenElements.getFilterNews().check(matches(isDisplayed()));
        mainScreenElements.getEditNews().check(matches(isDisplayed()));
    }

//    public void emptyNewsListScreen() {
//        Allure.step("Пустой блок новостей");
//        mainScreenElements.getNews().check(matches(isDisplayed()));
//        mainScreenElements.getAllNewsButton().check(matches(isDisplayed()));
//        mainScreenElements.getAllNewsButton().perform(click());
//        newsScreenElements.getEmptyNewsList().check(matches(isDisplayed()));
//    }

    public void logOut() {
        Allure.step("Выход из личного кабинета");
        clickExitButton();
        authorizationScreenElements.getAuthorization().check(matches(isDisplayed()));
        authorizationScreenElements.getLoginField().check(matches(isDisplayed()));
        authorizationScreenElements.getPasswordField().check(matches(isDisplayed()));
        authorizationScreenElements.getButton().check(matches(isDisplayed()));
    }

    public void goToNews() {
        Allure.step("Переход в раздел новостей");
        mainScreenElements.getMainMenuButton().check(matches(isDisplayed()));
        mainScreenElements.getMainMenuButton().perform(click());
        mainScreenElements.getNews().check(matches(isDisplayed()));
        mainScreenElements.getNews().perform(click());
    }

    public void goToAbout() {
        Allure.step("Переход в раздел about");
        mainScreenElements.getMainMenuButton().check(matches(isDisplayed()));
        mainScreenElements.getMainMenuButton().perform(click());
        mainScreenElements.getAbout().check(matches(isDisplayed()));
        mainScreenElements.getAbout().perform(click());
    }

    public void goToOurMission() {
        Allure.step("Переход в раздел our mission");
        mainScreenElements.getOurMissionButton().check(matches(isDisplayed()));
        mainScreenElements.getOurMissionButton().perform(click());
    }

    public void clickExitButton() {
        Allure.step("Нажать на кнопку выход из приложения");
        mainScreenElements.getLogOut().perform(click());
        mainScreenElements.getExitButton().check(matches(isDisplayed()));
        mainScreenElements.getExitButton().perform(click());
    }
}