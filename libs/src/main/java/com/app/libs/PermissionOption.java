package com.app.libs;

import android.text.TextUtils;

public abstract class PermissionOption<T> {
    OnPermissionCallback callback;
    RxPermission rxPermission;
    String reminder;

    public PermissionOption(RxPermission rxPermission) {
        this.rxPermission = rxPermission;
    }

    public abstract T callback(OnPermissionCallback callback);

    public abstract T reminder(String reminder);

    String reminder() {
        return reminder;
    }

    boolean hasReminder() {
        return !TextUtils.isEmpty(reminder);
    }

    void recycler() {
        callback = null;
        rxPermission = null;
    }

    public RxPermission commit() {
        return rxPermission.addOption(this);
    }
}
