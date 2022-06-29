
package com.app.permission.overlay;

import com.app.permission.Action;
import com.app.permission.Rationale;

public interface OverlayRequest {

    /**
     * Set request rationale.
     */
    OverlayRequest rationale(Rationale<Void> rationale);

    /**
     * Action to be taken when all permissions are granted.
     */
    OverlayRequest onGranted(Action<Void> granted);

    /**
     * Action to be taken when all permissions are denied.
     */
    OverlayRequest onDenied(Action<Void> denied);

    /**
     * Start request.
     */
    void start();
}