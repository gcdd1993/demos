package com.gcdd1993.spring.framework.base.service;

import com.gcdd1993.spring.framework.base.dao.ItemDao;
import com.gcdd1993.spring.framework.base.domain.Item;
import lombok.Data;

/**
 * @author gaochen
 * @date 2019/3/26
 */
@Data
public class ItemService {
    private ItemDao itemDao;

    public Item findOne() {
        return itemDao.findOne();
    }
}
