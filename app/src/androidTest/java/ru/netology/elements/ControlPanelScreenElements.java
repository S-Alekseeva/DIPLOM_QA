package ru.netology.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.netology.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelScreenElements {

    private final ViewInteraction controlPanelScreenName = onView(withText("Control panel"));


    private final ViewInteraction sortNewsButton = onView(
            withId(R.id.sort_news_material_button));

    private final ViewInteraction filterNewsButton = onView(
            withId(R.id.filter_news_material_button));

    private final ViewInteraction createNewsButton = onView(
            withId(R.id.add_news_image_view));

    private final ViewInteraction recyclerViewNewsList = onView(
            withId(R.id.news_list_recycler_view));

    private final ViewInteraction firstNews = onView(
            withIndex(withId(R.id.news_item_material_card_view), 0));

    private final ViewInteraction viewDescriptionNews = onView(
            withIndex(withId(R.id.news_item_description_text_view), 0));

    private final ViewInteraction deleteFirstNewsButton = onView(
            withIndex(withId(R.id.delete_news_item_image_view), 0));
    ;

    private final ViewInteraction cancelButton = onView(withText("CANCEL"));
    ;

    private final ViewInteraction okButton = onView(withText("OK"));

    private final ViewInteraction newsItemTitle = onView(
            withIndex(withId(R.id.news_item_title_text_view), 0));

    private final ViewInteraction newsItemTitleAfterDelete = onView(
            withIndex(withId(R.id.news_item_title_text_view), 0));

    private final ViewInteraction categoryField = onView(
            withId(R.id.news_item_category_text_auto_complete_text_view));

    private final ViewInteraction titleField = onView(
            withId(R.id.news_item_title_text_input_edit_text));

    private final ViewInteraction publicationDateField = onView(
            withId(R.id.news_item_publish_date_text_input_edit_text));

    private final ViewInteraction timeField = onView(
            withId(R.id.news_item_publish_time_text_input_edit_text));

    private final ViewInteraction descriptionField = onView(
            withId(R.id.news_item_description_text_input_edit_text));

    private final ViewInteraction toggleSwitches = onView(
            withId(R.id.switcher));

    private final ViewInteraction saveButton = onView(
            withId(R.id.save_button));

    private final ViewInteraction cancelButtonEdit = onView(
            withId(R.id.cancel_button));

    private final ViewInteraction editNewsButton = onView(
            withIndex(withId(R.id.edit_news_item_image_view), 0));

    public ViewInteraction getControlPanelScreenName() {
        return controlPanelScreenName;
    }

    public ViewInteraction getSortNewsButton() {
        return sortNewsButton;
    }

    public ViewInteraction getFilterNewsButton() {
        return filterNewsButton;
    }

    public ViewInteraction getCreateNewsButton() {
        return createNewsButton;
    }

    public ViewInteraction getRecyclerViewNewsList() {
        return recyclerViewNewsList;
    }

    public ViewInteraction getFirstNews() {
        return firstNews;
    }

    public ViewInteraction getViewDescriptionNews() {
        return viewDescriptionNews;
    }

    public ViewInteraction getDeleteFirstNewsButton() {
        return deleteFirstNewsButton;
    }

    public ViewInteraction getCancelButton() {
        return cancelButton;
    }

    public ViewInteraction getOkButton() {
        return okButton;
    }

    public ViewInteraction getNewsItemTitle() {
        return newsItemTitle;
    }

    public ViewInteraction getNewsItemTitleAfterDelete() {
        return newsItemTitleAfterDelete;
    }

    public ViewInteraction getCategoryField() {
        return categoryField;
    }

    public ViewInteraction getTitleField() {
        return titleField;
    }

    public ViewInteraction getPublicationDateField() {
        return publicationDateField;
    }

    public ViewInteraction getTimeField() {
        return timeField;
    }

    public ViewInteraction getDescriptionField() {
        return descriptionField;
    }

    public ViewInteraction getToggleSwitches() {
        return toggleSwitches;
    }

    public ViewInteraction getSaveButton() {
        return saveButton;
    }

    public ViewInteraction getCancelButtonEdit() {
        return cancelButtonEdit;
    }

    public ViewInteraction getEditNewsButton() {
        return editNewsButton;
    }
}