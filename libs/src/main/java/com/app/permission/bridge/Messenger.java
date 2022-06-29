package com.app.permission.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.app.permission.AndPermission;


class Messenger extends BroadcastReceiver {

    private final Context mContext;
    private final Callback mCallback;

    public Messenger(Context context, Callback callback) {
        this.mContext = context;
        this.mCallback = callback;
    }

    public static void send(Context context, String suffix) {
        Intent broadcast = new Intent(AndPermission.bridgeAction(context, suffix));
        context.sendBroadcast(broadcast);
    }

    public void register(String suffix) {
        IntentFilter filter = new IntentFilter(AndPermission.bridgeAction(mContext, suffix));
        mContext.registerReceiver(this, filter);
    }

    public void unRegister() {
        mContext.unregisterReceiver(this);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mCallback.onCallback();
    }

    public interface Callback {

        void onCallback();
    }
}