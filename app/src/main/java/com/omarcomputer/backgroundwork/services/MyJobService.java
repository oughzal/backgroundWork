package com.omarcomputer.backgroundwork.services;



import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;



@SuppressLint("SpecifyJobSchedulerIdRange")
public class MyJobService extends JobService {
    private static String TAG ="MyJobServiceTag";
    public boolean jobCancelled=false;
    @Override
    public boolean onStartJob(JobParameters params) {
        doBackground(params);
        return false;
    }


    private void doBackground(JobParameters params) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    Log.d(TAG, "run : "+i);
                    if(jobCancelled)
                        return;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d(TAG, "job terminé");
                jobFinished(params, false);
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

}
