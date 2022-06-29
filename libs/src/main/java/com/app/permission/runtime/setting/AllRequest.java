
package com.app.permission.runtime.setting;

import com.app.permission.runtime.setting.SettingPage;
import com.app.permission.runtime.setting.SettingRequest;
import com.app.permission.source.Source;

public class AllRequest implements SettingRequest {

    private Source mSource;

    public AllRequest(Source source) {
        this.mSource = source;
    }

    @Override
    public void start(int requestCode) {
        SettingPage setting = new SettingPage(mSource);
        setting.start(requestCode);
    }
}