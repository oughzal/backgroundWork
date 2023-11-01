package com.omarcomputer.backgroundwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.omarcomputer.backgroundwork.services.MyWorker;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private WorkManager workManager;
    private WorkRequest workRequest;
    Button btnStart, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workManager = WorkManager.getInstance(getApplicationContext());
        workRequest = new PeriodicWorkRequest.Builder(MyWorker.class, 2,TimeUnit.MINUTES ).build();
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWork();
            }
        });
        btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopWork();
            }
        });

    }

    private void startWork(){
        workManager.enqueue(workRequest);
    }
    private void stopWork(){
        workManager.cancelWorkById(workRequest.getId());
    }
}