package com.rong.methods.push;

import com.rong.util.RongCloud;
import com.rong.models.CheckMethod;
import com.rong.models.push.BroadcastModel;
import com.rong.models.push.PushModel;
import com.rong.models.response.PushResult;
import com.rong.util.CommonUtil;
import com.rong.util.GsonUtil;
import com.rong.util.HttpUtil;

import java.net.HttpURLConnection;

/**
 * 推送服务
 * <p>
 * docs https://www.rongcloud.cn/docs/push_service.html#broadcast
 * https://www.rongcloud.cn/docs/push_service.html#push
 */
public class Push {

    private static final String UTF8 = "UTF-8";
    private static final String PATH = "push";
    private String appKey;
    private String appSecret;
    private RongCloud rongCloud;

    public RongCloud getRongCloud() {
        return rongCloud;
    }

    public void setRongCloud(RongCloud rongCloud) {
        this.rongCloud = rongCloud;
    }

    public Push(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    /**
     * 广播
     *
     * @param broadcast 广播数据
     * @return PushResult
     **/
    public PushResult message(BroadcastModel broadcast) throws Exception {
        // 需要校验的字段
        String message = CommonUtil.checkFiled(broadcast, PATH, CheckMethod.BROADCAST);
        if (null != message) {
            return (PushResult) GsonUtil.fromJson(message, PushResult.class);
        }

        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(rongCloud.getApiHostType(), appKey, appSecret, "/push.json",
                "application/json");
        HttpUtil.setBodyParameter(broadcast.toString(), conn);

        return (PushResult) GsonUtil.fromJson(
                CommonUtil.getResponseByCode(PATH, CheckMethod.BROADCAST, HttpUtil.returnResult(conn)),
                PushResult.class);
    }

    /**
     * 推送
     *
     * @param push 推送数据
     * @return PushResult
     **/
    public PushResult push(PushModel push) throws Exception {
        // 需要校验的字段
        String message = CommonUtil.checkFiled(push, PATH, CheckMethod.PUSH);
        if (null != message) {
            return (PushResult) GsonUtil.fromJson(message, PushResult.class);
        }

        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(rongCloud.getApiHostType(), appKey, appSecret, "/push.json",
                "application/json");

        HttpUtil.setBodyParameter(push.toString(), conn);

        return (PushResult) GsonUtil.fromJson(
                CommonUtil.getResponseByCode(PATH, CheckMethod.PUSH, HttpUtil.returnResult(conn)),
                PushResult.class);
    }

}