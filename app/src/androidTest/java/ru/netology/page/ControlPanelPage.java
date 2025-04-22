package ru.netology.page;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.netology.data.DataHelper.elementWaiting;
import static ru.netology.data.DataHelper.setChecked;

import io.qameta.allure.kotlin.Allure;
import ru.netology.elements.ControlPanelScreenElements;

public class ControlPanelPage {

    ControlPanelScreenElements controlPanelElements = new ControlPanelScreenElements();

    public void checkControlPanelScreenLoaded() {
        Allure.step("Проверка загрузки страницы Control panel");
        elementWaiting(withText("Control panel"), 5000);
        controlPanelElements.getControlPanelScreenName().check(matches(isDisplayed()));
        controlPanelElements.getSortNewsButton().check(matches(isDisplayed()));
        controlPanelElements.getFilterNewsButton().check(matches(isDisplayed()));
        controlPanelElements.getCreateNewsButton().check(matches(isDisplayed()));
        controlPanelElements.getRecyclerViewNewsList().check(matches(isDisplayed()));
    }

    public void checkEditingNewsScreenLoaded() {
        Allure.step("Проверка элементов экрана с новостями");
        controlPanelElements.getCategoryField().check(matches(isDisplayed()));
        controlPanelElements.getTitleField().check(matches(isDisplayed()));
        controlPanelElements.getPublicationDateField().check(matches(isDisplayed()));
        controlPanelElements.getTimeField().check(matches(isDisplayed()));
        controlPanelElements.getDescriptionField().check(matches(isDisplayed()));
        controlPanelElements.getToggleSwitches().check(matches(isDisplayed()));
        controlPanelElements.getSaveButton().check(matches(isDisplayed()));
        controlPanelElements.getCancelButton().check(matches(isDisplayed()));
    }

    public void checkCreatingNewsScreenLoaded() {
        Allure.step("Проверка элементов экрана создания новости");
        controlPanelElements.getCategoryField().check(matches(isDisplayed()));
        controlPanelElements.getTitleField().check(matches(isDisplayed()));
        controlPanelElements.getPublicationDateField().check(matches(isDisplayed()));
        controlPanelElements.getTimeField().check(matches(isDisplayed()));
        controlPanelElements.getDescriptionField().check(matches(isDisplayed()));
        controlPanelElements.getToggleSwitches().check(matches(isDisplayed()));
        controlPanelElements.getSaveButton().check(matches(isDisplayed()));
        controlPanelElements.getCancelButton().check(matches(isDisplayed()));
    }

    public void sortingNews() {
        Allure.step("Нажать на кнопку сортировка новостей");
        controlPanelElements.getSortNewsButton().check(matches(isDisplayed()));
        controlPanelElements.getSortNewsButton().perform(click());
    }

    public void chooseFirstNews() {
        Allure.step("Выбор первой новости");
        controlPanelElements.getFirstNews().perform(click());
    }

    public void viewDescriptionNews() {
        Allure.step("Просмотр описания новости");
        chooseFirstNews();
        controlPanelElements.getViewDescriptionNews().check(matches(isDisplayed()));
    }

    public void fillInFormEditNews(String category, String title, String publicationDate,
                                   String time, String description) {
        Allure.step("Заполнение полей формы при редактировании новости");
        controlPanelElements.getCategoryField().perform(replaceText(category));
        controlPanelElements.getTitleField().perform(replaceText(title));
        controlPanelElements.getPublicationDateField().perform(replaceText(publicationDate));
        controlPanelElements.getTimeField().perform(replaceText(time));
        controlPanelElements.getDescriptionField().perform(replaceText(description));
    }

    public void clickToggleSwitchesNotActive() {
        Allure.step("Положение тумблера в положении Not Active");
        controlPanelElements.getToggleSwitches().perform(scrollTo(), setChecked(false));
    }

    public void clickToggleSwitchesActive() {
        Allure.step("Положение тумблера в положении Active");
        controlPanelElements.getToggleSwitches().perform(scrollTo(), setChecked(true));
    }

    public void clickSaveButton() {
        Allure.step("Нажать на кнопку SAVE");
        controlPanelElements.getSaveButton().check(matches(isDisplayed()));
        controlPanelElements.getSaveButton().perform(click());
    }

    public void clickCancelButtonEdit() {
        Allure.step("Нажать на кнопку CANCEL");
        controlPanelElements.getCancelButtonEdit().check(matches(isDisplayed()));
        controlPanelElements.getCancelButtonEdit().perform(click());
    }

    public void clickOkButton() {
        Allure.step("Нажать на кнопку OK");
        controlPanelElements.getOkButton().check(matches(isDisplayed()));
        controlPanelElements.getOkButton().perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажать на кнопку CANCEL");
        controlPanelElements.getCancelButton().check(matches(isDisplayed()));
        controlPanelElements.getCancelButton().perform(click());
    }

    public void fillInFormCreatingNews(String category, String title, String publicationDate,
                                       String time, String description) {
        Allure.step("Заполнение полей формы при создании новости");
        controlPanelElements.getCategoryField().perform(replaceText(category));
        controlPanelElements.getTitleField().perform(replaceText(title));
        controlPanelElements.getPublicationDateField().perform(replaceText(publicationDate));
        controlPanelElements.getTimeField().perform(replaceText(time));
        controlPanelElements.getDescriptionField().perform(replaceText(description));
    }

    public void deleteFirstNews() {
        Allure.step("Удалить первую новость");
        controlPanelElements.getDeleteFirstNewsButton().perform(click());
    }

    public void clickCancelButtonDeleteNews() {
        Allure.step("Нажать на кнопку CANCEL при удалении новости");
        controlPanelElements.getCancelButton().check(matches(isDisplayed()));
        controlPanelElements.getCancelButton().perform(click());
    }

    public void clickEditNewsButton() {
        Allure.step("Нажать на кнопку редактирования новостей");
        controlPanelElements.getEditNewsButton().perform(click());
    }

    public void clickFilterNewsButton() {
        Allure.step("Нажать на кнопку фильтр новостей");
        controlPanelElements.getFilterNewsButton().perform(click());
    }

    public void clickCreateNewsButton() {
        Allure.step("Нажать на кнопку создания новостей");
        controlPanelElements.getCreateNewsButton().check(matches(isDisplayed()));
        controlPanelElements.getCreateNewsButton().perform(click());
    }
}