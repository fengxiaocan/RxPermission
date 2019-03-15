package com.app.libs;

public class RxSettingOption extends PermissionOption<RxSettingOption> {

    public RxSettingOption(RxPermission rxPermission) {
        super(rxPermission);
    }

    @Override
    public RxSettingOption callback(OnPermissionCallback callback) {
        this.callback = callback;
        return this;
    }

    @Override
    public RxSettingOption reminder(String reminder) {
        this.reminder = reminder;
        return this;
    }
}
