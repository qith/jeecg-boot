package org.jeecg.common.testfeign.api;

import org.jeecg.common.api.CommonAPI;
import org.jeecg.common.constant.ServiceNameConstants;
import org.jeecg.common.system.api.factory.SysBaseAPIFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(contextId = "testFeign", value = ServiceNameConstants.SYSTEM_SERVICE)
public interface TestFeign extends CommonAPI {

    @GetMapping("/sys/api/feignm1")
    public String feignM1(@RequestParam("msg") String msg);
}
