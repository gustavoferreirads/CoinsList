package com.psafe.br.testpsafe.schedule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Gustavo on 25/02/2018.
 */

public class StartServiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        CoinSchedule.run(context);
    }
}
