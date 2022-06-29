package com.app.permission.notify;

import com.app.permission.source.Source;


public class ORequestFactory implements Notify.PermissionRequestFactory {

    @Override
    public PermissionRequest create(Source source) {
        return new com.app.permission.notify.ORequest(source);
    }
}