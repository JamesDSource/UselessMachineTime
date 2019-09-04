package com.example.uselessmachinetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean on = false;
    private Button bFlip;
    private Button bShut_down;
    private Button bBusy;
    private TextView tvSwitch;
    private ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // wiring
        bShut_down = findViewById(R.id.bShut_down);
        bFlip = findViewById(R.id.bFlip);
        bBusy = findViewById(R.id.bBusy);
        pbLoading = findViewById(R.id.pbLoading);
        tvSwitch = findViewById(R.id.tvSwitch);
        tvSwitch.setText("OFF");
        pbLoading.setVisibility(View.INVISIBLE);
        // setting listeners
        bShut_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while (0 == 0) {
                }
            }
        });
        bFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Flip();
            }
        });
        bBusy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bFlip.setVisibility(view.GONE);
                bBusy.setVisibility(view.GONE);
                bShut_down.setVisibility(View.GONE);
                tvSwitch.setText("Loading important documents");
                pbLoading.setVisibility(View.VISIBLE);
                new CountDownTimer(10000, 100) {
                    int count = 0;

                    @Override
                    public void onTick(long l) {
                        count++;
                        pbLoading.setProgress(count);
                        if(pbLoading.getProgress() >= 20) Toast.makeText(MainActivity.this, "Overloading from working too hard", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFinish() {
                        finish();
                    }
                };
            }
        });
    }
        public void Flip() {
            if (on) {
                on = false;
                tvSwitch.setText("OFF");
            }
            else {
                on = true;
                tvSwitch.setText("ON");
            }
        }
    }