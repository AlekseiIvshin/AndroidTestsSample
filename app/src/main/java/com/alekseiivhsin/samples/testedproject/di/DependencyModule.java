package com.alekseiivhsin.samples.testedproject.di;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aleksei Ivshin
 * on 20.09.2015.
 */
@Module
public class DependencyModule {

    private final boolean mMockMode;

    public DependencyModule(boolean mockMode) {
        mMockMode = mockMode;
    }

    @Provides
    @Singleton
    public InjectingClass provideInjectingClass() {
        if (mMockMode) {
            return Mockito.mock(InjectingClass.class);
        } else {
            return new InjectingClass();
        }
    }
}
