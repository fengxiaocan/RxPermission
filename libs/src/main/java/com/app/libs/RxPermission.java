package com.app.libs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.app.permission.AndPermission;

import java.io.File;
import java.util.LinkedList;

/**
 * Android中的各种访问权限Permission含义
 * android.permission.EXPAND_STATUS_BAR
 * 允许一个程序扩展收缩在状态栏,android开发网提示应该是一个类似Windows Mobile中的托盘程序
 * <p>
 * android.permission.FACTORY_TEST
 * 作为一个工厂测试程序，运行在root用户
 * <p>
 * android.permission.FLASHLIGHT
 * 访问闪光灯,android开发网提示HTC Dream不包含闪光灯
 * <p>
 * android.permission.FORCE_BACK
 * 允许程序强行一个后退操作是否在顶层activities
 * <p>
 * android.permission.FOTA_UPDATE
 * 暂时不了解这是做什么使用的，android开发网分析可能是一个预留权限.
 * <p>
 * android.permission.GET_ACCOUNTS
 * 访问一个帐户列表在Accounts Service中
 * <p>
 * android.permission.GET_PACKAGE_SIZE
 * 允许一个程序获取任何package占用空间容量
 * <p>
 * android.permission.GET_TASKS
 * 允许一个程序获取信息有关当前或最近运行的任务，一个缩略的任务状态，是否活动等等
 * <p>
 * android.permission.HARDWARE_TEST
 * 允许访问硬件
 * <p>
 * android.permission.INJECT_EVENTS
 * 允许一个程序截获用户事件如按键、触摸、轨迹球等等到一个时间流，android 开发网提醒算是hook技术吧
 * <p>
 * android.permission.INSTALL_PACKAGES
 * 允许一个程序安装packages
 * <p>
 * android.permission.INTERNAL_SYSTEM_WINDOW
 * 允许打开窗口使用系统用户界面
 * <p>
 * android.permission.ACCESS_CHECKIN_PROPERTIES
 * 允许读写访问“properties”表在checkin数据库中，改值可以修改上传。
 * <p>
 * android.permission.ACCESS_COARSE_LOCATION
 * 允许一个程序访问CellID或WiFi热点来获取粗略的位置
 * <p>
 * android.permission.ACCESS_FINE_LOCATION
 * 允许一个程序访问精良位置(如GPS)
 * <p>
 * android.permission.WRITE_CONTACTS
 * 允许程序写入但不读取用户联系人数据
 * <p>
 * android.permission.WRITE_GSERVICES
 * 允许程序修改Google服务地图
 * <p>
 * android.permission.WRITE_OWNER_DATA
 * 允许一个程序写入但不读取所有者数据
 * <p>
 * android.permission.WRITE_SETTINGS
 * 允许程序读取或写入系统设置
 * <p>
 * android.permission.WRITE_SMS
 * 允许程序写短信
 * <p>
 * android.permission.WRITE_SYNC_SETTINGS
 * 允许程序写入同步设置
 * <p>
 * android.permission.ACCESS_LOCATION_EXTRA_COMMANDS
 * 允许应用程序访问额外的位置提供命令
 * <p>
 * android.permission.ACCESS_MOCK_LOCATION
 * 允许程序创建模拟位置提供用于测试
 * <p>
 * android.permission.ACCESS_NETWORK_STATE
 * 允许程序访问有关GSM网络信息
 * <p>
 * android.permission.ACCESS_SURFACE_FLINGER
 * 允许程序使用SurfaceFlinger底层特性
 * <p>
 * android.permission.ACCESS_WIFI_STATE
 * 允许程序访问Wi-Fi网络状态信息
 * <p>
 * android.permission.ADD_SYSTEM_SERVICE
 * 允许程序发布系统级服务
 * <p>
 * android.permission.BATTERY_STATS
 * 允许程序更新手机电池统计信息
 * <p>
 * android.permission.BLUETOOTH
 * 允许程序连接到已配对的蓝牙设备
 * <p>
 * android.permission.BLUETOOTH_ADMIN
 * 允许程序发现和配对蓝牙设备
 * <p>
 * android.permission.BROADCAST_PACKAGE_REMOVED
 * 允许程序广播一个提示消息在一个应用程序包已经移除后
 * <p>
 * android.permission.BROADCAST_STICKY
 * 允许一个程序广播常用intents
 * <p>
 * android.permission.CALL_PHONE
 * 允许一个程序初始化一个电话拨号不需通过拨号用户界面需要用户确认
 * <p>
 * android.permission.DELETE_CACHE_FILES
 * 允许程序删除缓存文件
 * <p>
 * android.permission.DELETE_PACKAGES
 * 允许一个程序删除包
 * <p>
 * android.permission.DEVICE_POWER
 * 允许访问底层电源管理
 * <p>
 * android.permission.DIAGNOSTIC
 * 允许程序RW诊断资源
 * <p>
 * android.permission.DISABLE_KEYGUARD
 * 允许程序禁用键盘锁
 * <p>
 * android.permission.DUMP
 * 允许程序返回状态抓取信息从系统服务
 * <p>
 * android.permission.CALL_PRIVILEGED
 * 允许一个程序拨打任何号码，包含紧急号码无需通过拨号用户界面需要用户确认
 * <p>
 * android.permission.CAMERA
 * 请求访问使用照相设备
 * <p>
 * android.permission.CHANGE_COMPONENT_ENABLED_STATE
 * 允许一个程序是否改变一个组件或其他的启用或禁用
 * <p>
 * android.permission.CHANGE_CONFIGURATION
 * 允许一个程序修改当前设置，如本地化
 * <p>
 * android.permission.CHANGE_NETWORK_STATE
 * 允许程序改变网络连接状态
 * <p>
 * android.permission.CHANGE_WIFI_STATE
 * 允许程序改变Wi-Fi连接状态
 * <p>
 * android.permission.CLEAR_APP_CACHE
 * 允许一个程序清楚缓存从所有安装的程序在设备中
 * <p>
 * android.permission.CLEAR_APP_USER_DATA
 * 允许一个程序清除用户设置
 * <p>
 * android.permission.CONTROL_LOCATION_UPDATES
 * 允许启用禁止位置更新提示从无线模块
 * <p>
 * android.permission.REBOOT
 * 请求能够重新启动设备
 * <p>
 * android.permission.RECEIVE_BOOT_COMPLETED
 * 允许一个程序接收到 ACTION_BOOT_COMPLETED广播在系统完成启动
 * <p>
 * android.permission.RECEIVE_MMS
 * 允许一个程序监控将收到MMS彩信,记录或处理
 * <p>
 * android.permission.RECEIVE_SMS
 * 允许程序监控一个将收到短信息，记录或处理
 * <p>
 * android.permission.RECEIVE_WAP_PUSH
 * 允许程序监控将收到WAP PUSH信息
 * <p>
 * android.permission.RECORD_AUDIO
 * 允许程序录制音频
 * <p>
 * android.permission.REORDER_TASKS
 * 允许程序改变Z轴排列任务
 * <p>
 * android.permission.RESTART_PACKAGES
 * 允许程序重新启动其他程序
 * <p>
 * android.permission.SEND_SMS
 * 允许程序发送SMS短信
 * <p>
 * android.permission.INTERNET
 * 允许程序打开网络套接字
 * <p>
 * android.permission.MANAGE_APP_TOKENS
 * 允许程序管理(创建、催后、 z- order默认向z轴推移)程序引用在窗口管理器中
 * <p>
 * android.permission.MASTER_CLEAR目前还没有明确的解释，android开发网分析可能是清除一切数据，类似硬格机
 * <p>
 * android.permission.MODIFY_AUDIO_SETTINGS
 * 允许程序修改全局音频设置
 * <p>
 * android.permission.MODIFY_PHONE_STATE
 * 允许修改话机状态，如电源，人机接口等
 * <p>
 * android.permission.MOUNT_UNMOUNT_FILESYSTEMS
 * 允许挂载和反挂载文件系统可移动存储
 * <p>
 * android.permission.PERSISTENT_ACTIVITY
 * 允许一个程序设置他的activities显示
 * <p>
 * android.permission.PROCESS_OUTGOING_CALLS
 * 允许程序监视、修改有关播出电话
 * <p>
 * android.permission.READ_CALENDAR
 * 允许程序读取用户日历数据
 * <p>
 * android.permission.READ_CONTACTS
 * 允许程序读取用户联系人数据
 * <p>
 * android.permission.READ_FRAME_BUFFER
 * 允许程序屏幕波或和更多常规的访问帧缓冲数据
 * <p>
 * android.permission.READ_INPUT_STATE
 * 允许程序返回当前按键状态
 * <p>
 * android.permission.READ_LOGS
 * 允许程序读取底层系统日志文件
 * <p>
 * android.permission.READ_OWNER_DATA
 * 允许程序读取所有者数据
 * <p>
 * android.permission.READ_SMS
 * 允许程序读取短信息
 * <p>
 * android.permission.READ_SYNC_SETTINGS
 * 允许程序读取同步设置
 * <p>
 * android.permission.READ_SYNC_STATS
 * 允许程序读取同步状态
 * <p>
 * android.permission.SET_ACTIVITY_WATCHER
 * 允许程序监控或控制activities已经启动全局系统中
 * <p>
 * android.permission.SET_ALWAYS_FINISH
 * 允许程序控制是否活动间接完成在处于后台时
 * <p>
 * android.permission.SET_ANIMATION_SCALE
 * 修改全局信息比例
 * <p>
 * android.permission.SET_DEBUG_APP
 * 配置一个程序用于调试
 * <p>
 * android.permission.SET_ORIENTATION
 * 允许底层访问设置屏幕方向和实际旋转
 * <p>
 * android.permission.SET_PREFERRED_APPLICATIONS
 * 允许一个程序修改列表参数PackageManager.addPackageToPreferred() 和PackageManager.removePackageFromPreferred()方法
 * <p>
 * android.permission.SET_PROCESS_FOREGROUND
 * 允许程序当前运行程序强行到前台
 * <p>
 * android.permission.SET_PROCESS_LIMIT
 * 允许设置最大的运行进程数量
 * <p>
 * android.permission.SET_TIME_ZONE
 * 允许程序设置时间区域
 * <p>
 * android.permission.SET_WALLPAPER
 * 允许程序设置壁纸
 * <p>
 * android.permission.SET_WALLPAPER_HINTS
 * 允许程序设置壁纸hits
 * <p>
 * android.permission.SIGNAL_PERSISTENT_PROCESSES
 * 允许程序请求发送信号到所有显示的进程中
 * <p>
 * android.permission.STATUS_BAR
 * 允许程序打开、关闭或禁用状态栏及图标Allows an application to open, close, or disable the status bar and its icons.
 * <p>
 * android.permission.SUBSCRIBED_FEEDS_READ
 * 允许一个程序访问订阅RSS Feed内容提供
 * <p>
 * android.permission.SUBSCRIBED_FEEDS_WRITE
 * 系统暂时保留改设置,android开发网认为未来版本会加入该功能。
 * <p>
 * android.permission.SYSTEM_ALERT_WINDOW
 * 允许一个程序打开窗口使用 TYPE_SYSTEM_ALERT，显示在其他所有程序的顶层
 * <p>
 * android.permission.VIBRATE
 * 允许访问振动设备
 * <p>
 * android.permission.WAKE_LOCK
 * 允许使用PowerManager的 WakeLocks保持进程在休眠时从屏幕消失
 * <p>
 * android.permission.WRITE_APN_SETTINGS
 * 允许程序写入API设置
 * <p>
 * android.permission.WRITE_CALENDAR
 * 允许一个程序写入但不读取用户日历数据
 * <p>
 * 可以看出Android中对资源以及服务的访问都非常严格，另外，在程序打包成APK的时候也需要对软件进行签名。
 */
