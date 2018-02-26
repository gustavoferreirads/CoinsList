package com.psafe.br.testpsafe.task;

import android.app.job.JobParameters;
import android.os.AsyncTask;

import com.psafe.br.testpsafe.domain.CoinEvent;
import com.psafe.br.testpsafe.model.Coin;
import com.psafe.br.testpsafe.schedule.CoinSchedule;
import com.psafe.br.testpsafe.service.CoinService;

import java.util.List;

import de.greenrobot.event.EventBus;
import io.realm.Realm;

/**
 * Created by Gustavo on 25/02/2018.
 */

public class CoinFetchTask extends AsyncTask<JobParameters, Void, List<Coin>> {
    private CoinSchedule coinSchedule;
    private CoinService service = new CoinService();

    public CoinFetchTask(CoinSchedule coinSchedule){
        this.coinSchedule = coinSchedule;
    }

    @Override
    public List<Coin> doInBackground(JobParameters... jobParameters) {
        List<Coin> coins = service.getListCoins(Realm.getDefaultInstance());
        coinSchedule.jobFinished(jobParameters[0], true);
        return coins;
    }

    @Override
    public void onPostExecute(List<Coin> coins) {
        EventBus.getDefault().post( new CoinEvent( coins));
    }

}