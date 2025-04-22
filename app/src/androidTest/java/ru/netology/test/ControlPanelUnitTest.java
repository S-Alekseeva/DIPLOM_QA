package ru.netology.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.netology.data.DataHelper.hasItemAtPosition;

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
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.data.DataHelper;
import ru.netology.data.LoadingScreen;
import ru.netology.data.OtherData;
import ru.netology.elements.ControlPanelScreenElements;
import ru.netology.elements.FilterScreenElements;
import ru.netology.page.ControlPanelPage;
import ru.netology.page.FilterPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelUnitTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;

    ControlPanelPage controlPanelPage = new ControlPanelPage();

    ControlPanelScreenElements controlPanelElements = new ControlPanelScreenElements();

    OtherData otherData = new OtherData();

    FilterPage filterPage = new FilterPage();

    FilterScreenElements filterScreenElements = new FilterScreenElements();

    String deleteMessage = "Are you sure you want to permanently delete the document? " +
            "These changes cannot be reversed in the future.";

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
    @DisplayName("Сортировка новостей в Control Panel")
    @AllureId("TC-29")
    public void sortNewsControlPanel() {
        controlPanelPage.sortingNews();
        onView(hasItemAtPosition(hasDescendant(
                withId(R.id.news_item_publication_date_text_view)), 0)).check(
                matches(isDisplayed()));
        onView(hasItemAtPosition(hasDescendant(
                withId(R.id.news_item_publication_date_text_view)), 1)).check(
                matches(isDisplayed()));

    }

    @Test
    @DisplayName("Просмотр описания новости в Control Panel")
    @AllureId("TC-30")
    public void checkingViewNewsControlPanel() {
        controlPanelPage.viewDescriptionNews();
    }


    @Test
    @DisplayName("Удаление новости в Control Panel")
    @AllureId("TC-31")
    public void deleteNewsControlPanel() {
        String title = DataHelper.Text.getText(controlPanelElements.getNewsItemTitle());
        controlPanelPage.deleteFirstNews();
        onView(withText(deleteMessage))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        controlPanelPage.clickOkButton();
        controlPanelPage.checkControlPanelScreenLoaded();
        String title2 = DataHelper.Text.getText(controlPanelElements.getNewsItemTitleAfterDelete());
        assertNotEquals(title, title2);
    }

    @Test
    @DisplayName("Отмена удаления новости в Control Panel")
    @AllureId("TC-32")
    public void cancelDeleteNewsControlPanel() {
        String title = DataHelper.Text.getText(controlPanelElements.getNewsItemTitle());
        controlPanelPage.deleteFirstNews();
        onView(withText(deleteMessage))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        controlPanelPage.clickCancelButtonDeleteNews();
        assertEquals(title, title);
    }

    @Test
    @DisplayName("Редактирование новости в Control Panel")
    @AllureId("TC-33")
    public void checkingEditNews() {
        controlPanelPage.clickEditNewsButton();
        controlPanelPage.fillInFormEditNews(otherData.category, otherData.title, otherData.publicationDate,
                otherData.time, otherData.description);
        controlPanelPage.clickToggleSwitchesNotActive();
        controlPanelPage.clickSaveButton();
        controlPanelPage.checkControlPanelScreenLoaded();
    }

    @Test
    @DisplayName("Отмена редактирования новости в Control Panel")
    @AllureId("TC-34")
    public void checkingCancelEditNews() {
        controlPanelPage.clickEditNewsButton();
        controlPanelPage.fillInFormEditNews(otherData.category2, otherData.title2,
                otherData.publicationDate2, otherData.time2, otherData.description2);
        controlPanelPage.clickToggleSwitchesActive();
        controlPanelPage.clickCancelButtonEdit();
        onView(withText(cancelMessage))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        controlPanelPage.clickOkButton();
        controlPanelPage.checkControlPanelScreenLoaded();
    }

    @Test
    @DisplayName("Возобновление редактирования новости в Control Panel")
    @AllureId("TC-35")
    public void resumingEditNews() {
        controlPanelPage.clickEditNewsButton();
        controlPanelPage.checkEditingNewsScreenLoaded();
        controlPanelPage.clickToggleSwitchesActive();
        controlPanelPage.clickCancelButtonEdit();
        onView(withText(cancelMessage))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        controlPanelPage.clickCancelButton();
        controlPanelPage.checkEditingNewsScreenLoaded();
    }

    @Test
    @DisplayName("Фильтр новостей по критерию Active в Control Panel")
    @AllureId("TC-40")
    public void checkingFilterActive() {
        controlPanelPage.clickFilterNewsButton();
        filterPage.clickCheckBoxNotActive();
        filterPage.clickFilterButton();
        String firstNewsStatus = DataHelper.Text.getText(filterScreenElements.getNewsStatus());
        assertEquals(firstNewsStatus, "Active");
    }

    @Test
    @DisplayName("Фильтр новостей по критерию Not active в Control Panel")
    @AllureId("TC-41")
    public void checkingFilterNotActive() {
        controlPanelPage.clickFilterNewsButton();
        filterPage.clickCheckBoxActive();
        filterPage.clickFilterButton();
        String firstNewsStatus = DataHelper.Text.getText(filterScreenElements.getNewsStatus());
        assertEquals(firstNewsStatus, "Not active");
    }
}