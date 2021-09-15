package org.jeecg.common.testfeign.api;


import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 动态feign接口定义
 */
public interface TestFeignDyn {

    @GetMapping(value = "/test/getMessage")
    Result<String> getMessage(@RequestParam("name") String name);

}
