
package com.app.permission.runtime.option;

import androidx.annotation.NonNull;

import com.app.permission.runtime.Permission;
import com.app.permission.runtime.PermissionDef;
import com.app.permission.runtime.PermissionRequest;
import com.app.permission.runtime.setting.SettingRequest;

public interface RuntimeOption {

    /**
     * One or more permissions.
     */
    PermissionRequest permission(@NonNull @PermissionDef String... permissions);

    /**
     * One or more permission groups.
     *
     * @param groups use constants in {@link Permission.Group}.
     */
    PermissionRequest permission(@NonNull String[]... groups);

    /**
     * Permission settings.
     */
    SettingRequest setting();
}