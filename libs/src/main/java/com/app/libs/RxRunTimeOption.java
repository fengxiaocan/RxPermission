package com.app.libs;

public class RxRunTimeOption extends PermissionOption<RxRunTimeOption> {
    int requestCode;
    boolean goSetting;
    String goSettingRemind;
    String[] permissionGroup;

    RxRunTimeOption(RxPermission rxPermission, String... permission) {
        super(rxPermission);
        this.permissionGroup = permission;
    }

    @Override
    public RxRunTimeOption callback(OnPermissionCallback callback) {
        this.callback = callback;
        return this;
    }

    @Override
    public RxRunTimeOption reminder(String reminder) {
        this.reminder = reminder;
        return this;
    }

    /**
     * 失败是否需要去设置中打开
     *
     * @param goSetting
     * @return
     */
    public RxRunTimeOption setting(boolean goSetting, int requestCode) {
        this.goSetting = goSetting;
        this.requestCode = requestCode;
        return this;
    }

    /**
     * 失败权限提示语 需要去设置中打开
     *
     * @param
     * @return
     */
    public RxRunTimeOption settingRemind(String goSettingRemind) {
        this.goSettingRemind = goSettingRemind;
        return this;
    }

    @Override
    protected void recycler() {
        permissionGroup = null;
        super.recycler();
    }
}
