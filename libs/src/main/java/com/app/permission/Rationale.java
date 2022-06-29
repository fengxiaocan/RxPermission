
package com.app.permission;

import android.content.Context;

import com.app.permission.RequestExecutor;

public interface Rationale<T> {

    /**
     * Show rationale to user.
     *
     * @param context context.
     * @param data the data.
     * @param executor executor.
     */
    void showRationale(Context context, T data, RequestExecutor executor);
}