public class RxPermission extends XPermission {
    Context context;
    LinkedList<PermissionOption> permissionList = new LinkedList<>();
    OnCompleteListener onCompleteListener;

    private RxPermission(Context context) {
        this.context = context;
    }

    public static RxPermission with(Context activity) {
        return new RxPermission(activity);
    }

    public RxPermission complete(OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
        return this;
    }


    /**
     * @param option
     */
    @SuppressLint("WrongConstant")
    private void runtime(RxRunTimeOption option) {
        AndPermission.with(context)
                .runtime()
                .permission(option.permissionGroup)
                .rationale(option.rationale != null ? option.rationale : new DialogRationale(option))
                .onGranted(new CallAction<>(option, true))
                .onDenied(new CallAction(option,false))
                .start();
    }


    /**
     * 通知权限
     *
     * @param option
     */
    private void notification(RxNotificationOption option) {
        //通知栏可以使用
        AndPermission.with(context)
                .notification()
                .permission()
                .rationale(option.rationale != null ? option.rationale : new DialogRationale(option))
                .onGranted(new CallAction<>(option, true))
                .onDenied(new CallAction<>(option, false))
                .start();
    }

    /**
     * android.permission.WRITE_SETTINGS
     * 允许程序读取或写入系统设置
     *
     * @param option
     */
    private void setting(RxSettingOption option) {
        AndPermission.with(context)
                .setting()
                .write()
                .rationale(option.rationale != null ? option.rationale : new DialogRationale<>(option))
                .onGranted(new CallAction<>(option, true))
                .onDenied(new CallAction<>(option, false))
                .start();
    }

