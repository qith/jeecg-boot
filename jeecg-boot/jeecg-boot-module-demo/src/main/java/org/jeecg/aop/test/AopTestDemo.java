package org.jeecg.aop.test;


import org.jeecg.aop.config.AopConfig;
import org.jeecg.aop.pojo.impl.MyLogPrint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopTestDemo {

    private static final Logger log = LoggerFactory.getLogger(AopTestDemo.class);

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        MyLogPrint myLogPrint = context.getBean(MyLogPrint.class);

        myLogPrint.doPrint();

    }

}
