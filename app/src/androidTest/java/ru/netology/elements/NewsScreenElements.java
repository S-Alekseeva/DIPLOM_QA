package ru.netology.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.data.DataHelper.childAtPosition;
import static ru.netology.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsScreenElements {

    private final ViewInteraction newsList = onView(
            withId(R.id.news_list_swipe_refresh));

    private final ViewInteraction sortNews = onView(
            withId(R.id.sort_news_material_button));

    private final ViewInteraction filterNews = onView(
            withId(R.id.filter_news_material_button));

    private final ViewInteraction editNews = onView(
            withId(R.id.edit_news_material_button));

    private final ViewInteraction recyclerView = onView(
            allOf(withId(R.id.news_list_recycler_view),
                    childAtPosition(
                            withId(R.id.all_news_cards_block_constraint_layout),
                            0)));

    private final ViewInteraction filterNewsButton = onView(
            allOf(withId(R.id.filter_news_material_button)));

    private final ViewInteraction categoryField = onView(
            allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));

    private final ViewInteraction fromDate = onView(
            allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));

    private final ViewInteraction toDate = onView(
            allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));

    private final ViewInteraction emptyNewsList = onView(
            allOf(withId(R.id.news_retry_material_button)));

    private final ViewInteraction dateNewsField = onView(
            withIndex(withId(R.id.news_item_date_text_view), 0));

    private final ViewInteraction dateNewsFieldAfterSort = onView(
            withIndex(withId(R.id.news_item_date_text_view), 0));

    private final ViewInteraction controlPanelButton = onView(
            allOf(withId(R.id.edit_news_material_button)));

    private final ViewInteraction filterButton = onView(
            allOf(withId(R.id.filter_button)));

    public ViewInteraction getNewsList() {
        return newsList;
    }

    public ViewInteraction getSortNews() {
        return sortNews;
    }

    public ViewInteraction getFilterNews() {
        return filterNews;
    }

    public ViewInteraction getEditNews() {
        return editNews;
    }

    public ViewInteraction getRecyclerView() {
        return recyclerView;
    }

    public ViewInteraction getFilterNewsButton() {
        return filterNewsButton;
    }

    public ViewInteraction getCategoryField() {
        return categoryField;
    }

    public ViewInteraction getFilterButton() {
        return filterButton;
    }

    public ViewInteraction getFromDate() {
        return fromDate;
    }

    public ViewInteraction getToDate() {
        return toDate;
    }

    public ViewInteraction getDateNewsField() {
        return dateNewsField;
    }

    public ViewInteraction getDateNewsFieldAfterSort() {
        return dateNewsFieldAfterSort;
    }

    public ViewInteraction getControlPanelButton() {
        return controlPanelButton;
    }

    public ViewInteraction getEmptyNewsList() {
        return emptyNewsList;
    }
}