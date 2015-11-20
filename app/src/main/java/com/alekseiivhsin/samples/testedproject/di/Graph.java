package com.alekseiivhsin.samples.testedproject.di;

import com.alekseiivhsin.samples.testedproject.NextActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aleksei Ivshin
 * on 05.10.2015.
 */
@Singleton
@Component(modules = DependencyModule.class)
public interface Graph {

    void inject(NextActivity nextActivity);

    final class Initializer {
        public static Graph init(boolean mockMode) {
            return DaggerGraph.builder().dependencyModule(new DependencyModule(mockMode)).build();
        }
    }
}
