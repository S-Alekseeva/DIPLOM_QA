package ru.netology.page;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.netology.data.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.elements.OurMissionScreenElements;


public class OurMissionPage {

    OurMissionScreenElements ourMissionElements = new OurMissionScreenElements();

    public void checkOurMissionScreenLoaded() {
        Allure.step("Проверка элементов экрана our mission");
        elementWaiting(withId(R.id.our_mission_title_text_view), 5000);
    }

    public void openAndCloseQuote() {
        Allure.step("Открыть и закрыть цитату");
        ourMissionElements.getRecyclerView().check(matches(isDisplayed()));
        ourMissionElements.getRecyclerView().perform(actionOnItemAtPosition(0, click()));
        ourMissionElements.getDescriptionQuote().check(matches(isDisplayed()));
        ourMissionElements.getRecyclerView().perform(actionOnItemAtPosition(0, click()));
    }
}