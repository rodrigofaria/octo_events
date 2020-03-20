package br.com.rodrigoluisfaria.samplewebhookgithub.util;

import br.com.rodrigoluisfaria.samplewebhookgithub.model.Issue;
import br.com.rodrigoluisfaria.samplewebhookgithub.po.Event;

public class EventConverter {

	private EventConverter() { }
	
	public static Event convertModelToPo(br.com.rodrigoluisfaria.samplewebhookgithub.model.Event event) {
		Issue issue = event.getIssue();
		
		return new Event(null, 
				event.getAction(), 
				issue.getNumber(), 
				issue.getTitle(), 
				issue.getCreated_at(), 
				issue.getUpdated_at(), 
				issue.getClosed_at());
	}
	
	public static br.com.rodrigoluisfaria.samplewebhookgithub.model.Event convertPoToModel(Event event) {
		Issue issue = new Issue(
				event.getNumber(), 
				event.getTitle(), 
				event.getCreated_at(), 
				event.getUpdated_at(), 
				event.getClosed_at());
		
		return new br.com.rodrigoluisfaria.samplewebhookgithub.model.Event(
				event.getAction(), 
				issue);
	}
	
}
