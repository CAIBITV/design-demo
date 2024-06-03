package top.caibitv.demo.design.store;

import java.util.Map;

/**
 * 发放奖品接口
 */
public interface ICommodity {

    /**
     * 发放奖品
     *
     * @param uId 用户ID
     * @param commodityId 奖品ID
     * @param bizId 业务ID
     * @param extMap 扩展信息
     * @throws Exception 异常
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}
