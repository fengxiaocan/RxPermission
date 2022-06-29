
package com.app.permission.install;

import com.app.permission.Boot;
import com.app.permission.install.InstallRequest;
import com.app.permission.install.NRequest;
import com.app.permission.source.Source;


public class NRequestFactory implements Boot.InstallRequestFactory {

    @Override
    public InstallRequest create(Source source) {
        return new com.app.permission.install.NRequest(source);
    }
}