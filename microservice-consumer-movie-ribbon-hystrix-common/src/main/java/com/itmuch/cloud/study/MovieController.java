package com.itmuch.cloud.study;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author 734070824@qq.com
 * @date 2019/6/11 11:05
 */
@RequestMapping("/movies")
@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
        User user = userFeignClient.findById(id);
        // ...电影微服务的业务...
        return user;
    }

    public User findByIdFallback(Long id){
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }


    public User findByIdFallback(Long id, Throwable throwable) {
        System.err.println("进入回退方法: " + throwable);
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }

}
