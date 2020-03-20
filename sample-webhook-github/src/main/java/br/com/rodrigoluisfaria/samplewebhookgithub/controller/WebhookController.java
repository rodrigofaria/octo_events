package br.com.rodrigoluisfaria.samplewebhookgithub.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigoluisfaria.samplewebhookgithub.dao.EventRepository;
import br.com.rodrigoluisfaria.samplewebhookgithub.model.Event;
import br.com.rodrigoluisfaria.samplewebhookgithub.util.EventConverter;

@RestController
public class WebhookController {

	@Autowired
	private EventRepository eventRepository;
	
	@GetMapping(path = "/issues/{issue}/events", produces = "application/json")
	public List<Event> getEventByNumber(@PathVariable Long issue) {
		List<br.com.rodrigoluisfaria.samplewebhookgithub.po.Event> events = eventRepository.findByNumber(issue);
		
		return events.stream()
			.map(e -> EventConverter.convertPoToModel(e))
			.collect(Collectors.toList());
	}
	
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public void webhook(@RequestBody Event event) {
		eventRepository.save(EventConverter.convertModelToPo(event));
	}
	
}
