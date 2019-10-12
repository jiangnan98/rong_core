package com.rong.example.user;

import com.rong.util.RongCloud;
import com.rong.methods.user.User;
import com.rong.models.*;
import com.rong.models.response.*;
import com.rong.models.user.UserModel;

/**
 * Demo class
 *
 * @author RongCloud
 */
public class UserExample {
    /**
     * 此处替换成您的appKey
     */
    private static final String appKey = "8w7jv4qb82hoy";
    /**
     * 此处替换成您的appSecret
     */
    private static final String appSecret = "yaGDrH8K1Bomv";
    /**
     * 自定义api地址
     */
    private static final String api = "http://api-cn.ronghub.com";

    public static void main(String[] args) throws Exception {

        RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
        // 自定义 api 地址方式
        // RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret,api);
        // 使用 百度 HTTPDNS 获取最快的 IP 地址进行连接
        // BaiduHttpDNSUtil.setHostTypeIp("account_id", "secret", rongCloud.getApiHostType());
        User User = rongCloud.user;

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
         *
         * 注册用户，生成用户在融云的唯一身份标识 Token
         */
        UserModel user = new UserModel()
                .setId("userxxd2")
                .setName("username")
                .setPortrait("http://www.rongcloud.cn/images/logo.png");
        TokenResult result = User.register(user);
        System.out.println("getToken:  " + result.toString());

        /**
         *
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#refresh
         *
         * 刷新用户信息方法
         */
        Result refreshResult = User.update(user);
        System.out.println("refresh:  " + refreshResult.toString());

        /**
         *
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#get
         *
         * 查询用户信息方法
         */
        UserResult userResult = User.get(user);
        System.out.println("getUserInfo:  " + userResult.toString());
    }
}
