package com.app.libs;

public class RxRunTimeOption extends PermissionOption<RxRunTimeOption> {
    String[] permissionGroup;

    RxRunTimeOption(XPermission rxPermission, String... permission) {
        super(rxPermission);
        this.permissionGroup = permission;
    }
}
