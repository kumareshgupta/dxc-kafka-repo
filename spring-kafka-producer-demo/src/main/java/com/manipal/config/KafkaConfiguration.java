package com.manipal.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.manipal.model.Author;

@Configuration
public class KafkaConfiguration {
	@Bean
	public ProducerFactory<String, Author> producerFactoryAuthor() {
		Map<String, Object> configMap = new HashMap<>();		
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		ProducerFactory<String, Author> producerFactory = new DefaultKafkaProducerFactory<>(configMap);
		return producerFactory;			
	}
	
	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> configMap = new HashMap<>();		
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(configMap);
		return producerFactory;			
	}
	
	@Bean
	public KafkaTemplate<String, Author> kafkaTemplate(){
		return new KafkaTemplate<String, Author>(producerFactoryAuthor());
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate1(){
		return new KafkaTemplate<String, String>(producerFactory());
	}
	
}
