package com.alekseiivhsin.samples.testedproject.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created on 20/11/2015.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainActivityTest.class,
        TestedServiceTest.class,
        NextActivityTest.class})
public class MyTestSuite {

}
