package com.itmuch.cloud.study;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 734070824@qq.com
 * @date 2019/6/11 17:48
 */

@FeignClient(name = "microservice-simple-provider-user", fallback = UserFeignClientFallbackFactory.class)
public interface UserFeignClientWithFallbackFactory {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
