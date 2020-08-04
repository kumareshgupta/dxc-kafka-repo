package com.manipal.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.manipal.model.Author;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "message_topic", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed message is " + message);
	}
	
	
	@KafkaListener(topics = "author_topic", groupId = "group_author", containerFactory = "authorKafkaListenerFactory")
	public void consumeAuthor(Author author) {
		System.out.println("Consumed message is " + author);
	}
}
