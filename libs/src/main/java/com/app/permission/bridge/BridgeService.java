package com.app.permission.bridge;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.app.permission.source.ContextSource;
import com.app.permission.source.Source;


public class BridgeService extends Service {

    private final IBridge.Stub mStub = new IBridge.Stub() {

        private final Source mSource = new ContextSource(BridgeService.this);

        @Override
        public void requestAppDetails(String suffix) throws RemoteException {
            BridgeActivity.requestAppDetails(mSource, suffix);
        }

        @Override
        public void requestPermission(String suffix, String[] permissions) throws RemoteException {
            BridgeActivity.requestPermission(mSource, suffix, permissions);
        }

        @Override
        public void requestInstall(String suffix) throws RemoteException {
            BridgeActivity.requestInstall(mSource, suffix);
        }

        @Override
        public void requestOverlay(String suffix) throws RemoteException {
            BridgeActivity.requestOverlay(mSource, suffix);
        }

        @Override
        public void requestAlertWindow(String suffix) throws RemoteException {
            BridgeActivity.requestAlertWindow(mSource, suffix);
        }

        @Override
        public void requestNotify(String suffix) throws RemoteException {
            BridgeActivity.requestNotify(mSource, suffix);
        }

        @Override
        public void requestNotificationListener(String suffix) throws RemoteException {
            BridgeActivity.requestNotificationListener(mSource, suffix);
        }

        @Override
        public void requestWriteSetting(String suffix) throws RemoteException {
            BridgeActivity.requestWriteSetting(mSource, suffix);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mStub.asBinder();
    }
}