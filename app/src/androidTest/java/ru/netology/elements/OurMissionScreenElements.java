package ru.netology.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.netology.data.DataHelper.childAtPosition;
import static ru.netology.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OurMissionScreenElements {

    private final ViewInteraction recyclerView = onView(
            allOf(withId(R.id.our_mission_item_list_recycler_view),
                    childAtPosition(
                            withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                            0)));

    public ViewInteraction descriptionQuote = onView(withIndex(
            withId(R.id.our_mission_item_description_text_view), 0));

    public ViewInteraction getDescriptionQuote() {
        return descriptionQuote;
    }

    public ViewInteraction getRecyclerView() {
        return recyclerView;
    }
}
