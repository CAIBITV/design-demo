package top.caibitv.demo.design.cuisine.impl;

import top.caibitv.demo.design.OrderAdapterService;
import top.caibitv.demo.design.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
