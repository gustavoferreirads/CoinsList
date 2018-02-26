package com.psafe.br.testpsafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.psafe.br.testpsafe.controller.CoinController;
import com.psafe.br.testpsafe.view.fragments.CoinFragment;

public class MainActivity extends AppCompatActivity {

    private CoinFragment coinFragment;
    private String TAG_FRAGMENT = "LIST_FRAGMENT";
    private CoinController controller = new CoinController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpFragment(savedInstanceState);
        controller.executeTasks();
    }

    private void setUpFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            coinFragment = (CoinFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT);
            return;
        }
        coinFragment = new CoinFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, coinFragment, TAG_FRAGMENT)
                .commit();
    }
}
