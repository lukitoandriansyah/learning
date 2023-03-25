package com.lukito.kafkaconsumersdatabases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabasesConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabasesConsumer.class);
    @KafkaListener(topics = "wikimedia_recent-change", groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event Message received -> %s", eventMessage));
    }
}
