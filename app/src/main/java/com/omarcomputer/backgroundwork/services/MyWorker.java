package com.omarcomputer.backgroundwork.services;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    private static final String TAG = "FileReadWork";
    private Context context;
    private WorkerParameters workerParameters;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
        this.workerParameters = workerParams;
    }

    @NonNull
    @Override
    public Result doWork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i= 0 ;i<=100;i++){
                    Log.i("MyWorker","i : "+i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        );
        return Result.success();
    }


}
