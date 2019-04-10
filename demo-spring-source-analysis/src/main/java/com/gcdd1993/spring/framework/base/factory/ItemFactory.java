package com.gcdd1993.spring.framework.base.factory;

import com.gcdd1993.spring.framework.base.domain.Item;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class ItemFactory {
    private static Item item = new Item();

    static {
        item.setName("xiaowang");
        item.setAge(20);
    }

    private ItemFactory() {
    }

    public static Item createInstance() {
        return item;
    }
}
