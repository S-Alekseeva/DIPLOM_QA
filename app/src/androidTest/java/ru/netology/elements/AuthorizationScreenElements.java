package ru.netology.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationScreenElements {

    private final ViewInteraction authorization = onView(
            allOf(withText("Authorization"),
                    withParent(withParent(withId(R.id.nav_host_fragment)))));
    private final ViewInteraction loginField = onView(
            anyOf(withHint("Login")));
    private final ViewInteraction passwordField = onView(
            allOf(withHint("Password")));
    private final ViewInteraction button = onView(withId(R.id.enter_button));

    public ViewInteraction getAuthorization() {
        return authorization;
    }

    public ViewInteraction getLoginField() {
        return loginField;
    }

    public ViewInteraction getPasswordField() {
        return passwordField;
    }

    public ViewInteraction getButton() {
        return button;
    }
}