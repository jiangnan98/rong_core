package com.rong.controller;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.rong.config.SystemDefaultConfig;
import com.rong.dto.RegisterUserDto;
import com.rong.models.response.TokenResult;
import com.rong.models.user.UserModel;
import com.rong.pack.ResponseResult;
import com.rong.req.vo.RegisterRongReqVO;
import com.rong.util.RongCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rong.methods.user.User;

/**
 * @author Jiang
 * @date 2019/10/12 15:55
 */
@RestController
@RequestMapping("/rong/")
public class RongYunController {

    @Autowired
    SystemDefaultConfig systemDefaultConfig;

    @GetMapping("reg")
    public ResponseResult<String> reg(RegisterRongReqVO vo){
        RongCloud rongCloud = RongCloud.getInstance(systemDefaultConfig.getAppKey(), systemDefaultConfig.getAppSecret());
        User User = rongCloud.user;
        try{
            /**
             * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
             *
             * 注册用户，生成用户在融云的唯一身份标识 Token
             */
            UserModel user = new UserModel()
                    .setId(vo.getId())
                    .setName(vo.getNick())
                    .setPortrait(vo.getHand());
            TokenResult result = User.register(user);
            RegisterUserDto dto = new GsonBuilder()
                    .create().fromJson(result.toString(),
                            new TypeToken<RegisterUserDto>() {
                            }.getType());
            if(dto.getCode().equals("200")){
                return ResponseResult.success(dto.getToken());
            }
            return ResponseResult.failNotice("注册失败");
        }catch (Exception e) {
            return ResponseResult.failNotice("注册失败");
        }
    }
}
