package com.app.test;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yanzhenjie.permission.runtime.Permission;

public class MainActivity extends AppCompatActivity {

    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBt = findViewById(R.id.bt);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxPermission.with(MainActivity.this)
                            .runtime(Permission.WRITE_EXTERNAL_STORAGE)
                            .reminder(TIP.SD)
                            .callback(new RxPermission.OnPermissionCallback() {
                                @Override
                                public void hasPermission() {
                                    Toast.makeText(MainActivity.this,"有储存读写权限",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void noPermission() {
                                    Toast.makeText(MainActivity.this,"没有储存读写权限",Toast.LENGTH_SHORT).show();
                                }
                            })
                            .commit()
                            .runtime(Permission.CAMERA)
                            .reminder(TIP.camera)
                            .callback(new RxPermission.OnPermissionCallback() {
                                @Override
                                public void hasPermission() {
                                    Toast.makeText(MainActivity.this,"有相机权限",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void noPermission() {
                                    Toast.makeText(MainActivity.this,"没有相机权限",Toast.LENGTH_SHORT).show();
                                }
                            })
                            .commit()
                            .runtime(Permission.CALL_PHONE)
                            .reminder(TIP.readPhone)
                            .setting(true,2019)
                            .settingRemind("必须要授权!!")
                            .commit()
                            .notification()
                            .reminder(TIP.notificaiton)
                            .commit()
                            .request();
            }
        });
    }
}
