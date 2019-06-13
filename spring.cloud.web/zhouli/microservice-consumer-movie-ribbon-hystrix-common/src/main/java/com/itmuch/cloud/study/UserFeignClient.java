package com.itmuch.cloud.study;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 734070824@qq.com
 * @date 2019/6/11 15:18
 */

@FeignClient(name = "microservice-simple-provider-user")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
