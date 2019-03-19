package com.gcdd.cloudconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class CloudConsulApplication {

    @GetMapping("/get")
    public String get() {
        return "Hello world";
    }

    @PostMapping("/post")
    public String post(@RequestBody String str) {
        return "post " + str + "success";
    }

    @PutMapping("/put/{id}")
    public String home(@PathVariable("id") Integer id,
                       @RequestBody String str) {
        return "put " + id + " " + str + "success";
    }

    @DeleteMapping("/delete/{id}")
    public String home(@PathVariable("id") Integer id) {
        return "delete " + id;
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulApplication.class, args);
    }
}
