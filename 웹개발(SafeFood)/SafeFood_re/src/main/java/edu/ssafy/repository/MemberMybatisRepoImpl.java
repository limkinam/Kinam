package edu.ssafy.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.handler.FoodSaxParser;

@Repository("MemberMybatisRepoImpl")
public class MemberMybatisRepoImpl implements MemberRepo {

	@Autowired
	private SqlSession session;

	@Override
	public void addMem(String id, String pw, String email, String name, int cm, int kg, String gender, String allergy,
			String favor, String eating, int money) {
		// TODO Auto-generated method stub
		Member mem = new Member(id,pw,email,name,cm,kg,gender,allergy,favor,eating,money);
		session.insert("sql.member.insertmember",mem);
	}

	@Override
	public void delMem(String id) {
		// TODO Auto-generated method stub
		session.delete("sql.member.deletemember",id);
	}

	@Override
	public void updateMem(String id, String pw, String email, String name, int cm, int kg, String gender,
			String allergy, String favor, String eating, int money) {
		// TODO Auto-generated method stub
		Member mem = new Member(id,pw,email,name,cm,kg,gender,allergy,favor,eating,money);
		session.update("sql.member.updatemember",mem);
	}

	@Override
	public Member searchMem(String id) {
		// TODO Auto-generated method stub
		return session.selectOne("sql.member.selectmember", id);
	}

	@Override
	public void updatefavor(String id, String favor) {
		// TODO Auto-generated method stub
		session.update("sql.member.updatefavor",new Member(id,favor,null));
	}

	@Override
	public void updateeating(String id, String eating) {
		// TODO Auto-generated method stub
		session.update("sql.member.updateeating",new Member(id,null,eating));
	}

	
}
