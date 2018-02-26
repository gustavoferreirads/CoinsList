package com.psafe.br.testpsafe.schedule;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;

import com.psafe.br.testpsafe.task.CoinFetchTask;
/**
 * Created by Gustavo on 26/02/2018.
 */

public class CoinSchedule extends JobService {
    public CoinFetchTask task;

    @Override
    public boolean onStartJob(JobParameters params) {
        task = new CoinFetchTask(this);
        task.execute(params);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    public static JobScheduler run(Context context) {
        ComponentName cp = new ComponentName(context, CoinSchedule.class);
        JobInfo jb = new JobInfo.Builder(1, cp)
                .setPersisted(true)
                .setPeriodic(900000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(false)
                .setRequiresDeviceIdle(false)
                .build();
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(jb);
        return jobScheduler;
    }
}
