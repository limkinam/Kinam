package edu.ssafy.repository;

import edu.ssafy.dto.Reset;

public interface ResetRepo {
	public void insertReset(String id,String date);

	public void deleteReset(String id);

	public void updateReset(String id,String date);
	
	public Reset seletone(String id);
}
