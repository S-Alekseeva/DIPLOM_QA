package ru.netology.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static ru.netology.data.DataHelper.hasItemAtPosition;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

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
import ru.netology.elements.NewsScreenElements;
import ru.netology.page.FilterPage;
import ru.netology.page.NewsPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsUnitTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;

    NewsPage newsPage = new NewsPage();

    NewsScreenElements newsScreenElements = new NewsScreenElements();

    FilterPage filterPage = new FilterPage();

    LoadingScreen loadingScreen = new LoadingScreen();

    OtherData otherData = new OtherData();

    String fromDate = otherData.fromDate;
    String toDate = otherData.toDate;

    @Before
    public void LoadingScreen() {
        loadingScreen.readyNewsScreen();
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
    @DisplayName("Просмотр новости во вкладке News")
    @AllureId("TC-11")
    public void checkingOpenAndCloseNews() {
        newsPage.clickOpenAndCloseNews();
    }

    @Test
    @DisplayName("Сортировка новостей во вкладке News")
    @AllureId("TC-12")
    public void sortNews() {
        newsPage.sortingNews();
        onView(hasItemAtPosition(hasDescendant(
                withId(R.id.news_item_title_text_view)), 0)).check(matches(isDisplayed()));
        onView(hasItemAtPosition(hasDescendant(
                withId(R.id.news_item_title_text_view)), 1)).check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Фильр новостей с выбранной категорией за заданный диапазон дат во вкладке News")
    @AllureId("TC-21")
    public void checkingFilterNewsByDate() {
        newsPage.clickFilterNews();
        filterPage.checkFilterNewsScreenLoaded();
        newsPage.fillInFormFilterNews(otherData.ad, otherData.fromDate, otherData.toDate);
        newsPage.clickFilterButton();
        String firstNewsPublicationDate = DataHelper.Text.getText(newsScreenElements.getDateNewsField());
        assertEquals(firstNewsPublicationDate, toDate);
        newsPage.sortingNews();
        String secondNewsPublicationDate = DataHelper.Text.getText(newsScreenElements.getDateNewsFieldAfterSort());
        assertEquals(secondNewsPublicationDate, fromDate);
    }

//    @Test
//    public void checkingEmptyNewsList() {
//        newsPage.emptyNewsList();
//    }
}