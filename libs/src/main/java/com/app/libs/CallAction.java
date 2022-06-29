package com.app.libs;

import com.app.permission.Action;

class CallAction<T> implements Action<T> {
    PermissionOption option;
    boolean isSuccess;

    public CallAction(PermissionOption option, boolean isSuccess) {
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
        option.onNext();
    }
}
