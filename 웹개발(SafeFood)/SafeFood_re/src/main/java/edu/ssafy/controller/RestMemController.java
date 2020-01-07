package edu.ssafy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.dto.Member;
import edu.ssafy.service.FoodService;
import edu.ssafy.service.MemService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/member")
public class RestMemController {

	@Autowired
	@Qualifier("MemberServiceImpl")
	MemService ser;
	
	@ApiOperation(value = "멤버 입력")
	@RequestMapping(value = "/addMem", method = RequestMethod.POST)
	public void addMem(String id, String pw,String email,String name,int cm,int kg, String gender, String allergy,String favor,String eating,int money) {
		ser.addMem(id, pw, email, name, cm, kg, gender, allergy, favor, eating, money);
	}

	@ApiOperation(value = "멤버 삭제")
	@RequestMapping(value = "/delMem/{id}", method = RequestMethod.DELETE)
	public void delMem(@PathVariable String id) {
		ser.delMem(id);
	}

	@ApiOperation(value = "멤버 수정")
	@RequestMapping(value = "/updateMem", method = RequestMethod.PUT)
	public void updateMem(String id, String pw,String email,String name,int cm,int kg, String gender, String allergy,String favor,String eating,int money) {
		ser.updateMem(id, pw, email, name, cm, kg, gender, allergy, favor, eating, money);
	}

	@ApiOperation(value = "ID로 멤버 정보 검색", response = Member.class)
	@RequestMapping(value = "/memInfo/{id}", method = RequestMethod.GET)
	public Member memInfo(@PathVariable String id) {
		return ser.searchMem(id);
	}
	
}
