package com.app.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.libs.OnPermissionCallback;
import com.app.libs.RxPermission;
import com.app.permission.runtime.Permission;

public class MainActivity extends AppCompatActivity {

    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBt = findViewById(R.id.bt);
        mBt.setOnClickListener(v -> {
            RxPermission.with(MainActivity.this)
                    .runtime(Permission.WRITE_EXTERNAL_STORAGE)
                    .reminder("申请SD卡必须权限")
                    .callback(new OnPermissionCallback() {
                        @Override
                        public void hasPermission() {
                            Toast.makeText(MainActivity.this, "有储存读写权限", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void noPermission() {
                            Toast.makeText(MainActivity.this, "没有储存读写权限", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .commit()
                    .runtime(Permission.RECORD_AUDIO)
                    .reminder("申请录音权限")
                    .commit()
                    .runtime(Permission.CAMERA)
                    .reminder("申请相机权限")
                    .callback(new OnPermissionCallback() {
                        @Override
                        public void hasPermission() {
                            Toast.makeText(MainActivity.this, "有相机权限", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void noPermission() {
                            Toast.makeText(MainActivity.this, "没有相机权限", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .commit()
                    .runtime(Permission.CALL_PHONE)
                    .callback(new OnPermissionCallback() {
                        @Override
                        public void hasPermission() {
                            Toast.makeText(MainActivity.this, "有读取手机信息权限", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void noPermission() {
                            Toast.makeText(MainActivity.this, "没有读取手机信息权限", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .reminder("读取手机信息权限")
                    .commit()
                    .notification()
                    .reminder("需要通知权限")
                    .commit()
                    .request();

        });
    }
}
