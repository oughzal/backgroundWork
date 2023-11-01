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
    private int i=0;


    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
        this.workerParameters = workerParams;


    }

    @NonNull
    @Override
    public Result doWork() {
            Log.i("MyWorker", "Work done");
        return Result.success();
    }


}
