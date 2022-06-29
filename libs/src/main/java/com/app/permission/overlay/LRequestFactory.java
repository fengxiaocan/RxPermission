
package com.app.permission.overlay;

import com.app.permission.Boot;
import com.app.permission.overlay.LRequest;
import com.app.permission.overlay.OverlayRequest;
import com.app.permission.source.Source;

public class LRequestFactory implements Boot.OverlayRequestFactory {

    @Override
    public OverlayRequest create(Source source) {
        return new com.app.permission.overlay.LRequest(source);
    }
}