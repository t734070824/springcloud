package com.itmuch.cloud.study;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author 734070824@qq.com
 * @date 2019/6/11 17:47
 */

@Component
public class UserFeignClientFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }
}
