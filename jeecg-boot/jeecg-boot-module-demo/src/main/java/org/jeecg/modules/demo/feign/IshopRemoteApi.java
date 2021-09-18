package org.jeecg.modules.demo.feign;


import org.jeecg.modules.demo.feign.fallback.IshopRemoteFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "jeecg-shop", fallbackFactory = IshopRemoteFallback.class)
public interface IshopRemoteApi {

    @GetMapping("/shop/hello")
    String remoteHello();

}
