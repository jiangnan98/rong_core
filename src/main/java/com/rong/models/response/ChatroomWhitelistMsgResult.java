package com.rong.models.response;

import com.rong.models.Result;
import com.rong.util.GsonUtil;

public class ChatroomWhitelistMsgResult extends Result{
    private String[] objectNames;

    public ChatroomWhitelistMsgResult(Integer code, String msg, String[] objectNames) {
        super(code, msg);
        this.objectNames = objectNames;
    }

    public ChatroomWhitelistMsgResult(String[] objectNames) {
        this.objectNames = objectNames;
    }

    public String[] getObjectNames() {
        return this.objectNames;
    }

    public void setObjectNames(String[] objectNames) {
        this.objectNames = objectNames;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, ChatroomWhitelistMsgResult.class);
    }

}
