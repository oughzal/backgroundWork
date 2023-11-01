package com.omarcomputer.backgroundwork.services;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class MyJobService extends JobService {
    public boolean jobCancelled=false;
    @Override
    public boolean onStartJob(JobParameters params) {
        doBackground(params);
        return false;
    }

    private void doBackground(JobParameters params) {
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

}
