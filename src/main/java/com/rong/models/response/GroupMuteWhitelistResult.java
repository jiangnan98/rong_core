package com.rong.models.response;

import com.rong.models.Result;
import com.rong.util.GsonUtil;

public class GroupMuteWhitelistResult extends Result {
    private String[] userIds;

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, GroupBanWhitelistResult.class);
    }
}
