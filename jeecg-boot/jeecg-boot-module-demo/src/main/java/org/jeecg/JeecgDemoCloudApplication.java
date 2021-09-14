package org.jeecg;

import org.jeecg.aop.pojo.impl.MyLogPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class JeecgDemoCloudApplication {



    public static void main(String[] args) {



        ApplicationContext context = SpringApplication.run(JeecgDemoCloudApplication.class, args);

        MyLogPrint myLogPrint = context.getBean(MyLogPrint.class);

        myLogPrint.doPrint();



    }
}
