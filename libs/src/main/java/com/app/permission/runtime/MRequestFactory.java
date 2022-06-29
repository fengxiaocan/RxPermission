
package com.app.permission.runtime;

import com.app.permission.runtime.MRequest;
import com.app.permission.runtime.PermissionRequest;
import com.app.permission.runtime.Runtime;
import com.app.permission.source.Source;

public class MRequestFactory implements Runtime.PermissionRequestFactory {

    @Override
    public PermissionRequest create(Source source) {
        return new com.app.permission.runtime.MRequest(source);
    }
}