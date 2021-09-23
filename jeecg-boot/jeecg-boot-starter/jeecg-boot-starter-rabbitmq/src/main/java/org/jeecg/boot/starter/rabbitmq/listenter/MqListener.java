package org.jeecg.boot.starter.rabbitmq.listenter;

import com.rabbitmq.client.Channel;

public interface MqListener<T> {

    default void handler(T t, Channel channel) {
    }


}
