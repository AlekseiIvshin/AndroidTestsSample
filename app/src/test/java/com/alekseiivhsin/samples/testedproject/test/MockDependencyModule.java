package com.alekseiivhsin.samples.testedproject.test;

import com.alekseiivhsin.samples.testedproject.di.DependencyModule;
import com.alekseiivhsin.samples.testedproject.di.IMagicClass;

import org.mockito.Mockito;

/**
 * Created on 20/11/2015.
 */
public class MockDependencyModule extends DependencyModule {

    protected IMagicClass mockMagicClass = Mockito.mock(IMagicClass.class);

    public void setMockMagicClass(IMagicClass mockMagicClass) {
        this.mockMagicClass = mockMagicClass;
    }

    @Override
    public IMagicClass provideMagicClass() {
        return mockMagicClass;
    }

}
