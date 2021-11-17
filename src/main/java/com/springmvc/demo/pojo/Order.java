package com.springmvc.demo.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author junyangwei
 * @date 2021-11-17
 */
@Data
public class Order {
    /**
     * 自增ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 总原价
     */
    private Double originalAmount;
    /**
     * 总优惠(支付)价
     */
    private Double amount;
    /**
     * 订单支付状态：0待支付 1已支付 2已完全退款
     */
    private Integer orderStatus;
    /**
     * 状态：0无效 1有效
     */
    private Integer status;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
