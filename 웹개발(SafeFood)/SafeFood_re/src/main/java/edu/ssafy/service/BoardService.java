package edu.ssafy.service;

import java.io.IOException;
import java.util.List;

import edu.ssafy.dto.Board;
import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;

public interface BoardService {

	public void insertBoard(String title, String writer, String date, String contents, String hits, String pw);

	public void deleteBoard(String num);

	public void updateBoard(String num, String title, String writer, String date, String contents);

	public Board searchBoard(String num);
	
	public List<Board> searchBoardList();

	public void updateHits(String num);
	
}
