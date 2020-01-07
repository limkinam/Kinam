package edu.ssafy.repository;

import java.io.IOException;
import java.util.List;

import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;

public interface MemberRepo {
	// 멤버

	public void addMem(String id, String pw, String email, String name, int cm, int kg, String gender, String allergy,
			String favor, String eating, int money);

	public void delMem(String id);

	public void updateMem(String id, String pw, String email, String name, int cm, int kg, String gender,
			String allergy, String favor, String eating, int money);

	public Member searchMem(String id);

	public void updatefavor(String id, String favor);

	public void updateeating(String id, String favor);
}
