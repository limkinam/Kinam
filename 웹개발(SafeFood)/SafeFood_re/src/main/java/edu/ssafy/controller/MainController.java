package edu.ssafy.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Food;
import edu.ssafy.service.FoodService;

@Controller
public class MainController {

	@Autowired
	@Qualifier("FoodServiceImpl")
	FoodService ser;
	

	@RequestMapping(value = { "/", "/mainpage" }, method = RequestMethod.GET)
	public ModelAndView mainpage(HttpServletRequest req, ModelAndView mv) {
		if (ser.SearchAll().size() == 0) {
			System.out.println(req.getServletContext().getRealPath("WEB-INF/res/foodInfo.xml"));
			System.out.println(req.getServletContext().getRealPath("WEB-INF/res/FoodNutritionInfo.xml"));
			ser.InsertProduct(req.getServletContext().getRealPath("WEB-INF/res/foodInfo.xml"),
					req.getServletContext().getRealPath("WEB-INF/res/FoodNutritionInfo.xml"));
			ser.InsertNutrition(req.getServletContext().getRealPath("WEB-INF/res/foodInfo.xml"),
					req.getServletContext().getRealPath("WEB-INF/res/FoodNutritionInfo.xml"));
		}

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat datefor = new SimpleDateFormat("yyyy:MM:dd-hh:mm:ss");

		HttpSession session = req.getSession();
		session.setAttribute("mainpage", "mainpage");

		List<Food> list = ser.SearchAll();
		mv.addObject("foodlist", list);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/board")
	public String board() {
		return "board";
	}
	
}
