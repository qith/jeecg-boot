package org.jeecg.modules.demo.cloud.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;
    private String age;
}
