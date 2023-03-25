package com.lukito.kafkaconsumersdatabases;

import com.lukito.kafkaconsumersdatabases.entity.WikimediaData;
import com.lukito.kafkaconsumersdatabases.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabasesConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabasesConsumer.class);

    private final WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabasesConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event Message received -> %s", eventMessage));
        WikimediaData wikimediaData1 = new WikimediaData();
        wikimediaData1.setWikiEventData(eventMessage);

        wikimediaDataRepository.save(wikimediaData1);

    }
}
