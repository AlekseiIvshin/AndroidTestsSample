package com.alekseiivhsin.samples.testedproject.test;

import com.alekseiivhsin.samples.testedproject.di.DependencyModule;
import com.alekseiivhsin.samples.testedproject.di.IInjectingClass;

import org.mockito.Mockito;

/**
 * Created on 20/11/2015.
 */
public class MockDependencyModule extends DependencyModule {

    protected IInjectingClass mockInjectingClass = Mockito.mock(IInjectingClass.class);

    public void setMockInjectingClass(IInjectingClass mockInjectingClass) {
        this.mockInjectingClass = mockInjectingClass;
    }

    @Override
    public IInjectingClass provideInjectingClass() {
        return mockInjectingClass;
    }

}
