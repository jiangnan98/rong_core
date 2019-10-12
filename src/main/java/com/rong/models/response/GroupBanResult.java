package com.rong.models.response;

import com.rong.models.Result;
import com.rong.models.group.GroupModel;
import com.rong.util.GsonUtil;

public class GroupBanResult extends Result {
    public GroupBanResult(Integer code, String errorMessage, GroupModel[] groups) {
        super(code, errorMessage);
        this.groups = groups;
    }

    private GroupModel[] groups;

    public GroupModel[] getGroups() {
        return groups;
    }

    public void setGroups(GroupModel[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, GroupBanResult.class);
    }
}
