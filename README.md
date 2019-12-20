# RxPermission
使用链式编程调用AndPermission的权限申请库
使用方法在申请权限的时候不用分开调用AndPermission的权限申请,直接如下:

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
                            
好处就是可以直接接收到是否上一个权限是否获取到,并且最终的结果如何,支持在没有权限时先提示用户为什么要获取该权限,google要求必须这样做,AndPermission这个库没有添加申请前dialog询问

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.fengxiaocan:RxPermission:latest.release'
	}
