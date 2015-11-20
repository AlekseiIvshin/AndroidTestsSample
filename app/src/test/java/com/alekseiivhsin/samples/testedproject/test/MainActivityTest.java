package com.alekseiivhsin.samples.testedproject.test;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;

import com.alekseiivhsin.samples.testedproject.BuildConfig;
import com.alekseiivhsin.samples.testedproject.MainActivity;
import com.alekseiivhsin.samples.testedproject.NextActivity;
import com.alekseiivhsin.samples.testedproject.R;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

/**
 * Created on 20/11/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21,
        constants = BuildConfig.class, shadows = {MyShadowAc.class})
public class MainActivityTest extends TestCase {

    @Test
    public void clickNext_shouldShowNextActivity() {
        // Given
        ActivityController<MainActivity> activityController =  Robolectric.buildActivity(MainActivity.class);
        Activity activity = activityController.get();
        MyShadowAc myShadowAc = (MyShadowAc) Shadows.shadowOf(activity);

        Activity activity1 = Mockito.spy(activity);
        Mockito.when(activity1.getContentResolver()).thenReturn(Mockito.mock(ContentResolver.class));

//        myShadowAc.mockContentResolver = Mockito.mock(ContentResolver.class);

        activityController.create().start().resume();

        // When
        activity.findViewById(R.id.show_next).performClick();
        ContentResolver contentResolver = activity.getContentResolver();

        // Then
    }
}