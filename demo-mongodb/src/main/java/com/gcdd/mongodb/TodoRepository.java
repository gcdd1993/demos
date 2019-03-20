package com.gcdd.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author gaochen
 * @date 2019/3/5
 */
public interface TodoRepository extends MongoRepository<Todo, String> {
}
