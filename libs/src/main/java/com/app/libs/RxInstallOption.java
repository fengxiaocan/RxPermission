package com.app.libs;

import java.io.File;

public class RxInstallOption extends PermissionOption<RxInstallOption> {
    File file;

    RxInstallOption(RxPermission rxPermission, File file) {
        super(rxPermission);
        this.file = file;
    }

    @Override
    public RxInstallOption callback(OnPermissionCallback callback) {
        this.callback = callback;
        return this;
    }

    @Override
    public RxInstallOption reminder(String reminder) {
        this.reminder = reminder;
        return this;
    }
}
