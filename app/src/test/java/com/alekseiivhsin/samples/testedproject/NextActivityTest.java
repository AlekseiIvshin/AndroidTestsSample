package com.alekseiivhsin.samples.testedproject;

import com.alekseiivhsin.samples.testedproject.di.Graph;
import com.alekseiivhsin.samples.testedproject.di.IInjectingClass;
import com.alekseiivhsin.samples.testedproject.di.InjectingClass;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.util.ActivityController;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on 20/11/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21,
        constants = BuildConfig.class,
        application = App.class)
public class NextActivityTest {

    @Test
    public void onActivityStart_shouldGetSecretValue() {
        // Given
        ActivityController<NextActivity> activityController = Robolectric.buildActivity(NextActivity.class)
                .create();
        NextActivity nextActivity = activityController.get();

        IInjectingClass mockInjectingClass = Mockito.mock(IInjectingClass.class);
        when(mockInjectingClass.getValue()).thenReturn("TEST VALUE");

        nextActivity.setInjectingClass(mockInjectingClass);

        // When
        activityController.start();

        // Then
        Assert.assertEquals("Values should be equals", "TEST VALUE", nextActivity.getSecretValue());
        verify(mockInjectingClass,times(1)).getValue();
    }
}
