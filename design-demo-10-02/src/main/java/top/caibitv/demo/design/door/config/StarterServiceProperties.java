package top.caibitv.demo.design.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置类注解定义
 */
@ConfigurationProperties("caibitv.door")
public class StarterServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
