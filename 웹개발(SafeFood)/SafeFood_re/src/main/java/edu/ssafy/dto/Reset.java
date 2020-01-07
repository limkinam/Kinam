package edu.ssafy.dto;

public class Reset {
	private String id;
	private String date;
	public Reset(String id, String date) {
		super();
		this.id = id;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Reset [id=" + id + ", date=" + date + "]";
	}
}
