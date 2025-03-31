package io.github.studiotrek.morpheus.configuration;

import io.github.studiotrek.morpheus.messaging.dto.UserListener;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class UserConsumerKafkaConfig {
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserListener> userConsumerFactory(
            final SslBundles sslBundles, final KafkaProperties kafkaProperties) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, UserListener>();
        factory.setConsumerFactory(consumerFactory(sslBundles, kafkaProperties));
        return factory;
    }

    private ConsumerFactory<String, UserListener> consumerFactory(
            final SslBundles sslBundles, final KafkaProperties kafkaProperties) {
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.addTrustedPackages("*");
        JsonDeserializer<UserListener> valueDeserializer = new JsonDeserializer<>(UserListener.class);
        valueDeserializer.setTypeMapper(typeMapper);
        valueDeserializer.setUseTypeMapperForKey(true);
        return new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(sslBundles),
                new StringDeserializer(),
                valueDeserializer);
    }
}
