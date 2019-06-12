package com.itmuch.cloud.study;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author 734070824@qq.com
 * @date 2019/6/11 17:48
 */

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClientWithFallbackFactory> {

    @Override
    public UserFeignClientWithFallbackFactory create(Throwable throwable) {
        return new UserFeignClientWithFallbackFactory() {
            @Override
            public User findById(Long id) {
                System.err.println("回退原因:" + throwable);
                return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
            }
        };
    }
}
