package com.app.permission.option;

import com.app.permission.install.InstallRequest;
import com.app.permission.notify.option.NotifyOption;
import com.app.permission.overlay.OverlayRequest;
import com.app.permission.runtime.option.RuntimeOption;
import com.app.permission.setting.Setting;

public interface Option {

    /**
     * Handle runtime permissions.
     */
    RuntimeOption runtime();

    /**
     * Handle request package install permission.
     */
    InstallRequest install();

    /**
     * Handle overlay permission.
     */
    OverlayRequest overlay();

    /**
     * Handle notification permission.
     */
    NotifyOption notification();

    /**
     * Handle system setting.
     */
    Setting setting();
}