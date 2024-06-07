package top.caibitv.demo.design.door.config;

/**
 * 配置服务类
 */
public class StarterService {

    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return this.userStr.split(separatorChar);
    }
}
