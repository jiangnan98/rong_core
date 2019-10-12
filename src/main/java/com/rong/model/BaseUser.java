package com.rong.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jiang
 * @since 2019-05-14
 */
@Data
@Accessors(chain = true)
@TableName("base_user")
public class BaseUser extends Model<BaseUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 人员登录
     */
    @TableId("user_id")
    private String userId;

    /**
     * 登录名
     */
    @TableField("user_code")
    private String userCode;

    /**
     * 昵称
     */
    @TableField("user_nick")
    private String userNick;


    /**
     * 职业
     */
    @TableField("user_Occupation")
    private String userOccupation;

    /**
     * 性别
     */
    @TableField("user_sex")
    private Integer userSex;


    /**
     * 密码
     */
    @TableField("user_pwd")
    private String userPwd;

    /**
     * 手机号
     */
    @TableField("user_phone")
    private String userPhone;

    /**
     * 邀请码
     */
    @TableField("user_Invitation")
    private String userInvitation;

    /**
     * 极光个人pk
     */
    @TableField("registion_Id")
    private String registionId;



    /**
     * 积分
     */
    @TableField("user_integral")
    private Integer userIntegral;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    @TableField("token")
    private String token;
    /**
     * 最后登录IP
     */
    @TableField("last_ip")
    private String lastIp;

    /**
     * 微信登录ID
     */
    @TableField("wechat_id")
    private String wechatId;

    /**
     * 腾讯登录ID
     */
    @TableField("qq_id")
    private String qqId;


    /**
     * 最后登录时间
     */
    @TableField("last_time")
    private Date lastTime;

    /**
     * 用户角色
     */
    @TableField("user_role")
    private Integer userRole;

    /**
     * 用户状态 0：冻结 1：正常 2：删除
     */
    @TableField("user_status")
    private Integer userStatus;

    /**
     * 推送频道 可以是多个用英文逗号隔开
     */
    @TableField("user_channel")
    private String userChannel;

    /**
     * 头像
     */
    @TableField("user_heand")
    private String userHeand;

    /**
     * 邮箱
     */
    @TableField("user_email")
    private String userEmail;


    /**
     * 1:手机号 2:邮箱 3:qq 4:微信 5:git 6:码云
     */
    @TableField("user_Pattern")
    private Integer userPattern;

    /**
     * 个性签名
     */
    @TableField("user_sign")
    private String userSign;

    /**
     * 申请专家状态
     */
    @TableField("is_expert")
    private Integer isExpert;

    /**
     * 等级
     */
    @TableField("user_level")
    private Integer userLevel;
    /**
     * 等级
     */
    @TableField("consultation_count")
    private Integer consultationCount;

    public Integer getConsultationCount() {
        return consultationCount==null?0:consultationCount;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
