package edu.ssafy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Member;
import edu.ssafy.service.MemService;

@Controller("/")
public class LoginController {	
	@Autowired
	@Qualifier("MemberServiceImpl")
	MemService ser;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void Login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
        String pw = request.getParameter("pw");
		Member mem = ser.searchMem(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		if(mem==null) {
			request.setAttribute("msg", "존재하지않는 아이디입니다.");
			dispatcher.forward(request, response);
		}else if(!mem.getPw().equals(pw)) {
			request.setAttribute("msg", "비밀번호를 다시한번 확인해주세요");
			dispatcher.forward(request, response);
		}
		System.out.println("asdasd");
		request.getSession().setAttribute("id", id);
		response.sendRedirect("/");
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void Logout(HttpServletRequest request, HttpServletResponse response) {
			request.getSession().invalidate();
	}
	
	@RequestMapping("/")
	public ModelAndView vv(ModelAndView mv) {
		System.out.println("sda");
		mv.setViewName("index");
		return mv;
	}
}
