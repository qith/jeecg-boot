package org.jeecg.modules.demo.feign.fallback;

import feign.hystrix.FallbackFactory;
import org.jeecg.modules.demo.feign.IshopRemoteApi;

public class IshopRemoteFallback implements FallbackFactory<IshopRemoteApi> {

    @Override
    public IshopRemoteApi create(Throwable throwable) {
        return null;
    }
}
