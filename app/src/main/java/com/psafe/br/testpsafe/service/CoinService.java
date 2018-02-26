package com.psafe.br.testpsafe.service;

import android.util.Log;

import com.psafe.br.testpsafe.model.Coin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Gustavo on 26/02/2018.
 */
public class CoinService {
    private final String TAG = "PSAFE";
    private final String URL_COIN = "https://api.coinmarketcap.com/v1/ticker/?limit=10";

    public List<Coin> getListCoins(Realm realm) {
        String json = getHttpListCoinJson();
        if (json == null) {
            return new ArrayList<>();
        }
        realm.beginTransaction();
        realm.delete(Coin.class);
        realm.createAllFromJson(Coin.class, json);
        realm.commitTransaction();
        List <Coin> coins = realm.copyFromRealm(realm.where(Coin.class).findAll());
        realm.close();
        return coins;
    }

    public List<Coin> getListCoinsCache(Realm realm) {
        List<Coin> coins =  realm.copyFromRealm(realm.where(Coin.class).findAll());
        if (coins.size() > 0) {
            realm.close();
            return coins;
        }
        return getListCoins(realm);
    }

    private String getHttpListCoinJson() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(URL_COIN).openConnection();
            InputStream stream = connection.getInputStream();
            String json = toString(stream);
            stream.close();
            return json;
        } catch (Exception e) {
            Log.e(TAG, "Fail on access webservice", e);
        }
        return null;
    }

    private String toString(InputStream is) throws IOException {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int reads;
        while ((reads = is.read(bytes)) > 0) {
            baos.write(bytes, 0, reads);
        }
        return new String(baos.toByteArray());
    }

}

