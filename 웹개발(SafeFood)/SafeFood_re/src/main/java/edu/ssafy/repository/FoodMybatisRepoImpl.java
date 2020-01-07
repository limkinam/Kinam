package edu.ssafy.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.handler.FoodSaxParser;

@Repository("FoodMybatisRepoImpl")
public class FoodMybatisRepoImpl implements FoodRepo {
	private String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
			"계란흰자" };

	@Autowired
	private SqlSession session;

	@Override
	public void InsertProduct(String str1, String str2) {
		List<Food> list = new FoodSaxParser(str1, str2).getFoods();
		session.insert("sql.food.InsertProduct", list);
	}

	@Override
	public void InsertNutrition(String str1, String str2) {
		List<Food> list = new FoodSaxParser(str1, str2).getFoods();
		session.insert("sql.food.InsertNutrition", list);
	}

	@Override
	public List<Food> SearchAll() {
		return session.selectList("sql.food.SearchAll");
	}

	@Override
	public List<Food> ConditionSearch(String value, String key) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("value", value);
		parameters.put("key", key);
		return session.selectList("sql.food.ConditionSearch", parameters);
	}

	@Override
	public String AllergySearch(String id) {
		return session.selectOne("sql.food.AllergySearch", id);
	}

	@Override
	public List<Food> CalorySearch(String cal) {
		return session.selectList("sql.food.CalorySearch", cal);
	}

//	@Override
//	public List<String[]> powersetSearch(String cal) {
//		return null;
//	}

	@Override
	public Food search(String name) {
//		Food f = session.selectOne("sql.food.search", "%" + name + "%");
		Food food = search_name(name).get(0);
		String s = "";
		for (int i = 0; i < allergys.length; i++) {
			if (food.getMaterial().contains(allergys[i])) {
				s = s + allergys[i] + " ";
			}
		}
		food.setAllergy(s);
		return food;
	}

	@Override
	public List<Food> search_name(String name) {
		return session.selectList("sql.food.search_name", "%" + name + "%");
	}
}
