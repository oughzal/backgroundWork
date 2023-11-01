package com.omarcomputer.backgroundwork.services;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FileReadWork extends Worker {
    private static final String TAG = "FileReadWork";
    private Context context;
    private WorkerParameters workerParameters;

    public FileReadWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
        this.workerParameters = workerParams;
    }

    @NonNull
    @Override
    public Result doWork() {
        return null;
    }
}