    private void overlay(RxOverlayOption option) {
        AndPermission.with(context)
                .overlay()
                .rationale(option.rationale != null ? option.rationale : new DialogRationale<>(option))
                .onGranted(new CallAction<>(option, true))
                .onDenied(new CallAction<>(option, false))
                .start();
    }


    private void install(RxInstallOption option) {
        AndPermission.with(context)
                .install()
                .file(option.file)
                .rationale(option.rationale != null ? option.rationale : new DialogRationale<>(option))
                .onGranted(new CallAction<>(option, true))
                .onDenied(new CallAction<>(option, false))
                .start();
    }

    @Override
    protected XPermission addOption(PermissionOption option) {
        permissionList.add(option);
        return this;
    }

    public static volatile int index = 0;

    /**
     * 开启所有的事务
     */
    @Override
    public void request() {
        if (permissionList.size() > 0) {
            PermissionOption option = permissionList.removeFirst();
            if (option instanceof RxRunTimeOption) {
                runtime((RxRunTimeOption) option);
            } else if (option instanceof RxNotificationOption) {
                notification((RxNotificationOption) option);
            } else if (option instanceof RxSettingOption) {
                setting((RxSettingOption) option);
            } else if (option instanceof RxInstallOption) {
                install((RxInstallOption) option);
            } else if (option instanceof RxOverlayOption) {
                overlay((RxOverlayOption) option);
            }
        } else {
            if (onCompleteListener != null) {
                onCompleteListener.onComplete();
            }
        }
    }
}
