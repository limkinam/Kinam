package edu.ssafy.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Board;
import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.handler.FoodSaxParser;

@Repository("BoardMybatisRepoImpl")
public class BoardMybatisRepoImpl implements BoardRepo {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insertBoard(String title, String writer, String date, String contents, String hits, String pw) {
		// TODO Auto-generated method stub
		Board board = new Board(0,title,writer,date,contents,Integer.parseInt(hits),pw);
		session.insert("sql.board.insertboard", board);
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		session.delete("sql.board.deleteboard", num);
	}

	@Override
	public void updateBoard(int num, String title, String writer, String date, String contents) {
		// TODO Auto-generated method stub
		Board board = new Board(num,title,writer,date,contents);
		session.update("sql.board.updateboard", board);
	}

	@Override
	public List<Board> searchBoardList() {
		// TODO Auto-generated method stub
		return session.selectList("sql.board.selectboardlist");
	}

	@Override
	public Board searchBoard(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("sql.board.selectboard", Integer.parseInt(num));
	}

	@Override
	public void updateHits(String num) {
		// TODO Auto-generated method stub
		session.update("sql.board.UpdateHits",Integer.parseInt(num));
	}


	
}
