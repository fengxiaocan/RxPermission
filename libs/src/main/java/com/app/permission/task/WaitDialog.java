package com.app.permission.task;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;

import com.app.libs.R;


public class WaitDialog extends AppCompatDialog {

    public WaitDialog(@NonNull Context context) {
        super(context, R.style.Permission_Theme_Dialog_Wait);
        setContentView(R.layout.permission_dialog_wait);
    }
}