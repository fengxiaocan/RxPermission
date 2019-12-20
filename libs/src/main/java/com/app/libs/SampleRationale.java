package com.app.libs;

import android.content.Context;

import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

class SampleRationale<T> implements Rationale<T> {
    @Override
    public void showRationale(Context context, T data, RequestExecutor executor) {
        executor.execute();
    }
}
