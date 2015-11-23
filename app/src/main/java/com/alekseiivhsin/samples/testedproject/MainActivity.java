package com.alekseiivhsin.samples.testedproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View mChickenView;
    Button mChickenVisibilityToggle;
    TextView mOrientationLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mChickenView = findViewById(R.id.chicken);
        mChickenVisibilityToggle = (Button) findViewById(R.id.toggle_image_visibility);
        mOrientationLabel = (TextView) findViewById(R.id.orientation_label);

        findViewById(R.id.show_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivityIntent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(nextActivityIntent);
            }
        });

        findViewById(R.id.show_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.message_hello_toast), Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.toggle_image_visibility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (View.VISIBLE == mChickenView.getVisibility()) {
                    mChickenView.setVisibility(View.GONE);
                    mChickenVisibilityToggle.setText(R.string.show_image);
                } else {
                    mChickenView.setVisibility(View.VISIBLE);
                    mChickenVisibilityToggle.setText(R.string.hide_image);
                }
            }
        });

        switch (getResources().getConfiguration().orientation){
            case ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE:
                mOrientationLabel.setText(R.string.label_orientation_land);
                break;
            case ActivityInfo.SCREEN_ORIENTATION_PORTRAIT:
                mOrientationLabel.setText(R.string.label_orientation_port);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
