package com.app.permission.source;

import android.content.Context;
import android.content.Intent;

public class WrapperSource extends com.app.permission.source.Source {

    private final com.app.permission.source.Source mSource;

    public WrapperSource(Source source) {
        this.mSource = source;
    }

    @Override
    public Context getContext() {
        return mSource.getContext();
    }

    @Override
    public void startActivity(Intent intent) {
        mSource.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        mSource.startActivityForResult(intent, requestCode);
    }

    @Override
    public boolean isShowRationalePermission(String permission) {
        return mSource.isShowRationalePermission(permission);
    }
}