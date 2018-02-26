package com.psafe.br.testpsafe.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.psafe.br.testpsafe.R;
import com.psafe.br.testpsafe.model.Coin;
import com.psafe.br.testpsafe.view.holders.CoinHolder;

import java.util.List;

/**
 * Created by Gustavo on 26/02/2018.
 */

public class CoinAdapter extends RecyclerView.Adapter<CoinHolder> {

    private List<Coin> coins;

    public CoinAdapter(Context context, List<Coin> coins) {
        this.coins = coins;
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public CoinHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new CoinHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_coin, parent, false));
    }

    @Override
    public void onBindViewHolder(CoinHolder holder, int position) {
        holder.getSymbol().setText(coins.get(position).getSymbol());
        holder.getName().setText(coins.get(position).getName());
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return coins != null ? coins.size() : 0;
    }
}
