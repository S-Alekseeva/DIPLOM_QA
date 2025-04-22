package ru.netology.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.netology.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterScreenElements {

    public ViewInteraction categoryField = onView(
            withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction fromDateField = onView(
            withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction toDateField = onView(
            withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction filterButton = onView(
            withId(R.id.filter_button));
    public ViewInteraction cancelButton = onView(
            withId(R.id.cancel_button));
    public ViewInteraction checkBoxActive = onView(
            withId(R.id.filter_news_active_material_check_box));
    public ViewInteraction checkBoxNotActive = onView(
            withId(R.id.filter_news_inactive_material_check_box));
    public ViewInteraction newsStatus = onView(
            withIndex(withId(R.id.news_item_published_text_view), 0));

    public ViewInteraction getCheckBoxActive() {
        return checkBoxActive;
    }

    public ViewInteraction getCheckBoxNotActive() {
        return checkBoxNotActive;
    }

    public ViewInteraction getFilterButton() {
        return filterButton;
    }

    public ViewInteraction getNewsStatus() {
        return newsStatus;
    }
}
