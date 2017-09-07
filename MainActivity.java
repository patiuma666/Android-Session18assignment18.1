package com.example.iis5.androidbatterypercentage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
     //main activity is created
public class MainActivity extends AppCompatActivity {

        // Broadcast Receiver Object is created  along with class definition
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {

        @Override
        // onReceive method is called
        public void onReceive(Context context, Intent intent) {
            context.unregisterReceiver(this);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

            // textview is created from the main.xml file
            TextView textView = (TextView) findViewById(R.id.textView);

            // to Get Battery the battery percentage
            //Sets the  TextView with the  text battery level remaining and the level
            textView.setText("Battery Level Remaining : " + Integer.toString(level) + "%");

        }
    };

    @Override
        //  It is  Called when the activity is first created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Sets layout that is  created
        setContentView(R.layout.activity_main);

        //Register the receiver which triggers  the event
        //when battery charge is changed

        registerReceiver(mBatInfoReceiver, new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED));

    }

}

