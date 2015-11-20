package com.alekseiivhsin.samples.testedproject;

import android.app.Application;

import com.alekseiivhsin.samples.testedproject.di.Graph;

/**
 * Created on 20/11/2015.
 */
public class App extends Application {

    private Graph mGraph;
    private static App mInstance;

    public static App getInstance(){
        return mInstance;
    }

    public static Graph getObjectGraph(){
        return mInstance.getGraph();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mGraph = Graph.Initializer.init(false);
        mInstance = this;
    }

    public Graph getGraph(){
        return mGraph;
    }
}
