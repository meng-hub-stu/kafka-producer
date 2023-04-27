package com.bfxy.kafka.producer.test;

import com.bxfy.kafka.Application;
import com.bxfy.kafka.producer.KafkaProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Mengdexin
 * @date 2022 -05 -21 -18:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private KafkaProducerService producerService;


    @Test
    public void send() {
        String topic = "topic04";
        for (int i = 0; i < 10; i++) {
            producerService.sendMessage(topic, "hello kafka ->" + i);
        }
    }

    @Test
    public void sendMessage() {
        String topic = "topic04";
        for (int i = 0; i < 10; i++) {
            producerService.sendMessage(topic, 1, "hello kafka ->" + i);
        }
    }
}
