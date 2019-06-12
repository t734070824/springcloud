package com.didispace;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 734070824@qq.com
 * @date 2019/6/12 10:46
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }
}
