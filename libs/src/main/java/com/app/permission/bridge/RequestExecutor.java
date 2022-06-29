package com.app.permission.bridge;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.app.permission.AndPermission;

import java.util.List;


final class RequestExecutor extends Thread implements com.app.permission.bridge.Messenger.Callback {

    private com.app.permission.bridge.BridgeRequest mRequest;
    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBridge iBridge = IBridge.Stub.asInterface(iBinder);
            try {
                executeCurrent(iBridge);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private com.app.permission.bridge.Messenger mMessenger;

    public RequestExecutor(com.app.permission.bridge.BridgeRequest request) {
        this.mRequest = request;
    }

    @Override
    public void run() {
        Context context = mRequest.getSource().getContext();

        mMessenger = new com.app.permission.bridge.Messenger(context, this);
        mMessenger.register(getName());

        Intent intent = new Intent();
        intent.setAction(AndPermission.bridgeAction(context, null));
        intent.setPackage(context.getPackageName());
        context.bindService(intent, mConnection, Service.BIND_AUTO_CREATE);
    }

    private void executeCurrent(IBridge iBridge) throws RemoteException {
        switch (mRequest.getType()) {
            case com.app.permission.bridge.BridgeRequest.TYPE_APP_DETAILS: {
                iBridge.requestAppDetails(getName());
                break;
            }
            case com.app.permission.bridge.BridgeRequest.TYPE_PERMISSION: {
                List<String> permissions = mRequest.getPermissions();
                String[] array = permissions.toArray(new String[0]);
                iBridge.requestPermission(getName(), array);
                break;
            }
            case com.app.permission.bridge.BridgeRequest.TYPE_INSTALL: {
                iBridge.requestInstall(getName());
                break;
            }
            case com.app.permission.bridge.BridgeRequest.TYPE_OVERLAY: {
                iBridge.requestOverlay(getName());
                break;
            }
            case com.app.permission.bridge.BridgeRequest.TYPE_ALERT_WINDOW: {
                iBridge.requestAlertWindow(getName());
                break;
            }
            case com.app.permission.bridge.BridgeRequest.TYPE_NOTIFY: {
                iBridge.requestNotify(getName());
                break;
            }
            case com.app.permission.bridge.BridgeRequest.TYPE_NOTIFY_LISTENER: {
                iBridge.requestNotificationListener(getName());
                break;
            }
            case BridgeRequest.TYPE_WRITE_SETTING: {
                iBridge.requestWriteSetting(getName());
                break;
            }
        }
    }


    @Override
    public void onCallback() {
        synchronized (this) {
            mMessenger.unRegister();
            mRequest.getCallback().onCallback();
            mRequest.getSource().getContext().unbindService(mConnection);
            mMessenger = null;
            mRequest = null;
        }
    }
}