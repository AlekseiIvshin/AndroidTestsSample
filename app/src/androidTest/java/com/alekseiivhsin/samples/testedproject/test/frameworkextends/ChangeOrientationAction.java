package com.alekseiivhsin.samples.testedproject.test.frameworkextends;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.view.View;

import org.hamcrest.Matcher;

import java.util.Collection;

/**
 * Created on 18/11/2015.
 */
public class ChangeOrientationAction implements ViewAction {

    public static ViewAction orientationLandscape() {
        return new ChangeOrientationAction(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public static ViewAction orientationPortrait() {
        return new ChangeOrientationAction(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private final int mOrientation;

    private ChangeOrientationAction(int orientation) {
        this.mOrientation = orientation;
    }

    @Override
    public Matcher<View> getConstraints() {
        return ViewMatchers.isRoot();
    }

    @Override
    public String getDescription() {
        return "Change orientation to " + mOrientation;
    }

    @Override
    public void perform(UiController uiController, View view) {
        uiController.loopMainThreadUntilIdle();
        final Activity activity = (Activity) view.getContext();
        activity.setRequestedOrientation(mOrientation);

        Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
        if (resumedActivity.isEmpty()) {
            throw new RuntimeException("Could not change orientation");
        }
    }
}
