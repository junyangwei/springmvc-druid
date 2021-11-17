package com.springmvc.demo.mapper;

import com.springmvc.demo.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单 数据操作层
 * @author junyangwei
 * @date 2021-11-17
 */
public interface OrderMapper {
    /**
     * 创建订单
     * @param order 订单信息
     */
    void insertOrder(Order order);

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
    List<Order> selectOrders(@Param("userId") int userId, @Param("size") int size);
}
