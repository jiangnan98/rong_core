package com.rong.req.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jiang
 * @date 2019/10/12 16:10
 */
@Data
public class RegisterRongReqVO implements Serializable {
    private static final long serialVersionUID = 42625358235375025L;

    private String hand;

    private String nick;

    private String id;
}
