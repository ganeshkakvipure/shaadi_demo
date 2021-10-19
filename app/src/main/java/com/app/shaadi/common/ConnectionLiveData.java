package com.app.shaadi.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.lifecycle.LiveData;
import com.app.shaadi.model.ConnectionModel;
import com.app.shaadi.network.NetworkHelper;

public class ConnectionLiveData extends LiveData<ConnectionModel> {

    private Context context;
    private BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
                //check internet connection
                if (!NetworkHelper.isConnectedOrConnecting(context)) {
                    boolean show = false;
                    if (NetworkHelper.lastNoConnectionTs == -1) {//first time
                        show = true;
                        NetworkHelper.lastNoConnectionTs = System.currentTimeMillis();
                    } else {
                        if (System.currentTimeMillis() - NetworkHelper.lastNoConnectionTs > 1000) {
                            show = true;
                            NetworkHelper.lastNoConnectionTs = System.currentTimeMillis();
                        }
                    }

                    if (show && NetworkHelper.isOnline) {
                        NetworkHelper.isOnline = false;
                        postValue(new ConnectionModel(false));
                    }
                } else {
                    postValue(new ConnectionModel(true));
                    NetworkHelper.isOnline = true;
                }
            }
        }
    };

    public ConnectionLiveData(Context context) {
        this.context = context;
    }

    @Override
    protected void onActive() {
        super.onActive();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(networkReceiver, filter);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        context.unregisterReceiver(networkReceiver);
    }


}
