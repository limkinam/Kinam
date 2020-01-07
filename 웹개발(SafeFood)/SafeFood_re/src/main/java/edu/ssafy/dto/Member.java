package edu.ssafy.dto;

public class Member {
	private String id;
	private String pw;
	private String email;
	private String name;
	private int cm;
	private int kg;
	private String gender;
	private String allergy;
	private String favor;
	private String eating;
	private int money;
	
	//생성자
	
	
	
	
	public Member(String id, String pw, String email, String name, int cm, int kg, String gender, String allergy,
			String favor, String eating, int money) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.name = name;
		this.cm = cm;
		this.kg = kg;
		this.gender = gender;
		this.allergy = allergy;
		this.favor = favor;
		this.eating = eating;
		this.money = money;
	}


	public Member(String id, String favor, String eating) {
		super();
		this.id = id;
		this.favor = favor;
		this.eating = eating;
	}

	//getter 와 setter
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCm() {
		return cm;
	}

	public void setCm(int cm) {
		this.cm = cm;
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getFavor() {
		return favor;
	}

	public void setFavor(String favor) {
		this.favor = favor;
	}

	public String getEating() {
		return eating;
	}

	public void setEating(String eating) {
		this.eating = eating;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", email=" + email + ", name=" + name + ", cm=" + cm + ", kg=" + kg
				+ ", gender=" + gender + ", allergy=" + allergy + ", favor=" + favor + ", eating=" + eating + ", money="
				+ money + "]";
	}

	
	
	
	
	
}
