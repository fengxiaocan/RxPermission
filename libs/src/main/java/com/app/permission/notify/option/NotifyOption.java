package com.app.permission.notify.option;

import com.app.permission.notify.PermissionRequest;
import com.app.permission.notify.listener.ListenerRequest;

public interface NotifyOption {

    /**
     * Handle permissions.
     */
    PermissionRequest permission();

    /**
     * Handle notify listener.
     */
    ListenerRequest listener();
}