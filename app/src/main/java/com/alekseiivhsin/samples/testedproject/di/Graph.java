package com.alekseiivhsin.samples.testedproject.di;

import com.alekseiivhsin.samples.testedproject.NextActivity;
import com.alekseiivhsin.samples.testedproject.TestedService;

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

    void inject(TestedService testedService);

    final class Initializer {
        public static Graph init() {
            return DaggerGraph.builder().dependencyModule(new DependencyModule()).build();
        }
    }
}
