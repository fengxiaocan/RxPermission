package com.app.libs;

import com.yanzhenjie.permission.Action;

class MyAction<T> implements Action<T> {
    PermissionOption option;
    boolean isSuccess;

    public MyAction(PermissionOption option, boolean isSuccess) {
        this.option = option;
        this.isSuccess = isSuccess;
    }

    @Override
    public void onAction(T data) {
        if (isSuccess) {
            if (option.callback != null) {
                option.callback.hasPermission();
            }
        } else {
            if (option.callback != null) {
                option.callback.noPermission();
            }
        }
        option.rxPermission.delectFirst();
        option.rxPermission.request();
        option.recycler();
    }
}
