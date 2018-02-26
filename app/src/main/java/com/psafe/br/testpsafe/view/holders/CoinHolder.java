package com.psafe.br.testpsafe.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.psafe.br.testpsafe.R;

/**
 * Created by Gustavo on 26/02/2018.
 */

public class CoinHolder extends RecyclerView.ViewHolder {
    private TextView symbol;
    private TextView name;


    public CoinHolder(View itemView) {
        super(itemView);
        setUpData(itemView);
    }

    private void setUpData(View itemView) {
        symbol = itemView.findViewById(R.id.symbol);
        name = itemView.findViewById(R.id.name);
    }

    public void setSymbol(TextView symbol) {
        this.symbol = symbol;
    }

    public TextView getSymbol() {
        return symbol;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

}
