
package com.app.permission.setting.write;

import com.app.permission.setting.Setting;
import com.app.permission.setting.write.MWriteRequest;
import com.app.permission.setting.write.WriteRequest;
import com.app.permission.source.Source;
public class MWriteRequestFactory implements Setting.SettingRequestFactory {

    @Override
    public WriteRequest create(Source source) {
        return new MWriteRequest(source);
    }
}