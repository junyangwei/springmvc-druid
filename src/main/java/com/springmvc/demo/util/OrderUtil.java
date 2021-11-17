package com.springmvc.demo.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 订单工具类
 * @author junyangwei
 * @date 2021-11-17
 */
public class OrderUtil {
    /**
     * 递增最大值
     */
    static final int MAX_INCR_NUM = 10000;

    /**
     * 递增属性值
     */
    static final AtomicInteger incrAtomic = new AtomicInteger();

    /**
     * 生成订单ID
     * 算法：时间戳(去除前两位) + 线程ID与100的余数 + 自增ID(0000~9999) 的形式
     */
    public static long orderIdGenerator() {
        // 获取系统时间戳（毫秒）
        long time = System.currentTimeMillis();

        // 去除前两位经常不变的
        String ts = Long.toString(time).substring(2);

        // 获取线程ID值，计算方式为：线程ID与100的余数
        long threadId = Thread.currentThread().getId() % 100;

        return Long.valueOf(ts) * 1000000 + threadId * 10000 + getIncrNum();
    }

    /**
     * 自增值的取值范围为[0, 9999]
     * @return 递增值
     */
    private static long getIncrNum() {
        return incrAtomic.incrementAndGet() % MAX_INCR_NUM;
    }

    /**
     * 单元测试方法
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getId() + " " + OrderUtil.orderIdGenerator());
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getId() + " " + OrderUtil.orderIdGenerator());
            }
        });
        thread1.start();
        thread2.start();
    }
}
