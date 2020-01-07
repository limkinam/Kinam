package edu.ssafy.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.repository.FoodRepo;
import edu.ssafy.repository.MemberRepo;

@Service("MemberServiceImpl")
public class MemServiceImpl implements MemService {

	@Autowired
	@Qualifier("MemberMybatisRepoImpl")
	private MemberRepo repo;

	@Override
	public void addMem(String id, String pw, String email, String name, int cm, int kg, String gender, String allergy,
			String favor, String eating, int money) {
		// TODO Auto-generated method stub
		repo.addMem(id, pw, email, name, cm, kg, gender, allergy, favor, eating, money);
	}

	@Override
	public void delMem(String id) {
		// TODO Auto-generated method stub
		repo.delMem(id);
	}

	@Override
	public void updateMem(String id, String pw, String email, String name, int cm, int kg, String gender,
			String allergy, String favor, String eating, int money) {
		// TODO Auto-generated method stub
		repo.updateMem(id, pw, email, name, cm, kg, gender, allergy, favor, eating, money);
	}

	@Override
	public Member searchMem(String id) {
		// TODO Auto-generated method stub
		return repo.searchMem(id);
	}

	@Override
	public void updatefavor(String id, String favor) {
		// TODO Auto-generated method stub
		repo.updatefavor(id, favor);
	}

	@Override
	public void updateeating(String id, String eating) {
		// TODO Auto-generated method stub
		repo.updateeating(id, eating);
	}

}
