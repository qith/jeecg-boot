package org.jeecg.modules.demo.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.rabbitmq.client.RabbitMqClient;
import org.jeecg.common.api.vo.Result;

import org.jeecg.common.base.BaseMap;
import org.jeecg.common.constant.ServiceNameConstants;
import org.jeecg.common.system.api.ISysBaseAPI;
import org.jeecg.common.system.vo.DictModel;
import org.jeecg.modules.demo.cloud.entity.User;
import org.jeecg.modules.demo.feign.IshopRemoteApi;
import org.jeecg.starter.cloud.feign.impl.JeecgFeignService;
import org.jeecg.tools.CloudConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Slf4j
@Api(tags = "Cloud示例")
@RestController
@RequestMapping("/test")
@RefreshScope
public class JcloudDemoController {


    @Resource
    private ISysBaseAPI sysBaseAPI;

    @Autowired
    private IshopRemoteApi ishopRemoteApi;

    @Autowired
    RabbitMqClient rabbitMqClient;


    /**
     * Feign 测试，获取字典
     */
    @GetMapping("/remote")
    @ApiOperation(value = "测试feign", notes = "测试feign")
    public Result remoteDict() {
//        try{
//            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
//            Thread.sleep(5000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        List<DictModel> list = sysBaseAPI.queryAllDict();
        return Result.OK(list);
    }

    /**
     * Feign 测试，getRolesByUsername
     */
    @GetMapping("/getRolesByUsername")
    @ApiOperation(value="getRolesByUsername", notes = "getRolesByUsername")
    public Result remoteGetRolesByUsername(){
        List<String> list = sysBaseAPI.getRolesByUsername("admin");
        return Result.OK(list);
    }


    @GetMapping("/remoteShopHello")
    @ApiOperation(value="remoteShopHello", notes = "remoteShopHello")
    public Result remoteShopHello(){
        return Result.OK(ishopRemoteApi.remoteHello());
    }


    /**
     * 配置文件获取 测试，nacos 动态刷新
     */
    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    @GetMapping("/getConfigValue")
    @ApiOperation(value = "测试nacos config", notes = "测试nacos config")
    public Result<String> TestNacosConfig(){
        String configData = userName + " : " +age;
        return Result.OK(configData);

    }

    @ApiOperation(value = "sendRabbitMsg", notes = "sendRabbitMsg")
    @PostMapping(value = "/sendRabbitMsg")
    public void sendRabbitMsg(@RequestBody User user) {

        Map map = new BaseMap();
        map.put("user", user);
        rabbitMqClient.sendMessage(CloudConstant.MQ_JEECG_SHOP_TEST,map);
    }


}
