package ru.netology.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutScreenElements {

    private final ViewInteraction privacyPolicy = onView(
            withId(R.id.about_privacy_policy_label_text_view));
    private final ViewInteraction termsOfUse = onView(
            withId(R.id.about_terms_of_use_label_text_view));
    private final ViewInteraction backButton = onView(withId(R.id.about_back_image_button));

    public ViewInteraction getPrivacyPolicy() {
        return privacyPolicy;
    }

    public ViewInteraction getTermsOfUse() {
        return termsOfUse;
    }

    public ViewInteraction getBackButton() {
        return backButton;
    }
}