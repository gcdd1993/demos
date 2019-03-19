package com.gcdd.cloudconsulclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class CloudConsulClientApplication {

    @Autowired
    private ServiceTest serviceTest;

    @GetMapping(value = "/get")
    public String get() {
        return serviceTest.get();
    }

    @PostMapping(value = "/post")
    public String post(@RequestBody String str) {
        return serviceTest.post(str);
    }

    @PutMapping(value = "/put/{id}")
    public String put(@PathVariable("id") Integer id,
                      @RequestBody String str) {
        return serviceTest.put(id,str);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        return serviceTest.delete(id);
    }


    public static void main(String[] args) {
        SpringApplication.run(CloudConsulClientApplication.class, args);
    }
}
