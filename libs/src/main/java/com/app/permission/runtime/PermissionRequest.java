
package com.app.permission.runtime;

import androidx.annotation.NonNull;

import com.app.permission.Action;
import com.app.permission.Rationale;
import com.app.permission.runtime.Permission;
import com.app.permission.runtime.PermissionDef;

import java.util.List;

public interface PermissionRequest {

    /**
     * One or more permissions.
     */
    PermissionRequest permission(@NonNull @PermissionDef String... permissions);

    /**
     * One or more permissions group.
     *
     * @param groups use constants in {@link Permission.Group}.
     */
    PermissionRequest permission(@NonNull String[]... groups);

    /**
     * Set request rationale.
     */
    PermissionRequest rationale(@NonNull Rationale<List<String>> rationale);

    /**
     * Action to be taken when all permissions are granted.
     */
    PermissionRequest onGranted(@NonNull Action<List<String>> granted);

    /**
     * Action to be taken when all permissions are denied.
     */
    PermissionRequest onDenied(@NonNull Action<List<String>> denied);

    /**
     * Request permission.
     */
    void start();
}