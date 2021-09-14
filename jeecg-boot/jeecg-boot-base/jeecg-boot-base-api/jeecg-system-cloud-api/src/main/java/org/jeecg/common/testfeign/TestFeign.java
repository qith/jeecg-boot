package org.jeecg.common.testfeign;

import org.jeecg.common.constant.ServiceNameConstants;
import org.jeecg.common.system.api.factory.SysBaseAPIFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(contextId = "testFeign", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = SysBaseAPIFallbackFactory.class)
public interface TestFeign {

    @GetMapping("/sys/feignM1")
    public String feignM1();
}
