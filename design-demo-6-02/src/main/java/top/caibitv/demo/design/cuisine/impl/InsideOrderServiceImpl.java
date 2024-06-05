package top.caibitv.demo.design.cuisine.impl;

import top.caibitv.demo.design.OrderAdapterService;
import top.caibitv.demo.design.service.OrderService;

public class InsideOrderServiceImpl implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
