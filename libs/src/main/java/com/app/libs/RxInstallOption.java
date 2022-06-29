package com.app.libs;

import com.app.permission.Rationale;

import java.io.File;

public class RxInstallOption extends PermissionOption<RxInstallOption> {
    File file;

    RxInstallOption(XPermission rxPermission, File file) {
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
        this.reminderOption = new ReminderOption(reminder);
        return this;
    }

    @Override
    public RxInstallOption reminder(ReminderOption option) {
        this.reminderOption = option;
        return this;
    }

    @Override
    public RxInstallOption rationale(Rationale rationale) {
        this.rationale = rationale;
        return this;
    }

}
