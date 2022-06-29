package com.app.permission.bridge;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.permission.overlay.setting.LSettingPage;
import com.app.permission.overlay.setting.MSettingPage;
import com.app.permission.source.ActivitySource;
import com.app.permission.source.Source;

public final class BridgeActivity extends Activity {

    private static final String KEY_TYPE = "KEY_TYPE";
    private static final String KEY_PERMISSIONS = "KEY_PERMISSIONS";
    private static final String KEY_ACTION_SUFFIX = "KEY_ACTION_SUFFIX";
    private String mActionSuffix;

    /**
     * Request for permissions.
     */
    static void requestAppDetails(Source source, String suffix) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra(KEY_TYPE, BridgeRequest.TYPE_APP_DETAILS);
        intent.putExtra(KEY_ACTION_SUFFIX, suffix);
        source.startActivity(intent);
    }

    /**
     * Request for permissions.
     */
    static void requestPermission(Source source, String suffix, String[] permissions) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra(KEY_TYPE, BridgeRequest.TYPE_PERMISSION);
        intent.putExtra(KEY_PERMISSIONS, permissions);
        intent.putExtra(KEY_ACTION_SUFFIX, suffix);
        source.startActivity(intent);
    }

    /**
     * Request for package install.
     */
    static void requestInstall(Source source, String suffix) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra(KEY_TYPE, BridgeRequest.TYPE_INSTALL);
        intent.putExtra(KEY_ACTION_SUFFIX, suffix);
        source.startActivity(intent);
    }

    /**
     * Request for overlay.
     */
    static void requestOverlay(Source source, String suffix) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra(KEY_TYPE, BridgeRequest.TYPE_OVERLAY);
        intent.putExtra(KEY_ACTION_SUFFIX, suffix);
        source.startActivity(intent);
    }

    /**
     * Request for alert window.
     */
    static void requestAlertWindow(Source source, String suffix) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra(KEY_TYPE, BridgeRequest.TYPE_ALERT_WINDOW);
        intent.putExtra(KEY_ACTION_SUFFIX, suffix);
        source.startActivity(intent);
    }

    /**
     * Request for notify.
     */
    static void requestNotify(Source source, String suffix) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra(KEY_TYPE, BridgeRequest.TYPE_NOTIFY);
        intent.putExtra(KEY_ACTION_SUFFIX, suffix);
        source.startActivity(intent);
    }

    /**
     * Request for notification listener.
     */
    static void requestNotificationListener(Source source, String suffix) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra(KEY_TYPE, BridgeRequest.TYPE_NOTIFY_LISTENER);
        intent.putExtra(KEY_ACTION_SUFFIX, suffix);
        source.startActivity(intent);
    }

    /**
     * Request for write system setting.
     */
    static void requestWriteSetting(Source source, String suffix) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra(KEY_TYPE, BridgeRequest.TYPE_WRITE_SETTING);
        intent.putExtra(KEY_ACTION_SUFFIX, suffix);
        source.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) return;

        Intent intent = getIntent();
        int operation = intent.getIntExtra(KEY_TYPE, -1);
        mActionSuffix = intent.getStringExtra(KEY_ACTION_SUFFIX);
        String packageName = getPackageName();
        switch (operation) {
            case BridgeRequest.TYPE_APP_DETAILS: {
                Intent appDetailsIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                appDetailsIntent.setData(Uri.fromParts("package", packageName, null));
                startActivityForResult(appDetailsIntent, BridgeRequest.TYPE_APP_DETAILS);
                break;
            }
            case BridgeRequest.TYPE_PERMISSION: {
                String[] permissions = intent.getStringArrayExtra(KEY_PERMISSIONS);
                requestPermissions(permissions, BridgeRequest.TYPE_PERMISSION);
                break;
            }
            case BridgeRequest.TYPE_INSTALL: {
                Intent manageIntent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
                manageIntent.setData(Uri.fromParts("package", packageName, null));
                startActivityForResult(manageIntent, BridgeRequest.TYPE_INSTALL);
                break;
            }
            case BridgeRequest.TYPE_OVERLAY: {
                MSettingPage settingPage = new MSettingPage(new ActivitySource(this));
                settingPage.start(BridgeRequest.TYPE_OVERLAY);
                break;
            }
            case BridgeRequest.TYPE_ALERT_WINDOW: {
                LSettingPage settingPage = new LSettingPage(new ActivitySource(this));
                settingPage.start(BridgeRequest.TYPE_ALERT_WINDOW);
                break;
            }
            case BridgeRequest.TYPE_NOTIFY: {
                try {
                    Intent settingIntent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                    settingIntent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName);
                    settingIntent.setData(Uri.fromParts("package", packageName, null));
                    startActivityForResult(settingIntent, BridgeRequest.TYPE_NOTIFY);
                } catch (Exception e) {
                    try {
                        // 根据isOpened结果，判断是否需要提醒用户跳转AppInfo页面，去打开App通知权限
                        Intent settingIntent = new Intent();
                        settingIntent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                        //这种方案适用于 API 26, 即8.0（含8.0）以上可以用
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            settingIntent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName);
                        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            //intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                            int uid = getApplicationInfo().uid;
                            settingIntent.putExtra(Notification.EXTRA_CHANNEL_ID, uid);
                            //这种方案适用于 API21——25，即 5.0——7.1 之间的版本可以使用
                            settingIntent.putExtra("app_package", packageName);
                            settingIntent.putExtra("app_uid", uid);
                        }
                        startActivityForResult(settingIntent, BridgeRequest.TYPE_NOTIFY);
                    } catch (Exception exception) {
                        // 出现异常则跳转到应用设置界面：锤子坚果3——OC105 API25
                        Intent settingIntent = new Intent();
                        //下面这种方案是直接跳转到当前应用的设置界面。
                        settingIntent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        settingIntent.setData(uri);
                        startActivity(settingIntent);

                        Messenger.send(this, mActionSuffix);
                        finish();
                    }
                }
                break;
            }
            case BridgeRequest.TYPE_NOTIFY_LISTENER: {
                Intent settingIntent = new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
                settingIntent.setData(Uri.fromParts("package", packageName, null));
                startActivityForResult(settingIntent, BridgeRequest.TYPE_NOTIFY_LISTENER);
                break;
            }
            case BridgeRequest.TYPE_WRITE_SETTING: {
                Intent settingIntent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                settingIntent.setData(Uri.fromParts("package", packageName, null));
                startActivityForResult(settingIntent, BridgeRequest.TYPE_WRITE_SETTING);
                break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Messenger.send(this, mActionSuffix);
        finish();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Messenger.send(this, mActionSuffix);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}