package org.jeecg.common.testfeign;

import org.springframework.stereotype.Service;

@Service
public class TestFeignImpl implements TestFeign {
    @Override
    public String feignM1() {
        return "feignM1";
    }
}
