package com.alekseiivhsin.samples.testedproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.alekseiivhsin.samples.testedproject.di.IMagicClass;

import javax.inject.Inject;

public class TestedService extends Service {
    public static final String GET_MAGIC_VALUE_ACTION = "testedapp.actions.GET_MAGIC_VALUE_ACTION";

    @Inject
    IMagicClass mMagicClass;

    private String mMagicValue;

    public TestedService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ((App)getApplication()).getGraph().inject(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        if(action!=null && GET_MAGIC_VALUE_ACTION.equalsIgnoreCase(action)){
            mMagicValue = mMagicClass.getMagicValue();
        }
        return START_NOT_STICKY;
    }
}
