package com.psafe.br.testpsafe.controller;


import android.app.job.JobScheduler;
import android.content.Context;

import com.psafe.br.testpsafe.schedule.CoinSchedule;
import com.psafe.br.testpsafe.task.CacheTask;

/**
 * Created by Gustavo on 26/02/2018.
 */

public class CoinController {

    private CacheTask cacheTask;
    private JobScheduler jobScheduler;
    private Context context;

    public CoinController(Context context) {
        this.context = context;
        cacheTask = new CacheTask();

    }

    public void executeTasks() {
        cacheTask.execute();
        jobScheduler = CoinSchedule.run(context);
    }

    public CacheTask getTask() {
        return cacheTask;
    }

    public JobScheduler getJobScheduler() {
        return jobScheduler;
    }
}
