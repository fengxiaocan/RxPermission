package com.app.permission.notify.listener;

import com.app.permission.RequestExecutor;
import com.app.permission.bridge.BridgeRequest;
import com.app.permission.bridge.RequestManager;
import com.app.permission.source.Source;

class J2Request extends BaseRequest implements RequestExecutor, BridgeRequest.Callback {

    private final Source mSource;

    J2Request(Source source) {
        super(source);
        this.mSource = source;
    }

    @Override
    public void start() {
        if (mSource.canListenerNotification()) {
            callbackSucceed();
        } else {
            showRationale(this);
        }
    }

    @Override
    public void execute() {
        BridgeRequest request = new BridgeRequest(mSource);
        request.setType(BridgeRequest.TYPE_NOTIFY_LISTENER);
        request.setCallback(this);
        RequestManager.get().add(request);
    }

    @Override
    public void cancel() {
        callbackFailed();
    }

    @Override
    public void onCallback() {
        if (mSource.canListenerNotification()) {
            callbackSucceed();
        } else {
            callbackFailed();
        }
    }
}