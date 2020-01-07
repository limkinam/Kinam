package edu.ssafy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Food;
import edu.ssafy.service.FoodService;

@Controller
public class FoodController {

	@Autowired
	@Qualifier("FoodServiceImpl")
	FoodService ser;

	@RequestMapping(value = "food_searchbutton", method = RequestMethod.GET)
	public ModelAndView searchbutton(HttpServletRequest req, ModelAndView mv) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		if (key.equals("calory")) {
			List<Food> list = ser.CalorySearch(value);
			List<String[]> powersetlist = ser.powersetSearch(value);
			List<Food> total_list = new ArrayList<>();
			for (int i = 0; i < powersetlist.size(); i++) {
				String line = "";
				int calo = 0;
				for (int j = 0; j < powersetlist.get(i).length; j++) {
					for (int k = 0; k < list.size(); k++) {
						if (list.get(k).getName().equals(powersetlist.get(i)[j])) {
							line += list.get(k).getName() + ",";
							calo += list.get(k).getCalory();
						}
					}
				}
				Food ff = new Food();
				ff.setMaterial(line);
				ff.setCalory(calo);
				total_list.add(ff);
			}
			Collections.sort(total_list, new Comparator<Food>() {
				@Override
				public int compare(Food o1, Food o2) {
					return (int) (o2.getCalory() - o1.getCalory());
				}
			});
			for (int i = 0; i < total_list.size(); i++) {
				System.out.println(total_list.get(i).getMaterial() + "_" + total_list.get(i).getCalory());
			}
			mv.addObject("total_list", total_list);
			mv.setViewName("main");
			return mv;
		} else {
			List<Food> list = ser.ConditionSearch(value, key);
			mv.addObject("foodlist", list);
			mv.setViewName("main");
			return mv;
		}
	}

	@RequestMapping(value = "food_searchlist", method = RequestMethod.GET)
	public ModelAndView searchlist(HttpServletRequest req, ModelAndView mv) {
		String key = req.getParameter("key");
		String value = req.getParameter("value");

//		System.out.println(key + ", " + value);

		List<Food> list = ser.ConditionSearch(value, key);
		mv.addObject("foodlist", list);
		mv.setViewName("searchlist");
		return mv;
	}

	@RequestMapping(value = "food_myallergy", method = RequestMethod.GET)
	public ModelAndView myallergy(HttpServletRequest req, ModelAndView mv) {
		String id = (String) req.getSession().getAttribute("id");
		String allergy = ser.AllergySearch(id);
//		System.out.println(allergy);

		String[] str = allergy.split(", ");

		for (int i = 0; i < str.length; i++)
			System.out.println(str[i]);

		List<Food> allergyFoods = new ArrayList<>();
		List<Food> list = ser.SearchAll();
		for (int i = 0; i < list.size(); i++) {

			for (int j = 0; j < str.length; j++) {
				if (list.get(i).getMaterial().contains(str[j])) {
					allergyFoods.add(list.get(i));
					break;
				}
			}
		}
		mv.addObject("myallergy", allergyFoods);
		mv.setViewName("myallergy");
		return mv;
	}

	@RequestMapping(value = "food_detail", method = RequestMethod.GET)
	public ModelAndView detail(HttpServletRequest req, ModelAndView mv) {
		Food find = ser.search(req.getParameter("pname"));
		mv.addObject("list", find);
		mv.setViewName("detail");
		return mv;
	}
}
