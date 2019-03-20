package com.gcdd.cloudconsulclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gaochen on 2018/5/22.
 */
@FeignClient(value = "consul-server-1")
public interface ServiceTest {

    @GetMapping(value = "/get")
    String get();

    @PostMapping(value = "/post")
    String post(String str);

    @PutMapping(value = "/put/{id}")
    String put(@PathVariable("id") Integer id,
               @RequestBody String str);

    @DeleteMapping(value = "/delete/{id}")
    String delete(@PathVariable("id") Integer id);

}
