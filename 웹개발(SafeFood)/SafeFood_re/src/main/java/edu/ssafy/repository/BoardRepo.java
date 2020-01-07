package edu.ssafy.repository;

import java.io.IOException;
import java.util.List;

import edu.ssafy.dto.Board;
import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;

public interface BoardRepo {
	
	public void insertBoard(String title,String writer,String date,String contents,String hits,String pw);
	
	public void deleteBoard(int num);
	
	public void updateBoard(int num,String title,String writer,String date,String contents);
	
	public List<Board> searchBoardList();
	
	public Board searchBoard(String num);
	
	public void updateHits(String num);
}
