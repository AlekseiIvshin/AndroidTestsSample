package com.alekseiivhsin.samples.testedproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alekseiivhsin.samples.testedproject.di.IInjectingClass;
import com.alekseiivhsin.samples.testedproject.di.InjectingClass;

public class NextActivity extends AppCompatActivity {

    private IInjectingClass mInjectedClass;
    private String secretValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ((App)getApplication()).getGraph().inject(this);
        setContentView(R.layout.activity_next);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void setInjectingClass(IInjectingClass injectedClass) {
        this.mInjectedClass = injectedClass;
    }

    public String getSecretValue() {
        return secretValue;
    }
}
