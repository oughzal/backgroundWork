package com.omarcomputer.backgroundwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        // les contrainte : condition pou exécuter le work
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build();

        workManager = WorkManager.getInstance(getApplicationContext());
        workRequest = new PeriodicWorkRequest.Builder(MyWorker.class, 15,TimeUnit.MINUTES)
                .setInitialDelay(1,TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build();
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> startWork());
        btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(v -> stopWork());


    }

    private void startWork(){
        workManager.enqueue(workRequest);
    }
    private void stopWork(){
        workManager.cancelWorkById(workRequest.getId());
    }

}