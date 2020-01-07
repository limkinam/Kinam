package edu.ssafy.dto;

public class Board {
	private int num;
	private String title;
	private String writer;
	private String date;
	private String contents;
	private int hits;
	private String pw;
	
	
	
	public Board() {
		super();
	}

	public Board(int num, String title, String writer, String date, String contents) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.contents = contents;
	}

	public Board(int num, String title, String writer, String date, String contents, int hits, String pw) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.contents = contents;
		this.hits = hits;
		this.pw = pw;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getPw() {
		return pw;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", writer=" + writer + ", date=" + date + ", contents="
				+ contents + ", hits=" + hits + ", pw=" + pw + "]";
	}
	
	
	
}
