package com.alekseiivhsin.samples.testedproject.test;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

import com.alekseiivhsin.samples.testedproject.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created on 20/11/2015.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onActivityLoad_shouldHasRightTitle() {
        onView(
                allOf(
                        withParent(isAssignableFrom(Toolbar.class)),
                        isAssignableFrom(TextView.class)))
                .check(matches(withText("Main Activity")));
    }

    @Test
    @MediumTest
    public void onClickShowMessage_shouldShowToast(){
        // Given
        ViewInteraction showMessage = onView(withId(com.alekseiivhsin.samples.testedproject.R.id.show_message));

        // When
        showMessage.perform(click());

        // Then
        onView(withText("Hello! I'm toast message!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
}
