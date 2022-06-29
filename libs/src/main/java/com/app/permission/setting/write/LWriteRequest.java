
package com.app.permission.setting.write;

import com.app.permission.setting.write.BaseRequest;
import com.app.permission.source.Source;

public class LWriteRequest extends com.app.permission.setting.write.BaseRequest {

    public LWriteRequest(Source source) {
        super(source);
    }

    @Override
    public void start() {
        callbackSucceed();
    }
}