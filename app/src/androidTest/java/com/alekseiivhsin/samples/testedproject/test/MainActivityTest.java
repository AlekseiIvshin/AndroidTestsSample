package com.alekseiivhsin.samples.testedproject.test;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

import com.alekseiivhsin.samples.testedproject.MainActivity;
import com.alekseiivhsin.samples.testedproject.R;
import com.alekseiivhsin.samples.testedproject.test.frameworkextends.ChangeOrientationAction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
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
    public void onClickShowMessage_shouldShowToast() {
        // Given
        ViewInteraction showMessage = onView(withId(com.alekseiivhsin.samples.testedproject.R.id.show_message));

        // When
        showMessage.perform(click());

        // Then
        onView(withText("Hello! I'm toast message!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void clickHideImage_shouldHideImageAndChangeButtonText() {
        // Given
        ViewInteraction visibilityController = onView(withId(R.id.toggle_image_visibility));
        visibilityController.check(matches(withText("Hide image")));

        ViewInteraction chickenImage = onView(withId(R.id.chicken));
        chickenImage.check(matches(isDisplayed()));

        // When
        visibilityController.perform(click());

        // Then
        visibilityController.check(matches(withText("Show image")));
        chickenImage.check(matches(not(isDisplayed())));
    }

//    @LargeTest
//    @Test
//    public void onOrientationChangedToLand_shouldShowCurrentOrientationDescription() {
//        // When
//        onView(isRoot()).perform(ChangeOrientationAction.orientationLandscape());
//
//        // Then
//        onView(withText("Landscape orientation")).check(matches(isDisplayed()));
//    }
//
//    @LargeTest
//    @Test
//    public void onOrientationChangedToPort_shouldShowCurrentOrientationDescription() {
//        // When
//        onView(isRoot()).perform(ChangeOrientationAction.orientationPortrait());
//
//        // Then
//        onView(withText("Portrait orientation")).check(matches(isDisplayed()));
//    }

}
