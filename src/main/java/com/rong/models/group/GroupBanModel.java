package com.rong.models.group;

import com.rong.models.Result;
import com.rong.models.response.GroupBanInfo;
import com.rong.util.GsonUtil;

public class GroupBanModel extends Result {
    private GroupBanInfo[] groupinfo;

    public GroupBanInfo[] getGroupinfo() {
        return groupinfo;
    }

    public void setGroupinfo(GroupBanInfo[] groupinfo) {
        this.groupinfo = groupinfo;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, GroupBanModel.class);
    }
}
