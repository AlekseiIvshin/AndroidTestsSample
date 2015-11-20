package com.alekseiivhsin.samples.testedproject.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aleksei Ivshin
 * on 20.09.2015.
 */
@Module
public class DependencyModule {

    @Provides
    @Singleton
    public IInjectingClass provideInjectingClass() {
        return new InjectingClass();
    }
}
