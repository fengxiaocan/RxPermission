package com.app.permission.notify.listener;

import com.app.permission.notify.Notify;
import com.app.permission.source.Source;

public class J1RequestFactory implements Notify.ListenerRequestFactory {

    @Override
    public ListenerRequest create(Source source) {
        return new com.app.permission.notify.listener.J1Request(source);
    }
}