package com.app.libs;

public class ReminderOption {
    String title = "权限申请";
    String reminder;
    String okButton = "确定";
    String cancelButton = "取消";
    float widthPercent = 0.75f;

    public ReminderOption(String reminder) {
        this.reminder = reminder;
    }

    public ReminderOption(String title, String reminder) {
        this.title = title;
        this.reminder = reminder;
    }

    public ReminderOption setTitle(String title) {
        this.title = title;
        return this;
    }


    public ReminderOption setReminder(String reminder) {
        this.reminder = reminder;
        return this;
    }

    public ReminderOption setOkButton(String okButton) {
        this.okButton = okButton;
        return this;
    }

    public ReminderOption cancelButton(String cancelButton) {
        this.cancelButton = cancelButton;
        return this;
    }

    public ReminderOption widthPercent(float widthPercent) {
        this.widthPercent = Math.min(1f, Math.max(0, widthPercent));
        return this;
    }


}
