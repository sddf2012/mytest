package com.util;

import com.message.MyMessage;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author liu peng bo
 * @date 2018/11/7
 */
public class MessageSendUtils {
    private static RabbitTemplate rabbitTemplate() {
        return SpringContextUtils.getBean(RabbitTemplate.class);
    }

    private static MessagePostProcessor postProcessor() {
        return SpringContextUtils.getBean(MessagePostProcessor.class);
    }

    public static void send(String exchange, String key, MyMessage message) {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(message.getId());
        rabbitTemplate().convertAndSend(exchange, key, message, postProcessor(), correlationData);
    }
}
