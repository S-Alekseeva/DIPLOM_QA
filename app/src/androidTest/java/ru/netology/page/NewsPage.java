package ru.netology.page;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.netology.data.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.netology.elements.NewsScreenElements;

public class NewsPage {

    NewsScreenElements newsScreenElements = new NewsScreenElements();

    ControlPanelPage controlPanelPage = new ControlPanelPage();

    public void checkNewsScreenLoaded() {
        Allure.step("Проверка элементов экрана с новостями");
        elementWaiting(withText("News"), 5000);
        newsScreenElements.getNewsList().check(matches(isDisplayed()));
        newsScreenElements.getSortNews().check(matches(isDisplayed()));
        newsScreenElements.getFilterNews().check(matches(isDisplayed()));
        newsScreenElements.getEditNews().check(matches(isDisplayed()));
    }

//    public void emptyNewsList() {
//        Allure.step("Пустой блок с новостями");
//        newsScreenElements.getEmptyNewsList().check(matches(isDisplayed()));
//    }

    public void clickOpenAndCloseNews() {
        Allure.step("Открыть и свернуть описание новости");
        newsScreenElements.getRecyclerView().check(matches(isDisplayed()));
        newsScreenElements.getRecyclerView().perform(actionOnItemAtPosition(0, click()));
        newsScreenElements.getRecyclerView().perform(actionOnItemAtPosition(0, click()));
    }

    public void clickFilterNews() {
        Allure.step("Проверка элементов экрана с новостями");
        newsScreenElements.getFilterNewsButton().check(matches(isDisplayed()));
        newsScreenElements.getFilterNewsButton().perform(click());
    }

    public void clickFilterButton() {
        Allure.step("Нажать на кнопку фильтр новостей");
        newsScreenElements.getFilterButton().check(matches(isDisplayed()));
        newsScreenElements.getFilterButton().perform(click());
    }

    public void fillInFormFilterNews(String category, String fromDate, String toDate) {
        Allure.step("Заполнение полей фильтра новостей");
        newsScreenElements.getCategoryField().perform(replaceText(category));
        newsScreenElements.getFromDate().perform(replaceText(fromDate));
        newsScreenElements.getToDate().perform(replaceText(toDate));
    }

    public void sortingNews() {
        Allure.step("Нажать на кнопку сортировки новостей");
        newsScreenElements.getSortNews().check(matches(isDisplayed()));
        newsScreenElements.getSortNews().perform(click());
    }

    public void goToControlPanel() {
        Allure.step("Переход в раздел ControlPanel");
        newsScreenElements.getControlPanelButton().perform(click());
        controlPanelPage.checkControlPanelScreenLoaded();
    }
}