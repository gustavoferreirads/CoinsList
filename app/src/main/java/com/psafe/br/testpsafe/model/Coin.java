package com.psafe.br.testpsafe.model;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Gustavo on 26/02/2018.
 */

public class Coin extends RealmObject {
    private String id;
    private String name;
    private String symbol;
    private Integer rank;
    private String priceUsd;
    private String priceBtc;
    private String volumeUsd;
    private String marketCapUsd;
    private String availableSupply;
    private String totalSupply;
    private String percentChange1hr;
    private String percentChange24hr;
    private String percentChange7d;
    private Date lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public String getVolumeUsd() {
        return volumeUsd;
    }

    public void setVolumeUsd(String volumeUsd) {
        this.volumeUsd = volumeUsd;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getPercentChange1hr() {
        return percentChange1hr;
    }

    public void setPercentChange1hr(String percentChange1hr) {
        this.percentChange1hr = percentChange1hr;
    }

    public String getPercentChange24hr() {
        return percentChange24hr;
    }

    public void setPercentChange24hr(String percentChange24hr) {
        this.percentChange24hr = percentChange24hr;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }



}

//            "id": "bitcoin",
//            "nome": "Bitcoin",
//            "símbolo": "BTC",
//            "rank": "1",
//            "price_usd": "573.137",
//            "price_btc": "1.0",
//            "24h_volume_usd": "72855700.0",
//            "market_cap_usd": "9080883500.0",
//            "available_supply": "15844176.0",
//            "total_supply": "15844176.0",
//            "percent_change_1h": "0.04",
//            "percent_change_24h": "-0.3",
//            "percent_change_7d": "-0.57",
//            "last_updated": "1472762067"