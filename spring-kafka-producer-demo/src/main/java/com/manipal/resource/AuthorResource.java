package com.manipal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.Author;

@RestController
//@RequestMapping("author")
public class AuthorResource {
	// wrap producer instance and provide methods to send message to kafka topic
	//Demo 2
	@Autowired
	private KafkaTemplate<String, Author> kafkaTemplate;
	private String topicAuthor = "author_topic";
	
	@GetMapping("/publish/author/{name}")
	public String publishAuthor(@PathVariable("name") String authorName ) {
		kafkaTemplate.send(topicAuthor, new Author(authorName,10,"Bangalore"));
		return "Published Message Successfully in the Topic";
	}	
}









