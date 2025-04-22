package ru.netology.page;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.netology.data.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.netology.elements.FilterScreenElements;

public class FilterPage {

    FilterScreenElements filterScreenElements = new FilterScreenElements();

    public void checkFilterNewsScreenLoaded() {
        Allure.step("Проверка отображения экрана с фильтром для новостей");
        elementWaiting(withText("Filter news"), 5000);
        filterScreenElements.categoryField.check(matches(isDisplayed()));
        filterScreenElements.fromDateField.check(matches(isDisplayed()));
        filterScreenElements.toDateField.check(matches(isDisplayed()));
        filterScreenElements.filterButton.check(matches(isDisplayed()));
        filterScreenElements.cancelButton.check(matches(isDisplayed()));
    }

    public void clickCheckBoxActive() {
        Allure.step("Чекбокс Active");
        filterScreenElements.getCheckBoxActive().perform(click());
        filterScreenElements.getCheckBoxActive().check(matches(isNotChecked()));
    }

    public void clickCheckBoxNotActive() {
        Allure.step("Чекбокс Not active");
        filterScreenElements.getCheckBoxNotActive().perform(click());
        filterScreenElements.getCheckBoxNotActive().check(matches(isNotChecked()));
    }

    public void clickFilterButton() {
        Allure.step("Нажать на кнопку FILTER");
        filterScreenElements.getFilterButton().check(matches(isDisplayed()));
        filterScreenElements.getFilterButton().perform(click());
    }
}
