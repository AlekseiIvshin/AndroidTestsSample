package com.alekseiivhsin.samples.testedproject.test;

import com.alekseiivhsin.samples.testedproject.BuildConfig;
import com.alekseiivhsin.samples.testedproject.NextActivity;
import com.alekseiivhsin.samples.testedproject.di.IInjectingClass;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.util.ActivityController;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on 20/11/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21,
        constants = BuildConfig.class,
        application = TestApp.class)
public class NextActivityTest {

    IInjectingClass mockInjectingClass = mock(IInjectingClass.class);

    MockDependencyModule mockDependencyModule = new MockDependencyModule();

    @Before
    public void setUp(){
        mockDependencyModule.setMockInjectingClass(mockInjectingClass);
        ((TestApp) ShadowApplication.getInstance().getApplicationContext()).reinitializeObjectGraph(mockDependencyModule);
    }

    @Test
    public void onActivityStart_shouldGetSecretValue() {
        // Given
        // init mock
        when(mockInjectingClass.getMagicValue()).thenReturn("TEST VALUE");

        // Prepare tested activity for test lifecycle
        ActivityController<NextActivity> activityController = Robolectric.buildActivity(NextActivity.class)
                .create();
        NextActivity nextActivity = activityController.get();


        // When
        activityController.start();

        // Then
        // Check that we call injecting class for get magic value
        verify(mockInjectingClass, times(1)).getMagicValue();
        // Check that magic value get from injecting class equals to expected
        Assert.assertEquals("Values should be equals", "TEST VALUE", nextActivity.getSecretValue());
    }
}
