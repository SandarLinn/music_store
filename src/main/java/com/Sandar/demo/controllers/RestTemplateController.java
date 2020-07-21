package com.Sandar.demo.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.Sandar.demo.models.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Controller
public class RestTemplateController {

	RestTemplate restTemplate =  new RestTemplate();
	private String baseUrl =  "https://jsonplaceholder.typicode.com";
	
	@RequestMapping(value="/testGetRestTemplate", method=RequestMethod.GET)
	public @ResponseBody String testGetRestTemplate() {
		
		 String url = "https://jsonplaceholder.typicode.com/posts";
		 
		 String response = restTemplate.getForObject(url , String.class); 
		
		 return response;
	}
	
	@RequestMapping(value="/testPostRestTemplate", method=RequestMethod.GET)
	public @ResponseBody String testPostRestTemplate() throws JsonProcessingException {
		
		Employee employee = new Employee();
		employee.setId(100);
		employee.setTitle("Sandar Title");
		employee.setBody("Sandar Body");
		employee.setUserId(100);
		
		 String url = "https://jsonplaceholder.typicode.com/posts";
		 
		 Employee response = restTemplate.postForObject(url ,employee, Employee.class); 
		 ObjectMapper mapper = new ObjectMapper();
		 String jsonStr = mapper.writeValueAsString(response);
		
		 return jsonStr;
	}
	
	@RequestMapping(value="/testGetWebClient", method=RequestMethod.GET)
	public @ResponseBody JsonNode testGetWebClient() {
		WebClient webClient = WebClient.builder().baseUrl(baseUrl).defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
		JsonNode result = webClient.get().uri("/posts").retrieve().bodyToMono(JsonNode.class).block();
		
		return result;
	}
	
	@RequestMapping(value="/testPostWebClient", method=RequestMethod.GET)
	public @ResponseBody Employee testPostWebClient() {
		Employee employee = new Employee();
		employee.setId(100);
		employee.setTitle("ChitSu Title");
		employee.setBody("ChitSu Body");
		employee.setUserId(101);
		
		BodyInserter<Object, ReactiveHttpOutputMessage> bodyInserter
        = BodyInserters.fromObject(employee);
		
		WebClient webClient = WebClient.builder().baseUrl(baseUrl).defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
		Employee result = webClient.post().uri("/posts").body(bodyInserter).retrieve().bodyToMono(Employee.class).block();
		
		return result;
	}
}
