package com.app.permission.notify.listener;

import com.app.permission.notify.Notify;
import com.app.permission.source.Source;

public class J2RequestFactory implements Notify.ListenerRequestFactory {

    @Override
    public ListenerRequest create(Source source) {
        return new com.app.permission.notify.listener.J2Request(source);
    }
}