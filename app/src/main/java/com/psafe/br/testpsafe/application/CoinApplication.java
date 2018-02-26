package com.psafe.br.testpsafe.application;

import android.app.Application;

import io.realm.Realm;

public class CoinApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
    }
}
