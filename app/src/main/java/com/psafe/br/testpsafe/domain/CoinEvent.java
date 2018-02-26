package com.psafe.br.testpsafe.domain;

import com.psafe.br.testpsafe.model.Coin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Gustavo on 26/02/2018.
 */

public class CoinEvent {
    private List<Coin> coins;
    private String lastUpdate;

    public CoinEvent(List<Coin> coins){
        this.coins = coins;
        this.lastUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",  new Locale("pt","BR")).format(new Date());
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

}
