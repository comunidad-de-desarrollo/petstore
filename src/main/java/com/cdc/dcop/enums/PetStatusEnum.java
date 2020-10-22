package com.cdc.dcop.enums;

import java.util.HashMap;
import java.util.Map;

public enum PetStatusEnum {

    AVAILABLE   (1L, "available"),
    PENDING     (2L, "pending"),
    SOLD        (3L, "sold");

    private Long id;
    private String name;


    private static Map map = new HashMap<String, PetStatusEnum>();

    PetStatusEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    static {
        for (PetStatusEnum petStatusEnum: PetStatusEnum.values()) {
            map.put(petStatusEnum.name, petStatusEnum);
        }
    }

    public static PetStatusEnum valueOfName(String name) {
        return (PetStatusEnum) map.get(name);
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
