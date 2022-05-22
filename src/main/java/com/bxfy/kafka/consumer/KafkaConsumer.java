package com.bxfy.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Mengdexin
 * @date 2022 -05 -21 -19:08
 */
@Component
@Slf4j
public class KafkaConsumer {

    private static AtomicInteger atomic = new AtomicInteger(0);


    @KafkaHandler
    @KafkaListener(groupId = "group02", topics = {"topic04"})
    public void consumerMessage(ConsumerRecord<String, Object> record,
                                Acknowledgment acknowledgeMode,
                                Consumer<?, ?> consumer){
        log.info("消费端接收消息->[{}, {}]", record.value(), record.partition());
        //手工签收机制。
        acknowledgeMode.acknowledge();
        System.out.println(atomic.getAndIncrement());
    }
}
