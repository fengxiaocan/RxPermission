
package com.app.permission.setting.write;

import com.app.permission.setting.Setting;
import com.app.permission.setting.write.LWriteRequest;
import com.app.permission.setting.write.WriteRequest;
import com.app.permission.source.Source;

public class LWriteRequestFactory implements Setting.SettingRequestFactory {

    @Override
    public WriteRequest create(Source source) {
        return new LWriteRequest(source);
    }
}