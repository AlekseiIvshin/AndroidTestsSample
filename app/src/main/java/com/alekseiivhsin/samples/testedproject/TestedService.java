package com.alekseiivhsin.samples.testedproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TestedService extends Service {
    public TestedService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
