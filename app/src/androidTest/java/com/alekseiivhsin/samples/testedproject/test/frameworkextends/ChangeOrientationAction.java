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

    public static ViewAction flipOrientation() {
        return new ChangeOrientationAction();
    }

    private final int mOrientation;
    private final boolean mFlipOrientationFlag;

    private ChangeOrientationAction(int orientation) {
        this.mOrientation = orientation;
        this.mFlipOrientationFlag = false;
    }

    private ChangeOrientationAction() {
        this.mOrientation = 0;
        this.mFlipOrientationFlag = true;
    }

    @Override
    public Matcher<View> getConstraints() {
        return ViewMatchers.isRoot();
    }

    @Override
    public String getDescription() {
        if (mFlipOrientationFlag) {
            return "Flip orientation from land to port or vice versa";
        }
        return "Change orientation to " + mOrientation;
    }

    @Override
    public void perform(UiController uiController, View view) {
        uiController.loopMainThreadUntilIdle();
        final Activity activity = (Activity) view.getContext();
        if (mFlipOrientationFlag) {
            setNextOrientation(activity);
        } else {
            setRequestOrientation(activity, mOrientation);
        }

        Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
        if (resumedActivity.isEmpty()) {
            throw new RuntimeException("Could not change orientation");
        }
    }

    private void setNextOrientation(Activity activity) {
        int currentOrientation = activity.getResources().getConfiguration().orientation;
        switch (currentOrientation) {
            case ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE:
                setRequestOrientation(activity, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            case ActivityInfo.SCREEN_ORIENTATION_PORTRAIT:
                setRequestOrientation(activity, ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                break;
            case ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE:
                setRequestOrientation(activity, ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                break;
            case ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT:
                setRequestOrientation(activity, ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            default:
                throw new IllegalArgumentException("Can not handle orientation " + currentOrientation);
        }
    }

    private void setRequestOrientation(Activity activity, int orientation) {
        activity.setRequestedOrientation(orientation);
    }
}
