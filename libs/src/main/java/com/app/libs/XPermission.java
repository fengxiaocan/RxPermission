package com.app.libs;

import java.io.File;

public abstract class XPermission {

    protected abstract XPermission addOption(PermissionOption option);

    /**
     * 运行时权限配置
     *
     * @param permission
     * @return
     */
    public RxRunTimeOption runtime(String... permission) {
        return new RxRunTimeOption(this, permission);
    }

    public RxRunTimeOption runtime(String permission) {
        return new RxRunTimeOption(this, permission);
    }

    /**
     * 通知权限配置
     *
     * @return
     */
    public RxNotificationOption notification() {
        return new RxNotificationOption(this);
    }

    /**
     * 进入设置activity权限配置
     *
     * @return
     */
    public RxSettingOption setting() {
        return new RxSettingOption(this);
    }

    /**
     * 请求在其他App顶部绘制
     * 使用AndPermission也需要在manifest.xml中添加android.permission.SYSTEM_ALERT_WINDOW权限。
     * <p>
     * 从Android6.0开始使用WindowManager.LayoutParams.TYPE_SYSTEM_ALERT需要用户授权，
     * 从Android8.0开始它被替换为WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY，
     * 并且也需要用户授权。部分中国产手机在Android6.0以下就需要用户授权WindowManager.LayoutParams.TYPE_SYSTEM_ALERT，
     * 因此AndPermission也兼容了中国产手机Android6.0以下的系统。
     *
     * @return
     */
    public RxOverlayOption overlay() {
        return new RxOverlayOption(this);
    }

    /**
     * 使用AndPermission也需要在manifest.xml中添加android.permission.REQUEST_INSTALL_PACKAGES权限，
     * 并且调用AndPermission的安装代码之前需要保证App拥有外部存储设备读写权限。
     *
     * @param file
     * @return
     */
    public RxInstallOption install(File file) {
        return new RxInstallOption(this, file);
    }

    /**
     * 使用AndPermission也需要在manifest.xml中添加android.permission.REQUEST_INSTALL_PACKAGES权限，
     * 并且调用AndPermission的安装代码之前需要保证App拥有外部存储设备读写权限。
     *
     * @param file
     * @return
     */
    public RxInstallOption install(String file) {
        return new RxInstallOption(this, new File(file));
    }

    public abstract void request();

}
