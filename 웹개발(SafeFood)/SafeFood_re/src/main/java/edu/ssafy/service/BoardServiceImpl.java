package edu.ssafy.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.Board;
import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.repository.BoardRepo;
import edu.ssafy.repository.FoodRepo;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("BoardMybatisRepoImpl")
	private BoardRepo repo;

	@Override
	public void insertBoard(String title, String writer, String date, String contents, String hits, String pw) {
		// TODO Auto-generated method stub
		repo.insertBoard(title, writer, date, contents, hits, pw);
	}

	@Override
	public void deleteBoard(String num) {
		// TODO Auto-generated method stub
		repo.deleteBoard(Integer.parseInt(num));
	}

	@Override
	public void updateBoard(String num, String title, String writer, String date, String contents) {
		// TODO Auto-generated method stub
		repo.updateBoard(Integer.parseInt(num), title, writer, date, contents);
	}

	@Override
	public List<Board> searchBoardList() {
		// TODO Auto-generated method stub
		return repo.searchBoardList();
	}

	@Override
	public Board searchBoard(String num) {
		// TODO Auto-generated method stub
		return repo.searchBoard(num);
	}

	@Override
	public void updateHits(String num) {
		repo.updateHits(num);
	}

}
