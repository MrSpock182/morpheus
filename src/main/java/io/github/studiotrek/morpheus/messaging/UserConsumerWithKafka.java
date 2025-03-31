package io.github.studiotrek.morpheus.messaging;

import io.github.studiotrek.morpheus.messaging.dto.UserListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserConsumerWithKafka {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumerWithKafka.class);

    //    @RetryableTopic(
//            autoCreateTopics = "false",
//            backoff = @Backoff(
//                    delay = 15000,
//                    multiplier = 2.0,
//                    maxDelay = 54000),
//            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE
//    )
    @KafkaListener(
            topics = "${spring.kafka.topic.msk-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "userConsumerFactory")
    public void listener(@Payload final UserListener payload) {
        LOGGER.info("MENSAGEM CHEGOU: " + payload.getName());
    }

}
