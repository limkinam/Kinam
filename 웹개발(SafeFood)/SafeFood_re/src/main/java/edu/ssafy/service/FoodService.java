package edu.ssafy.service;

import java.io.IOException;
import java.util.List;

import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;

public interface FoodService {
	public void InsertProduct(String str1, String str2);

	public void InsertNutrition(String str1, String str2);

	public List<Food> SearchAll();

	public List<Food> ConditionSearch(String value, String key);

	public String AllergySearch(String id);

	List<Food> CalorySearch(String cal);

	List<String[]> powersetSearch(String cal);

	public Food search(String name);

	public List<Food> search_name(String name);

}
