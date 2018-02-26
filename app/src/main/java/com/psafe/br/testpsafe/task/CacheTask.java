package com.psafe.br.testpsafe.task;

import android.os.AsyncTask;

import com.psafe.br.testpsafe.domain.CoinEvent;
import com.psafe.br.testpsafe.model.Coin;
import com.psafe.br.testpsafe.service.CoinService;

import java.util.List;

import de.greenrobot.event.EventBus;
import io.realm.Realm;

public class CacheTask extends AsyncTask<Void, String, List<Coin>> {
	private CoinService service = new CoinService();

    @Override
    protected void onPreExecute() {
    }

    @Override
    public List<Coin> doInBackground(Void... voids) {
        return service.getListCoinsCache( Realm.getDefaultInstance());
    }

	@Override
    public void onPostExecute( List<Coin> params) {
        EventBus.getDefault().post( new CoinEvent( params));
	}
}
