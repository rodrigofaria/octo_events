package br.com.rodrigoluisfaria.samplewebhookgithub.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import br.com.rodrigoluisfaria.samplewebhookgithub.RestServiceApplication;
import br.com.rodrigoluisfaria.samplewebhookgithub.model.Event;
import br.com.rodrigoluisfaria.samplewebhookgithub.model.Issue;

@SpringBootTest(classes = RestServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebhookControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getEventByNumber_test() {
		HttpHeaders headers = new HttpHeaders();
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		String url = getRootUrl() + "/issues/256/events";
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void webhook_test() {
		Event event = createEvent();

		ResponseEntity<Event> postResponse = restTemplate.postForEntity(getRootUrl(), event, Event.class);
		
		assertTrue(postResponse.getStatusCode().is2xxSuccessful());
	}

	private String getRootUrl() {
		return "http://localhost:80";
	}
	
	private Event createEvent() {
		return new Event(
				"open",
				new Issue(99l, "title", "created_at", "updated_at", "closed_at"));
	}
}
