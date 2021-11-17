package com.springmvc.demo.service.impl;

import com.springmvc.demo.mapper.OrderMapper;
import com.springmvc.demo.pojo.Order;
import com.springmvc.demo.service.OrderService;
import com.springmvc.demo.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * 订单 服务层 实现
 * @author junyangwei
 * @date 2021-11-17
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 创建订单
     * @return 订单基本信息
     */
    @Override
    public Order insertOrder() {
        // 随机一个用户ID
        int userId = new Random().nextInt(10000) + 1;
        // 调用订单ID生成器获取订单ID
        long orderId = OrderUtil.orderIdGenerator();

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderId(orderId);
        order.setOriginalAmount(100.0);
        order.setAmount(50.0);

        orderMapper.insertOrder(order);
        return order;
    }

    /**
     * 查询订单
     * @param orderId 订单ID
     * @return 订单信息
     */
    @Override
    public Order selectOrder(long orderId) {
        return orderMapper.selectOrder(orderId);
    }

    /**
     * 查询订单列表
     * @param userId 用户ID
     * @param size 查询数量
     * @return 订单列表
     */
    @Override
    public List<Order> selectOrders(int userId, int size) {
        return orderMapper.selectOrders(userId, size);
    }
}
