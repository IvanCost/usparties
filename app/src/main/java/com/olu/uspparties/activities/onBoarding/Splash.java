package com.olu.uspparties.activities.onBoarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.olu.uspparties.R;
import com.olu.uspparties.activities.home.Home;

public class Splash extends AppCompatActivity {

    private static int TIMMER = 3000;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent i = new Intent(getApplicationContext(), Tips.class);
                    startActivity(i);
                    finish();
            }
        }, 2000);
    }
}
