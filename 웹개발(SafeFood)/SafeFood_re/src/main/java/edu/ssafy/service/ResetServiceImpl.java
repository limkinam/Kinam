package edu.ssafy.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.Reset;
import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.dto.Reset;
import edu.ssafy.repository.ResetRepo;
import edu.ssafy.repository.FoodRepo;
import edu.ssafy.repository.ResetRepo;

@Service("ResetServiceImpl")
public class ResetServiceImpl implements ResetService {

	@Autowired
	@Qualifier("ResetMybatisRepoImpl")
	private ResetRepo repo;

	@Override
	public void insertReset(String id, String date) {
		// TODO Auto-generated method stub
		repo.insertReset(id, date);
	}

	@Override
	public void deleteReset(String id) {
		// TODO Auto-generated method stub
		repo.deleteReset(id);
	}

	@Override
	public void updateReset(String id, String date) {
		// TODO Auto-generated method stub
		repo.updateReset(id, date);
	}

	@Override
	public Reset seletone(String id) {
		// TODO Auto-generated method stub
		return repo.seletone(id);
	}

	

}
