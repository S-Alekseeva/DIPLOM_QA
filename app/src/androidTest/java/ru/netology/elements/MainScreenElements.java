package ru.netology.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.netology.data.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainScreenElements {

    private final ViewInteraction mainMenuButton = onView(
            withId(R.id.main_menu_image_button));

    private final ViewInteraction ourMissionButton = onView(
            withId(R.id.our_mission_image_button));

    private final ViewInteraction news = onView(
            (withText("News")));

    private final ViewInteraction about = onView(
            (withText("About")));

    private final ViewInteraction expandMaterialButton = onView(
            withId(R.id.expand_material_button));
    private final ViewInteraction newsList = onView(
            withId(R.id.news_list_recycler_view));
    private final ViewInteraction viewNews = onView(
            withId(R.id.view_news_item_image_view));
    private final ViewInteraction expandNews = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_news_cards_block_constraint_layout),
                                0)));
    private final ViewInteraction allNewsButton = onView(
            withId(R.id.all_news_text_view));

    private final ViewInteraction newsAllNews = onView(
            (withText("News")));

    private final ViewInteraction sortNews = onView(
            withId(R.id.sort_news_material_button));

    private final ViewInteraction filterNews = onView(
            withId(R.id.filter_news_material_button));

    private final ViewInteraction editNews = onView(
            withId(R.id.edit_news_material_button));

    private final ViewInteraction authorizationButton = onView(
            withId(R.id.authorization_image_button));

    private final ViewInteraction exitButton = onView(withText("Log out"));

    public ViewInteraction getMainMenuButton() {
        return mainMenuButton;
    }

    public ViewInteraction getOurMissionButton() {
        return ourMissionButton;
    }

    public ViewInteraction getNews() {
        return news;
    }

    public ViewInteraction getAbout() {
        return  about;
    }

    public ViewInteraction getExpandMaterialButton() {
        return expandMaterialButton;
    }

    public ViewInteraction getNewsList() {
        return newsList;
    }

    public ViewInteraction getViewNews() {
        return viewNews;
    }

    public ViewInteraction getExpandNews() {
        return expandNews;
    }

    public ViewInteraction getAllNewsButton() {
        return allNewsButton;
    }

    public ViewInteraction getNewsAllNews() {
        return newsAllNews;
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
    private final ViewInteraction logOut = onView((withId(R.id.authorization_image_button)));

    public ViewInteraction getLogOut() {
        return logOut;
    }

    public ViewInteraction getExitButton() {
        return exitButton;
    }

    private final ViewInteraction tradeMark = onView(withId(R.id.trademark_image_view));

    public ViewInteraction getTradeMark() {
        return  tradeMark;
    }

    public ViewInteraction getAuthorizationButton() {
        return  authorizationButton;
    }
}