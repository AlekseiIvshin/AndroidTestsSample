package com.alekseiivhsin.samples.testedproject.test;

import com.alekseiivhsin.samples.testedproject.App;
import com.alekseiivhsin.samples.testedproject.di.DaggerGraph;
import com.alekseiivhsin.samples.testedproject.di.DependencyModule;
import com.alekseiivhsin.samples.testedproject.di.Graph;

/**
 * Created on 20/11/2015.
 */
public class TestApp extends App {

    @Override
    protected Graph initObjectGraph() {
        return DaggerGraph.builder().dependencyModule(new MockDependencyModule()).build();
    }

    public void reinitializeObjectGraph(DependencyModule dependencyModule) {
        if (dependencyModule == null) {
            dependencyModule = new MockDependencyModule();
        }
        mGraph = DaggerGraph.builder().dependencyModule(dependencyModule).build();
    }
}
