package com.gcdd.mongodb;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaochen
 * @date 2019/3/5
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(todo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id,
                                    @RequestBody Todo todo) {
        Todo one = todoRepository.findOne(id);
        BeanUtils.copyProperties(todo, one);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(one));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(todoRepository.findAll());
    }

}
