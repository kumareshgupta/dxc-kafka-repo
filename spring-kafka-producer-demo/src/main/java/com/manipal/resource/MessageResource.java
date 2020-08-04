package com.manipal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("author")

public class MessageResource {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private String topicMessage = "message_topic";
	@GetMapping("/publish/{message}")
	public String publish(@PathVariable String message ) {
		kafkaTemplate.send(topicMessage, message);
		return "Published Message Successfully in the Topic";
	}

}
