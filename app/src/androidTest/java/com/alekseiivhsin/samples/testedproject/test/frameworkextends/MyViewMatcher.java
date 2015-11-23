package com.alekseiivhsin.samples.testedproject.test.frameworkextends;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;

import com.alekseiivhsin.samples.testedproject.views.MyCustomView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;


/**
 * Created on 23/11/2015.
 */
public class MyViewMatcher {

    public static Matcher<View> withInnerText(final Matcher<String> stringMatcher) {
        return new BoundedMatcher<View, MyCustomView>(MyCustomView.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText(" with text: ");
                stringMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(MyCustomView item) {
                return stringMatcher.matches(
                        item.textView1.getText().toString() + " " + item.textView1.getText().toString());
            }
        };
    }
}
