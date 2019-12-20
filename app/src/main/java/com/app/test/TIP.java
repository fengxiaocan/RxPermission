package com.app.test;

public interface TIP {
    String SD = "当您在应用内浏览内容、使用下载功能或浏览本地图片相册时，应用将缓存数据及图片到本地SD卡上。";
    //        String sdConsequence =
    //                "拒绝应用获取读取储存空间权限，将无法使用缓存离线内容、使用下载功能或浏览本地图片相册等功能。为了保证核心功能的稳定性，请您授权此权限!";

    String camera = "在应用内使用发表文章、闲置、兴趣、鲸图、上传头像时需要使用本地相机功能拍照功能。";
    //        String cameraConsequence =
    //                "当您在应用内使用发表文章、闲置、兴趣、鲸图、上传头像时需要使用本地相机功能拍照功能。为了保证核心功能的稳定性，请您授权此权限!";

    String readPhone = "电话权限是第三方服务读取设备状态时需要，以帮助数字尾巴改进优化应用体验!";

    String notificaiton = "通知权限是使用发布、上传、下载、接收聊天信息时在通知栏显示通知的功能需要。";

    int REQ_CODE_PERMISSION = 0x12;//去设置中设置用户权限
}
