package com.springmvc.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.springmvc.demo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单 控制层
 * @author junyangwei
 * @date 2021-11-17
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource(name = "orderService")
    OrderService orderService;

    @GetMapping("/create")
    public Object insertOrderTest() {
        return result(orderService.insertOrder());
    }

    @GetMapping("/get")
    public String selectOrder(@RequestParam("order_id") Long orderId) {
        return result(orderService.selectOrder(orderId));
    }

    @GetMapping("/list")
    public Object selectOrders(@RequestParam("user_id") Integer userId,
                               @RequestParam("size") Integer size) {
        return result(orderService.selectOrders(userId, size));
    }

    /**
     * 为了方便，直接将返回对象转换成 JSON 字符串
     * @param object 返回对象
     * @return JSON字符串
     */
    private String result(Object object) {
        return JSONObject.toJSONString(object);
    }
}
