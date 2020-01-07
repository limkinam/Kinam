package edu.ssafy.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Reset;
import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.dto.Reset;
import edu.ssafy.handler.FoodSaxParser;

@Repository("ResetMybatisRepoImpl")
public class ResetMybatisRepoImpl implements ResetRepo {

	@Autowired
	private SqlSession session;

	@Override
	public void insertReset(String id, String date) {
		// TODO Auto-generated method stub
		session.insert("sql.reset.insertreset",new Reset(id,date));
	}

	@Override
	public void deleteReset(String id) {
		// TODO Auto-generated method stub
		session.delete("sql.reset.deletereset",id);
	}

	@Override
	public void updateReset(String id, String date) {
		// TODO Auto-generated method stub
		session.delete("sql.reset.updatereset",new Reset(id,date));
	}

	@Override
	public Reset seletone(String id) {
		// TODO Auto-generated method stub
		return session.selectOne("sql.reset.selectreset", id);
	}
	

	
}
