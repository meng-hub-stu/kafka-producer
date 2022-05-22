package com.bxfy.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Author Mengdexin
 * @date 2022 -05 -12 -22:52
 */
@Slf4j
@Component
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic, Object message){
        ListenableFuture future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("发送消息失败---" + ex.getMessage());
            }

            @Override
            public void onSuccess(Object result) {
                log.info("发送消息成功---", result.toString());
            }
        });
    }

    public void sendMessage(String topic, Integer partition,  Object message) {
        ListenableFuture future = kafkaTemplate.send(topic, partition, null, message);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("发送消息失败---" + ex.getMessage());
            }

            @Override
            public void onSuccess(Object result) {
                log.info("发送消息成功---", result.toString());
            }
        });
    }

}
