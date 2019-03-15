package com.app.libs;

public class RxNotificationOption extends PermissionOption<RxNotificationOption>  {
    public RxNotificationOption(RxPermission rxPermission) {
        super(rxPermission);
    }

    @Override
    public RxNotificationOption callback(OnPermissionCallback callback) {
        this.callback = callback;
        return this;
    }

    @Override
    public RxNotificationOption reminder(String reminder) {
        this.reminder = reminder;
        return this;
    }
}
