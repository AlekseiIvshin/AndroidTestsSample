package com.alekseiivhsin.samples.testedproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.alekseiivhsin.samples.testedproject.di.IInjectingClass;

import javax.inject.Inject;

public class NextActivity extends AppCompatActivity {

    @Inject
    IInjectingClass mInjectedClass;


    private String secretValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getObjectGraph().inject(this);
        setContentView(R.layout.activity_next);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        secretValue = mInjectedClass.getMagicValue();
    }

    public String getSecretValue() {
        return secretValue;
    }
}
