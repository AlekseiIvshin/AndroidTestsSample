package com.alekseiivhsin.samples.testedproject.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.alekseiivhsin.samples.testedproject.NextActivity;
import com.alekseiivhsin.samples.testedproject.R;
import com.alekseiivhsin.samples.testedproject.test.frameworkextends.MyViewMatcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.startsWith;

/**
 * Created on 20/11/2015.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class NextActivityTest {
    @Rule
    public ActivityTestRule<NextActivity> mActivityRule = new ActivityTestRule<>(NextActivity.class);


//    @Test
//    @MediumTest
//    public void onLoad_shouldHasMatchedCustomView() {
//        onView(withId(R.id.my_custom_view))
//                .check(matches(MyViewMatcher.withInnerText(startsWith("Hello"))));
//    }


}
