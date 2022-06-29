
package com.app.permission.install;

import com.app.permission.install.BaseRequest;
import com.app.permission.source.Source;


class NRequest extends BaseRequest {

    NRequest(Source source) {
        super(source);
    }

    @Override
    public void start() {
        callbackSucceed();
        install();
    }
}