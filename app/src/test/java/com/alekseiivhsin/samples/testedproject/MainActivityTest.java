package com.alekseiivhsin.samples.testedproject;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

/**
 * Created on 20/11/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21,
        constants = BuildConfig.class)
public class MainActivityTest extends TestCase {

    @Test
    public void clickNext_shouldShowNextActivity() {
        // Given
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        Intent expectedIntent = new Intent(activity, NextActivity.class);

        // When
        activity.findViewById(R.id.show_next).performClick();

        // Then
        Intent nextActivityIntent = Shadows.shadowOf(activity).getNextStartedActivity();
        assertEquals(expectedIntent, nextActivityIntent);
    }
}