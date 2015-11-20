package com.alekseiivhsin.samples.testedproject.test;

import android.content.ContentResolver;
import android.util.Log;

import com.alekseiivhsin.samples.testedproject.MainActivity;

import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.shadows.ShadowActivity;

/**
 * Created on 20/11/2015.
 */
@Implements(MainActivity.class)
public class MyShadowAc  extends ShadowActivity{

    public ContentResolver mockContentResolver;

    @RealObject
    private MainActivity mainActivity;

    @Override
    public ContentResolver getContentResolver() {
        Log.v("OLOLO", "Get Content resolver");
        return mockContentResolver;
    }
}
