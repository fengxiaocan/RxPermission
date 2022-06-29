
package com.app.permission.runtime;

import com.app.permission.runtime.LRequest;
import com.app.permission.runtime.PermissionRequest;
import com.app.permission.runtime.Runtime;
import com.app.permission.source.Source;

public class LRequestFactory implements Runtime.PermissionRequestFactory {

    @Override
    public PermissionRequest create(Source source) {
        return new com.app.permission.runtime.LRequest(source);
    }
}