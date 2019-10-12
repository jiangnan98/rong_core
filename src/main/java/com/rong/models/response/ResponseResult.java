package com.rong.models.response;

import com.rong.models.Result;
import com.rong.util.GsonUtil;

/**
 *  http 成功返回结果
 */
public class ResponseResult extends Result {

	public ResponseResult(Integer code, String msg) {
		super(code, msg);
		this.code = code;
		this.errorMessage = msg;
	}

	@Override
	public String toString() {
		return GsonUtil.toJson(this, ResponseResult.class);
	}
}
