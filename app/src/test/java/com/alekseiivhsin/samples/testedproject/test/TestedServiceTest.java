package com.alekseiivhsin.samples.testedproject.test;

import com.alekseiivhsin.samples.testedproject.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created on 20/11/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21,
        constants = BuildConfig.class)
public class TestedServiceTest {

    @Test
    public void intent_shouldStartService() {
    }
}
