package edu.ssafy.service;

import java.io.IOException;
import java.util.List;

import edu.ssafy.dto.Reset;
import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.dto.Reset;

public interface ResetService {

	public void insertReset(String id,String date);

	public void deleteReset(String id);

	public void updateReset(String id,String date);
	
	public Reset seletone(String id);
}
