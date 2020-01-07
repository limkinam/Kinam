package edu.ssafy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.dto.Board;
import edu.ssafy.dto.Member;
import edu.ssafy.service.BoardService;
import edu.ssafy.service.MemService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/rest/board")
public class RestBoardController {
	@Autowired
	@Qualifier("BoardServiceImpl")
	BoardService ser;

	@ApiOperation(value = "게시판 리스트 출력")
	@GetMapping(value = "/findAllBoard")
	public List<Board> SearchAllBoard() {
		return ser.searchBoardList();
	}
	@ApiOperation(value = "게시판 상세페이지")
	@GetMapping(value = "/detailBoard/{num}")
	public Board SearchOne(@PathVariable String num) {
		ser.updateHits(num);
		return ser.searchBoard(num);
	}
	@ApiOperation(value = "게시판 삭제")
	@DeleteMapping(value = "/deleteBoard/{num}")
	public void DeleteBoard(@PathVariable String num) {
		ser.deleteBoard(num);
	}
	@ApiOperation(value = "게시판 수정")
	@PostMapping(value = "/updateBoard")
	public void UpdateBoard(@RequestBody Board board) {
		ser.updateBoard(Integer.toString(board.getNum()), board.getWriter(),board.getDate(),board.getTitle(),board.getContents());
	}
	@ApiOperation(value = "게시판 추가")
	@PostMapping(value = "/addBoard")
	public void search_name(@RequestBody Board board) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		String today = format.format(date);
		ser.insertBoard(board.getTitle(),board.getWriter(),today,board.getContents(),"0",board.getPw());
	}
	
}
