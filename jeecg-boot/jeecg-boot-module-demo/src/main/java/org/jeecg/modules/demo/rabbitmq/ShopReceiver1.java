package org.jeecg.modules.demo.rabbitmq;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.rabbitmq.core.BaseRabbiMqHandler;
import org.jeecg.boot.starter.rabbitmq.listenter.MqListener;
import org.jeecg.common.annotation.RabbitComponent;
import org.jeecg.common.base.BaseMap;
import org.jeecg.modules.demo.cloud.entity.User;
import org.jeecg.tools.CloudConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;

@Slf4j
@RabbitListener(queues = CloudConstant.MQ_JEECG_SHOP_TEST)
@RabbitComponent(value = "shopReceiver1")
public class ShopReceiver1 extends BaseRabbiMqHandler<String> {

    @RabbitHandler
    public void onMessage(String str, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        super.onMessage(str, deliveryTag, channel, new MqListener<String>() {
            @Override
            public void handler(String str, Channel channel) {
                log.info("MQ：shopReceiver1= " + str);
            }

        });
    }

}
