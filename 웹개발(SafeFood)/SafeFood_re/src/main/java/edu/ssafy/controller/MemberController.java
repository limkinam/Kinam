package edu.ssafy.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

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

import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.service.FoodService;
import edu.ssafy.service.MemService;
import edu.ssafy.service.ResetService;

@Controller
public class MemberController {

	@Autowired
	@Qualifier("MemberServiceImpl")
	MemService ser;
	
	@Autowired
	@Qualifier("FoodServiceImpl")
	FoodService foodser;
	
	@Autowired
	@Qualifier("ResetServiceImpl")
	ResetService resetser;

	@RequestMapping(value = "registMemPage", method = RequestMethod.GET)
	public String registMemPage() {
		return "registerMem";
	}

	@RequestMapping(value = "registMem", method = RequestMethod.POST)
	public String registMem(HttpServletRequest req,HttpServletResponse res, ModelAndView mv) throws ServletException, IOException {
		String id = req.getParameter("pid");
		Member checkid = ser.searchMem(id);
		if(checkid!=null) {
			req.setAttribute("msg", "아이디 중복입니다.");
			return "registerMem";
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		String today = format.format(date);
		resetser.insertReset(id, today);
		String pw = req.getParameter("ppw");
		String name = req.getParameter("pname");
		String	email = req.getParameter("pemail");
		String cm = req.getParameter("pcm");
		String kg = req.getParameter("pkg");
		String gender = req.getParameter("pgender");
		String[] tmp = req.getParameterValues("pallergy");
		String allergy = "";
		if(tmp!=null) {
			for (int i = 0; i < tmp.length; i++) {
				allergy += tmp[i] + ",";
			}			
		}
		ser.addMem(id, pw, email, name, Integer.parseInt(cm), Integer.parseInt(kg), gender, allergy, "", "", 0);
		return "redirect:mainpage";
	}

	@RequestMapping(value = "searchpwPage", method = RequestMethod.GET)
	public String searchpwPage(HttpServletRequest req, ModelAndView mv) throws ServletException, IOException {
		return "searchpw";
	}

	@RequestMapping(value = "searchpw", method = RequestMethod.POST)
	public ModelAndView searchpw(HttpServletRequest req, ModelAndView mv) throws ServletException, IOException {
		String id = req.getParameter("pid");
		String name = req.getParameter("pname");
		Member mem = ser.searchMem(id);
		mv.addObject("id", id);
		mv.addObject("pw", mem.getPw());
		mv.setViewName("searchpw");
		return mv;
	}

	@RequestMapping(value = "loginMem", method = RequestMethod.POST)
	public String loginMem(HttpServletRequest req) throws ServletException, IOException {
		String id = req.getParameter("pid");
		String pw = req.getParameter("ppw");
		if(ser.searchMem(id)==null) {
			return "redirect:mainpage";
		}
		if (pw.equals(ser.searchMem(id).getPw())) {
			req.getSession().setAttribute("id", id);
			//지금 로그인 데이터 날짜 확인 후 초기화
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
			String today = format.format(date);
			if(!resetser.seletone(id).getDate().equals(today)) {
				resetser.updateReset(id, today);
				ser.updatefavor(id,"");
				ser.updateeating(id,"");
			}
			//
			return "redirect:mainpage";
		} else {
			// request.getRequestDispatcher("registerMem.html").forward(request, response);
			return "redirect:mainpage";
		}
	}

	@RequestMapping(value = "logoutMem", method = RequestMethod.GET)
	public String logoutMem(HttpServletRequest req) throws ServletException, IOException {
		req.getSession().setAttribute("id", null);
		req.getSession().invalidate();
		return "redirect:mainpage";
	}

	@RequestMapping(value = "myInfo", method = RequestMethod.GET)
	public ModelAndView myInfo(HttpServletRequest req, ModelAndView mv) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("id");
		Member mem = ser.searchMem(id);
		StringTokenizer stk = new StringTokenizer(mem.getFavor(),",");
		int k=stk.countTokens();
		double favorcal=0;
		double favortan=0;
		double favordan=0;
		double favorgi=0;
		double eatingcal=0;
		double eatingtan=0;
		double eatingdan=0;
		double eatinggi=0;
		
		List<Food> foodfavor = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			Food food = foodser.search(stk.nextToken());
			foodfavor.add(food);
			favorcal+=food.getCalory();
			favortan+=food.getCarbo();
			favordan+=food.getProtein();
			favorgi+=food.getFat();
		}
		stk = new StringTokenizer(mem.getEating(),",");
		k=stk.countTokens();
		List<Food> foodeating = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			Food food = foodser.search(stk.nextToken());
			foodeating.add(food);
			eatingcal+=food.getCalory();
			eatingtan+=food.getCarbo();
			eatingdan+=food.getProtein();
			eatinggi+=food.getFat();
		}
		double m = (double)mem.getCm()/100;
		int kg = mem.getKg();
		int bmi = (int) (kg/Math.pow(m, 2));
		String gender = mem.getGender();
		if(gender.equals("M")) {
			mv.addObject("reccal",2600);
			mv.addObject("rectan",1560);
			mv.addObject("recdan",390);
			mv.addObject("recgi",570);
			if(bmi<=20) {
				mv.addObject("img","img/마른라이언.jpg");
			}else if(bmi>20 && bmi<=30) {
				mv.addObject("img","img/건강라이언.jpg");
			}else {
				mv.addObject("img","img/뚱뚱라이언.jpg");
			}
		}else {
			mv.addObject("reccal",2100);
			mv.addObject("rectan",1260);
			mv.addObject("recdan",315);
			mv.addObject("recgi",460);
			if(bmi<=20) {
				mv.addObject("img","img/마름.jpg");
			}else if(bmi>20 && bmi<=30) {
				mv.addObject("img","img/건강.jpg");
			}else {
				mv.addObject("img","img/쿰척이.jpg");
			}
		}
		mv.addObject("favor", foodfavor);
		mv.addObject("eating", foodeating);
		mv.addObject("favorcal",Double.parseDouble(String.format("%.2f",favorcal)));
		mv.addObject("favortan",favortan*2);
		mv.addObject("favordan",favordan*10);
		mv.addObject("favorgi",favorgi*10);
		mv.addObject("eatingcal",Double.parseDouble(String.format("%.2f",eatingcal)));
		mv.addObject("eatingtan",eatingtan*2);
		mv.addObject("eatingdan",eatingdan*10);
		mv.addObject("eatinggi",eatinggi*10);
		if(mem.getFavor().length()-1>=0)
		mem.setFavor(mem.getFavor().substring(0,mem.getFavor().length()-1));
		if(mem.getEating().length()-1>=0)
		mem.setEating(mem.getEating().substring(0,mem.getEating().length()-1));
		if(mem.getAllergy().length()-1>=0)
		mem.setAllergy(mem.getAllergy().substring(0,mem.getAllergy().length()-1));
		mv.addObject("mem", mem);
		mv.setViewName("myinfo");
		return mv;
	}
	
	@RequestMapping(value = "memInfo", method = RequestMethod.GET)
	public ModelAndView memInfo(HttpServletRequest req, ModelAndView mv) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("id");
		Member mem = ser.searchMem(id);
		mv.addObject("mem", mem);
		mv.setViewName("meminfo");
		return mv;
	}

	@RequestMapping(value = "updateMem", method = RequestMethod.POST)
	public String updateMem(HttpServletRequest req) throws ServletException, IOException {
		String id = req.getParameter("pid");
		String pw = req.getParameter("ppw");
		String name = req.getParameter("pname");
		String	email = req.getParameter("pemail");
		String cm = req.getParameter("pcm");
		String kg = req.getParameter("pkg");
		String[] tmp = req.getParameterValues("pallergy");
		String allergy = "";
		if(tmp!=null) {
			for (int i = 0; i < tmp.length; i++) {
				allergy += tmp[i] + ",";
			}			
		}
		Member member = ser.searchMem(id);
		ser.updateMem(id, pw, email, name, Integer.parseInt(cm), Integer.parseInt(kg), member.getGender(), allergy, member.getFavor(), member.getEating(), member.getMoney());
		return "redirect:mainpage";
	}
	
	@RequestMapping(value = "addfavor", method = RequestMethod.GET)
	public String addfovor(HttpServletRequest req) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("id");
		String name = req.getParameter("pname");
		String favor = ser.searchMem(id).getFavor();
		StringTokenizer stk = new StringTokenizer(favor,",");
		int cnt=stk.countTokens();
		for (int i = 0; i < cnt; i++) {
			if(stk.nextToken().equals(name))
				return "redirect:food_searchlist?key=name&value=";
		}
		favor+=name+",";
		ser.updatefavor(id, favor);
		return "redirect:food_searchlist?key=name&value=";
	}
	
	@RequestMapping(value = "addeating", method = RequestMethod.GET)
	public String addeating(HttpServletRequest req) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("id");
		String name = req.getParameter("pname");
		String eating = ser.searchMem(id).getEating();
		StringTokenizer stk = new StringTokenizer(eating,",");
		int cnt=stk.countTokens();
		for (int i = 0; i < cnt; i++) {
			if(stk.nextToken().equals(name))
				return "redirect:food_searchlist?key=name&value=";
		}
		eating+=name+",";
		ser.updateeating(id, eating);
		return "redirect:food_searchlist?key=name&value=";
	}

	@RequestMapping(value = "deleteMem", method = RequestMethod.GET)
	public String deleteMem(HttpServletRequest req) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("id");
		ser.delMem(id);
		resetser.deleteReset(id);
		req.getSession().setAttribute("id", null);
		req.getSession().invalidate();
		return "redirect:mainpage";

	}
}
