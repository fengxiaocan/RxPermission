
package com.app.permission.setting.write;

import com.app.permission.RequestExecutor;
import com.app.permission.bridge.BridgeRequest;
import com.app.permission.bridge.RequestManager;
import com.app.permission.setting.write.BaseRequest;
import com.app.permission.source.Source;

public class MWriteRequest extends com.app.permission.setting.write.BaseRequest implements RequestExecutor, BridgeRequest.Callback {

    private Source mSource;

    public MWriteRequest(Source source) {
        super(source);
        this.mSource = source;
    }

    @Override
    public void start() {
        if (mSource.canWriteSetting()) {
            callbackSucceed();
        } else {
            showRationale(this);
        }
    }

    @Override
    public void execute() {
        BridgeRequest request = new BridgeRequest(mSource);
        request.setType(BridgeRequest.TYPE_WRITE_SETTING);
        request.setCallback(this);
        RequestManager.get().add(request);
    }

    @Override
    public void cancel() {
        callbackFailed();
    }

    @Override
    public void onCallback() {
        if (mSource.canWriteSetting()) {
            callbackSucceed();
        } else {
            callbackFailed();
        }
    }
}