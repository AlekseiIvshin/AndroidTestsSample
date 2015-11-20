package com.alekseiivhsin.samples.testedproject;

import android.app.Application;

import com.alekseiivhsin.samples.testedproject.di.Graph;

/**
 * Created on 20/11/2015.
 */
public class App extends Application {

    protected Graph mGraph;
    protected static App mInstance;

    public static Graph getObjectGraph(){
        return mInstance.getGraph();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mGraph = initObjectGraph();
        mInstance = this;
    }

    protected Graph initObjectGraph(){
        return Graph.Initializer.init();
    }

    public Graph getGraph(){
        return mGraph;
    }
}
