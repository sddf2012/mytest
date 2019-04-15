package com.processor;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/11/7
 */
@Component
public class MyMessagePostProcessor implements MessagePostProcessor {
    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        return message;
    }

    @Override
    public Message postProcessMessage(Message message, Correlation correlation) {
        /*if (correlation instanceof CorrelationData) {
            String id = ((CorrelationData) correlation).getId();
            if (StringUtils.hasText(id)) {
                message.getMessageProperties().setCorrelationId(id);
            }
        }*/
        return postProcessMessage(message);
    }
}
