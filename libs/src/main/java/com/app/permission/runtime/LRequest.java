
package com.app.permission.runtime;

import androidx.annotation.NonNull;

import com.app.permission.checker.PermissionChecker;
import com.app.permission.checker.StrictChecker;
import com.app.permission.runtime.BaseRequest;
import com.app.permission.runtime.PermissionRequest;
import com.app.permission.source.Source;
import com.app.permission.task.TaskExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LRequest extends BaseRequest {

    private static final PermissionChecker STRICT_CHECKER = new StrictChecker();

    private Source mSource;

    private List<String> mPermissions;

    LRequest(Source source) {
        super(source);
        this.mSource = source;
    }

    @Override
    public PermissionRequest permission(@NonNull String... permissions) {
        mPermissions = new ArrayList<>();
        mPermissions.addAll(Arrays.asList(permissions));
        return this;
    }

    @Override
    public PermissionRequest permission(@NonNull String[]... groups) {
        mPermissions = new ArrayList<>();
        for (String[] group : groups) {
            mPermissions.addAll(Arrays.asList(group));
        }
        return this;
    }

    @Override
    public void start() {
        mPermissions = filterPermissions(mPermissions);

        new TaskExecutor<List<String>>(mSource.getContext()) {
            @Override
            protected List<String> doInBackground(Void... voids) {
                return getDeniedPermissions(STRICT_CHECKER, mSource, mPermissions);
            }

            @Override
            protected void onFinish(List<String> deniedList) {
                if (deniedList.isEmpty()) {
                    callbackSucceed(mPermissions);
                } else {
                    callbackFailed(deniedList);
                }
            }
        }.execute();
    }
}