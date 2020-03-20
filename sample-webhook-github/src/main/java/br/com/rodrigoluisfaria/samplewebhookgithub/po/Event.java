package br.com.rodrigoluisfaria.samplewebhookgithub.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "action")
	private String action;
	@Column(name = "number")
	private Long number;
	@Column(name = "title")
	private String title;
	@Column(name = "created_at")
	private String created_at;
	@Column(name = "updated_at")
	private String updated_at;
	@Column(name = "closed_at")
	private String closed_at;
	
	public Event() {
		super();
	}
	
	public Event(Long id, String action, Long number, String title, String created_at, String updated_at, String closed_at) {
		super();
		this.id = id;
		this.action = action;
		this.number = number;
		this.title = title;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.closed_at = closed_at;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
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
}
