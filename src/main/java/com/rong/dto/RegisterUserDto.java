package com.rong.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jiang
 * @date 2019/10/12 16:49
 */
@Data
public class RegisterUserDto implements Serializable {

    private static final long serialVersionUID = -3474840018641708589L;

    private String token;

    private String userId;

    private String code;
}
