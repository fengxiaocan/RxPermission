package com.app.libs;

import com.app.permission.Rationale;

public abstract class PermissionOption<T> {
    final XPermission permission;

    OnPermissionCallback callback;
    ReminderOption reminderOption;
    Rationale rationale;

    public PermissionOption(XPermission permission) {
        this.permission = permission;
    }

    public T callback(OnPermissionCallback callback) {
        this.callback = callback;
        return (T) this;
    }

    public T reminder(String reminder) {
        this.reminderOption = new ReminderOption(reminder);
        return (T) this;
    }

    public T reminder(ReminderOption option) {
        this.reminderOption = option;
        return (T) this;
    }

    public T rationale(Rationale rationale) {
        this.rationale = rationale;
        return (T) this;
    }

    ReminderOption reminder() {
        return reminderOption;
    }

    boolean hasReminder() {
        return reminderOption != null;
    }

    public XPermission commit() {
        return permission.addOption(this);
    }

    final void onNext() {
        permission.request();
    }
}
