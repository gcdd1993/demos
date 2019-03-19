package com.gcdd.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author gaochen
 * @date 2019/3/5
 */
@Data
@Document(collection = "todo")
public class Todo {
    @Id
    private String id;
    private String desc;
    private boolean completed;
}
