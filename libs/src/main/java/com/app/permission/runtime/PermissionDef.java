
package com.app.permission.runtime;

import androidx.annotation.StringDef;

import com.app.permission.runtime.Permission;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
    com.app.permission.runtime.Permission.READ_CALENDAR,
    com.app.permission.runtime.Permission.WRITE_CALENDAR,
    com.app.permission.runtime.Permission.CAMERA,
    com.app.permission.runtime.Permission.READ_CONTACTS,
    com.app.permission.runtime.Permission.WRITE_CONTACTS,
    com.app.permission.runtime.Permission.GET_ACCOUNTS,
    com.app.permission.runtime.Permission.ACCESS_FINE_LOCATION,
    com.app.permission.runtime.Permission.ACCESS_COARSE_LOCATION,
    com.app.permission.runtime.Permission.ACCESS_BACKGROUND_LOCATION,
    com.app.permission.runtime.Permission.RECORD_AUDIO,
    com.app.permission.runtime.Permission.READ_PHONE_STATE,
    com.app.permission.runtime.Permission.CALL_PHONE,
    com.app.permission.runtime.Permission.ADD_VOICEMAIL,
    com.app.permission.runtime.Permission.USE_SIP,
    com.app.permission.runtime.Permission.READ_PHONE_NUMBERS,
    com.app.permission.runtime.Permission.ANSWER_PHONE_CALLS,
    com.app.permission.runtime.Permission.READ_CALL_LOG,
    com.app.permission.runtime.Permission.WRITE_CALL_LOG,
    com.app.permission.runtime.Permission.PROCESS_OUTGOING_CALLS,
    com.app.permission.runtime.Permission.BODY_SENSORS,
    com.app.permission.runtime.Permission.ACTIVITY_RECOGNITION,
    com.app.permission.runtime.Permission.SEND_SMS,
    com.app.permission.runtime.Permission.RECEIVE_SMS,
    com.app.permission.runtime.Permission.READ_SMS,
    com.app.permission.runtime.Permission.RECEIVE_WAP_PUSH,
    com.app.permission.runtime.Permission.RECEIVE_MMS,
    com.app.permission.runtime.Permission.READ_EXTERNAL_STORAGE,
    Permission.WRITE_EXTERNAL_STORAGE
})
@Retention(RetentionPolicy.SOURCE)
public @interface PermissionDef {
}
