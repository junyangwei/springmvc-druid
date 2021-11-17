package com.springmvc.demo.service;

import com.springmvc.demo.pojo.Order;

import java.util.List;

/**
 * 订单 服务层 接口
 * @author junyangwei
 * @date 2021-11-17
 */
public interface OrderService {
    /**
     * 创建订单
     * @return 订单基本信息
     */
    Order insertOrder();

    /**
     * 查询订单
     * @param orderId 订单ID
     * @return 订单信息
     */
    Order selectOrder(long orderId);

    /**
     * 查询订单列表
     * @param userId 用户ID
     * @param size 查询数量
     * @return 订单列表
     */
    List<Order> selectOrders(int userId, int size);
}
