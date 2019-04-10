package com.gcdd1993.spring.framework.base.dao;

import com.gcdd1993.spring.framework.base.domain.Item;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class ItemDao {
    public Item findOne() {
        Item item = new Item();
        item.setName("xiaowang");
        item.setAge(20);
        return item;
    }
}
