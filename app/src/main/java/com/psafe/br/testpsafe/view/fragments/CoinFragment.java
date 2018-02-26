package com.psafe.br.testpsafe.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.psafe.br.testpsafe.R;
import com.psafe.br.testpsafe.domain.CoinEvent;
import com.psafe.br.testpsafe.model.Coin;
import com.psafe.br.testpsafe.view.adapters.CoinAdapter;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;


/**
 * Created by Gustavo on 26/02/2018.
 */

public class CoinFragment extends Fragment {
    private RecyclerView recyclerView;
    private CoinAdapter adapter;
    private TextView lastUpdate;
    public LinearLayoutManager layoutMananger;


    public CoinFragment() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("PSAFE", "In frag's on create");
        this.setRetainInstance(true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coin, container, false);
        lastUpdate = view.findViewById(R.id.lastUpdate);
        setUpRecyleView(view);
        return view;
    }

    private void setUpRecyleView(View view) {
        recyclerView = view.findViewById(R.id.recycler_coin);
        recyclerView.setHasFixedSize(true);
        layoutMananger = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutMananger);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapter = new CoinAdapter(getActivity(), new ArrayList<Coin>());
        recyclerView.setAdapter(adapter);
    }

    public void onEvent(CoinEvent event) {
        lastUpdate.setText(event.getLastUpdate());
        adapter.setCoins(event.getCoins());
    }
}
