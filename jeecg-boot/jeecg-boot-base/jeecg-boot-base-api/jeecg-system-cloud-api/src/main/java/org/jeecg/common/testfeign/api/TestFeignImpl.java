package org.jeecg.common.testfeign.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFeignImpl implements TestFeign {

    @Override
    public String feignM1(String msg) {
        return msg;
    }
}
