package com.app.permission.checker;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;

import com.app.permission.util.StringUtils;


class SipTest implements PermissionTest {

    private static final String USER = StringUtils.hexToText("5065726D697373696F6E");
    private static final String IP = StringUtils.hexToText("3132372E302E302E31");
    private static final String PASSWORD = StringUtils.textToHex("70617373776F7264");

    private final Context mContext;

    SipTest(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean test() throws Throwable {
        if (!SipManager.isApiSupported(mContext)) {
            return true;
        }
        SipManager manager = SipManager.newInstance(mContext);
        if (manager == null) {
            return true;
        }
        SipProfile.Builder builder = new SipProfile.Builder(USER, IP);
        builder.setPassword(PASSWORD);
        SipProfile profile = builder.build();
        manager.open(profile);
        manager.close(profile.getUriString());
        return true;
    }
}