package br.com.rodrigoluisfaria.samplewebhookgithub.model;

public class Event {

	private String action;
	private Issue issue;
	
	public Event(String action, Issue issue) {
		super();
		this.action = action;
		this.issue = issue;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return action + " - " + issue.toString();
	}
}
