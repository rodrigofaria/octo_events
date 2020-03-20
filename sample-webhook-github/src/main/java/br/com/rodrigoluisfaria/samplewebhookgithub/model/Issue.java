package br.com.rodrigoluisfaria.samplewebhookgithub.model;

public class Issue {

	private Long number;
	private String title;
	private String created_at;
	private String updated_at;
	private String closed_at;
	
	public Issue(Long number, String title, String created_at, String updated_at, String closed_at) {
		super();
		this.number = number;
		this.title = title;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.closed_at = closed_at;
	}
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getClosed_at() {
		return closed_at;
	}
	public void setClosed_at(String closed_at) {
		this.closed_at = closed_at;
	}
	
	@Override
	public String toString() {
		return number + " - " +
			   title + " - " +
			   created_at + " - " +
			   updated_at + " - " +
			   closed_at;
	}
}
