package com.rong.methods.user.tag;

import com.rong.util.RongCloud;
import com.rong.models.CheckMethod;
import com.rong.models.Result;
import com.rong.models.response.GetTagResult;
import com.rong.models.response.ResponseResult;
import com.rong.models.user.BatchTagModel;
import com.rong.models.user.GetTagModel;
import com.rong.models.user.TagModel;
import com.rong.util.CommonUtil;
import com.rong.util.GsonUtil;
import com.rong.util.HttpUtil;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * 用户标签服务 docs: "https://www.rongcloud.cn/docs/push_service.html#user_tag"
 */
public class Tag {

    private static final String UTF8 = "UTF-8";
    private static final String PATH = "user/tag";
    private String appKey;
    private String appSecret;
    private RongCloud rongCloud;

    public RongCloud getRongCloud() {
        return rongCloud;
    }

    public void setRongCloud(RongCloud rongCloud) {
        this.rongCloud = rongCloud;
    }

    public Tag(String appKey, String appSecret, RongCloud rongCloud) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.rongCloud  = rongCloud;

    }

    /**
     * 为应用中的用户添加标签，如果某用户已经添加了标签，再次对用户添加标签时将覆盖之前设置的标签内容。
     *
     * @param tag 用户标签信息
     * @return ResponseResult
     **/
    public Result set(TagModel tag) throws Exception {
        String message = CommonUtil.checkFiled(tag, PATH, CheckMethod.SET_TAG);
        if (null != message) {
            return (ResponseResult) GsonUtil.fromJson(message, ResponseResult.class);
        }

        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(rongCloud.getApiHostType(), appKey, appSecret,
                "/user/tag/set.json", "application/json");

        HttpUtil.setBodyParameter(tag.toString(), conn);
        return (ResponseResult) GsonUtil.fromJson(
                CommonUtil.getResponseByCode(PATH, CheckMethod.SET_TAG, HttpUtil.returnResult(conn)),
                ResponseResult.class);
    }

    /**
     * 为应用中的用户添加标签，如果某用户已经添加了标签，再次对用户添加标签时将覆盖之前设置的标签内容。
     *
     * @param batchTag 多个用户标签信息
     * @return ResponseResult
     **/
    public Result batchSet(BatchTagModel batchTag) throws Exception {
        String message = CommonUtil.checkFiled(batchTag, PATH, CheckMethod.BATCH_SET_TAG);
        if (null != message) {
            return (ResponseResult) GsonUtil.fromJson(message, ResponseResult.class);
        }

        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(rongCloud.getApiHostType(), appKey, appSecret,
                "/user/tag/batch/set.json", "application/json");

        HttpUtil.setBodyParameter(batchTag.toString(), conn);
        return (ResponseResult) GsonUtil.fromJson(
                CommonUtil.getResponseByCode(PATH, CheckMethod.BATCH_SET_TAG, HttpUtil.returnResult(conn)),
                ResponseResult.class);
    }

    /**
     * 查询用户所有标签功能，支持批量查询每次最多查询 50 个用户。
     *
     * @param getTag 多个用户ids
     * @return GetTagResult
     **/
    public GetTagResult get(GetTagModel getTag) throws Exception {
        String message = CommonUtil.checkFiled(getTag, PATH, CheckMethod.GET_TAG);
        if (null != message) {
            return (GetTagResult) GsonUtil.fromJson(message, GetTagResult.class);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getTag.getUserIds().length; i++) {
            String userId = getTag.getUserIds()[i];
            if (null != userId) {
                sb.append("&userIds=").append(URLEncoder.encode(userId, UTF8));
            }
        }

        if (sb.indexOf("&") == 0) {
            sb.deleteCharAt(0);
        }

        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(rongCloud.getApiHostType(), appKey, appSecret,
                "/user/tags/get.json", "application/x-www-form-urlencoded");

        HttpUtil.setBodyParameter(sb, conn);
        return (GetTagResult) GsonUtil.fromJson(
                CommonUtil.getResponseByCode(PATH, CheckMethod.GET_TAG, HttpUtil.returnResult(conn)),
                GetTagResult.class);
    }

}