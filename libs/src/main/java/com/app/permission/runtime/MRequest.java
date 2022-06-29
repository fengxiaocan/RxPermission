
package com.app.permission.runtime;

import androidx.annotation.NonNull;

import com.app.permission.RequestExecutor;
import com.app.permission.bridge.BridgeRequest;
import com.app.permission.bridge.RequestManager;
import com.app.permission.checker.DoubleChecker;
import com.app.permission.checker.PermissionChecker;
import com.app.permission.checker.StandardChecker;
import com.app.permission.runtime.BaseRequest;
import com.app.permission.runtime.PermissionRequest;
import com.app.permission.source.Source;
import com.app.permission.task.TaskExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MRequest extends BaseRequest implements RequestExecutor, BridgeRequest.Callback {

    private static final PermissionChecker STANDARD_CHECKER = new StandardChecker();
    private static final PermissionChecker DOUBLE_CHECKER = new DoubleChecker();

    private Source mSource;

    private List<String> mPermissions;

    private List<String> mDeniedPermissions;

    MRequest(Source source) {
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

        mDeniedPermissions = getDeniedPermissions(STANDARD_CHECKER, mSource, mPermissions);
        if (mDeniedPermissions.size() > 0) {
            List<String> rationaleList = getRationalePermissions(mSource, mDeniedPermissions);
            if (rationaleList.size() > 0) {
                showRationale(rationaleList, this);
            } else {
                execute();
            }
        } else {
            onCallback();
        }
    }

    @Override
    public void execute() {
        BridgeRequest request = new BridgeRequest(mSource);
        request.setType(BridgeRequest.TYPE_PERMISSION);
        request.setPermissions(mDeniedPermissions);
        request.setCallback(this);
        RequestManager.get().add(request);
    }

    @Override
    public void cancel() {
        onCallback();
    }

    @Override
    public void onCallback() {
        new TaskExecutor<List<String>>(mSource.getContext()) {
            @Override
            protected List<String> doInBackground(Void... voids) {
                return getDeniedPermissions(DOUBLE_CHECKER, mSource, mPermissions);
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