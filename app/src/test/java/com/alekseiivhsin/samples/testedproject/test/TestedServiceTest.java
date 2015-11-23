package com.alekseiivhsin.samples.testedproject.test;

import android.content.Intent;

import com.alekseiivhsin.samples.testedproject.BuildConfig;
import com.alekseiivhsin.samples.testedproject.TestedService;
import com.alekseiivhsin.samples.testedproject.di.IMagicClass;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

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
public class TestedServiceTest {

    public static final String GET_MAGIC_VALUE_ACTION = "testedapp.actions.GET_MAGIC_VALUE_ACTION";

    IMagicClass mockInjectingClass = mock(IMagicClass.class);

    MockDependencyModule mockDependencyModule = new MockDependencyModule();

    @Before
    public void setUp(){
        mockDependencyModule.setMockMagicClass(mockInjectingClass);
        ((TestApp) ShadowApplication.getInstance().getApplicationContext())
                .reinitializeObjectGraph(mockDependencyModule);
    }

    @Test
    public void intent_shouldHandleCommand() {
        // Given
        when(mockInjectingClass.getMagicValue()).thenReturn("TEST VALUE");

        Intent command = new Intent(GET_MAGIC_VALUE_ACTION);
        TestedService testedService = Robolectric.setupService(TestedService.class);

        verify(mockInjectingClass, times(0)).getMagicValue();

        // When
        testedService.onStartCommand(command, 0,0);

        // Then
        verify(mockInjectingClass, times(1)).getMagicValue();
    }
}
