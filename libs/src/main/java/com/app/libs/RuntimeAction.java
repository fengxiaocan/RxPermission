package com.app.libs;

import android.text.TextUtils;

import com.app.dialoglib.RxAlertDialog;
import com.yanzhenjie.permission.AndPermission;

import java.util.List;

class RuntimeAction extends MyAction<List<String>> {
    public RuntimeAction(RxRunTimeOption option) {
        super(option, false);
    }

    @Override
    public void onAction(List<String> data) {
        RxRunTimeOption option1 = (RxRunTimeOption) option;
        if (option1.goSetting) {
            if (TextUtils.isEmpty(option1.goSettingRemind)) {
                AndPermission.with(option1.rxPermission.activity)
                             .runtime()
                             .setting()
                             .start(option1.requestCode);
                super.onAction(data);
            } else {
                RxAlertDialog.with(option.rxPermission.activity)
                             .title(option.rxPermission.title)
                             .message(option.reminder())
                             .middleButton("前往系统设置")
                             .middleListener(dialog -> {
                                 dialog.dismiss();
                                 AndPermission.with(option.rxPermission.activity)
                                              .runtime()
                                              .setting()
                                              .start(((RxRunTimeOption) option).requestCode);
                                 RuntimeAction.super.onAction((List<String>) data);
                             })
                             .cancel(false)
                             .show();
            }
        } else {
            super.onAction(data);
        }
    }
}
