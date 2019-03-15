package com.app.libs;

public class RxOverlayOption extends PermissionOption<RxOverlayOption> {
    public RxOverlayOption(RxPermission rxPermission) {
        super(rxPermission);
    }

    @Override
    public RxOverlayOption callback(OnPermissionCallback callback) {
        this.callback = callback;
        return this;
    }

    @Override
    public RxOverlayOption reminder(String reminder) {
        this.reminder = reminder;
        return this;
    }
}
