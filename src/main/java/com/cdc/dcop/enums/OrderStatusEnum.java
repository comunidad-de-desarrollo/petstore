package com.cdc.dcop.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatusEnum {
    PLACED      (1L, "placed"),
    APPROVED    (2L, "approved"),
    DELIVERED   (3L, "delivered");

    private Long id;
    private String name;


    private static Map map = new HashMap<String, OrderStatusEnum>();

    OrderStatusEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    static {
        for (OrderStatusEnum orderStatusEnum: OrderStatusEnum.values()) {
            map.put(orderStatusEnum.name, orderStatusEnum);
        }
    }

    public static OrderStatusEnum valueOfName(String name) {
        return (OrderStatusEnum) map.get(name);
    }

    public static boolean containsName(String name) {
        return map.containsKey(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
