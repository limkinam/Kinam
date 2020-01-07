package edu.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.dto.Food;
import edu.ssafy.service.FoodService;
import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping("/rest/food")
public class RestFoodController {

	@Autowired
	@Qualifier("FoodServiceImpl")
	FoodService ser;
	
	@ApiOperation(value = "음식 리스트 출력")
	@RequestMapping(value = "/SearchAll", method = RequestMethod.GET)
	public List<Food> SearchAll(HttpServletRequest req) {
		if (ser.SearchAll().size() == 0) {
			System.out.println(req.getServletContext().getRealPath("WEB-INF/res/foodInfo.xml"));
			System.out.println(req.getServletContext().getRealPath("WEB-INF/res/FoodNutritionInfo.xml"));
			ser.InsertProduct(req.getServletContext().getRealPath("WEB-INF/res/foodInfo.xml"),
					req.getServletContext().getRealPath("WEB-INF/res/FoodNutritionInfo.xml"));
			ser.InsertNutrition(req.getServletContext().getRealPath("WEB-INF/res/foodInfo.xml"),
					req.getServletContext().getRealPath("WEB-INF/res/FoodNutritionInfo.xml"));
		}
		System.out.println("sada");
		return ser.SearchAll();
	}

	@ApiOperation(value = "음식 검색")
	@RequestMapping(value = "/ConditionSearch", method = RequestMethod.GET)
	public List<Food> ConditionSearch(String value, String key) {
		return ser.ConditionSearch(value, key);
	}

	@ApiOperation(value = "알러지 검색")
	@RequestMapping(value = "/AllergySearch", method = RequestMethod.GET)
	public String AllergySearch(String id) {
		return ser.AllergySearch(id);
	}

	@ApiOperation(value = "칼로리 이하 검색")
	@RequestMapping(value = "/CalorySearch", method = RequestMethod.GET)
	public List<Food> CalorySearch(String cal) {
		return ser.CalorySearch(cal);
	}

	@ApiOperation(value = "음식 이름 검색")
	@RequestMapping(value = "/search_name", method = RequestMethod.GET)
	public List<Food> search_name(String name) {
		return ser.search_name(name);
	}
}
