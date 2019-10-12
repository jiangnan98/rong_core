package com.rong.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * 系统默认属性
 */
@Data
@Component
@ConfigurationProperties(prefix = "system")
public class SystemDefaultConfig {

	private String appKey;

	private String appSecret;


}
