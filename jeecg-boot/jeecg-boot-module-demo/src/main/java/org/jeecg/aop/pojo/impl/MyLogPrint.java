package org.jeecg.aop.pojo.impl;

import org.jeecg.aop.pojo.LogPrint;
import org.springframework.stereotype.Component;

@Component
public class MyLogPrint implements LogPrint {
    @Override
    public void doPrint() {
        System.out.println("log print");
    }
}
