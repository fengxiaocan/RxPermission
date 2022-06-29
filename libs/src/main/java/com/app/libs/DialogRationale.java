package com.app.libs;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;

import com.app.dialoglib.RxAlertDialog;
import com.app.permission.Rationale;
import com.app.permission.RequestExecutor;

class DialogRationale<T> implements Rationale<T> {
    PermissionOption option;

    public DialogRationale(PermissionOption option) {
        this.option = option;
    }

    @Override
    public void showRationale(Context context, T data, RequestExecutor executor) {
        if (option.hasReminder()) {
            RxAlertDialog.with(context)
                    .title(option.reminder().title)
                    .message(option.reminder().reminder)
                    .leftButton(option.reminder().okButton)
                    .leftListener(dialog -> {
                        dialog.dismiss();
                        executor.execute();
                    })
                    .rightButton(option.reminder().cancelButton)
                    .rightListener(dialog -> {
                        dialog.dismiss();
                        executor.cancel();
                    })
                    .cancel(false)
                    .widthPercent(option.reminder().widthPercent)
                    .show();
        } else {
            executor.execute();
        }
    }
}
