
package com.app.permission.install;

import com.app.permission.RequestExecutor;
import com.app.permission.bridge.BridgeRequest;
import com.app.permission.bridge.RequestManager;
import com.app.permission.install.BaseRequest;
import com.app.permission.source.Source;


class ORequest extends BaseRequest implements RequestExecutor, BridgeRequest.Callback {

    private Source mSource;

    ORequest(Source source) {
        super(source);
        this.mSource = source;
    }

    @Override
    public void start() {
        if (mSource.canRequestPackageInstalls()) {
            callbackSucceed();
            install();
        } else {
            showRationale(this);
        }
    }

    @Override
    public void execute() {
        BridgeRequest request = new BridgeRequest(mSource);
        request.setType(BridgeRequest.TYPE_INSTALL);
        request.setCallback(this);
        RequestManager.get().add(request);
    }

    @Override
    public void cancel() {
        callbackFailed();
    }

    @Override
    public void onCallback() {
        if (mSource.canRequestPackageInstalls()) {
            callbackSucceed();
            install();
        } else {
            callbackFailed();
        }
    }
}