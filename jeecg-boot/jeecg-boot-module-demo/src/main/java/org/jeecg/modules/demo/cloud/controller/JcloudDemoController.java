package org.jeecg.modules.demo.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;

import org.jeecg.common.constant.ServiceNameConstants;
import org.jeecg.common.system.api.ISysBaseAPI;
import org.jeecg.common.system.vo.DictModel;
import org.jeecg.starter.cloud.feign.impl.JeecgFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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


}
