package edu.ssafy.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.Food;
import edu.ssafy.dto.Member;
import edu.ssafy.repository.FoodRepo;

@Service("FoodServiceImpl")
public class FoodServiceImpl implements FoodService {

	@Autowired
	@Qualifier("FoodMybatisRepoImpl")
	private FoodRepo repo;

	public FoodServiceImpl() {
	}

	@Override
	public void InsertProduct(String str1, String str2) {
		repo.InsertProduct(str1, str2);
	}

	@Override
	public void InsertNutrition(String str1, String str2) {
		repo.InsertNutrition(str1, str2);
	}

	@Override
	public List<Food> SearchAll() {
		return repo.SearchAll();
	}

	@Override
	public List<Food> ConditionSearch(String value, String key) {
		return repo.ConditionSearch(value, key);
	}

	@Override
	public String AllergySearch(String id) {
		return repo.AllergySearch(id);
	}

	@Override
	public List<Food> CalorySearch(String cal) {
		return repo.CalorySearch(cal);
	}

	// 조합 시작
	static List<String[]> powersetlist;
	static double maxcal;

	@Override
	public List<String[]> powersetSearch(String cal) {
		maxcal = Double.parseDouble(cal);

		powersetlist = new ArrayList<>();
		List<String> namelist = new ArrayList<>();
		List<Double> calorylist = new ArrayList<>();

		List<Food> repolist = repo.CalorySearch(cal);
		for (int i = 0; i < repolist.size(); i++) {
			namelist.add(repolist.get(i).getName());
			calorylist.add(repolist.get(i).getCalory());
		}

		String[] nameArr = new String[namelist.size()];
		double[] caloryArr = new double[calorylist.size()];
		for (int i = 0; i < namelist.size(); i++) {
			nameArr[i] = namelist.get(i);
			caloryArr[i] = calorylist.get(i);
		}

		boolean[] sel = new boolean[namelist.size()];
		powerset(caloryArr, nameArr, 0, sel);

		return powersetlist;
	}

	static void powerset(double[] cal, String[] arr, int idx, boolean[] sel) {

		if (idx == arr.length) {
			String[] strs = new String[arr.length];
			double tmp = 0;
			for (int i = 0; i < arr.length; i++) {
				if (sel[i]) {
					tmp += cal[i];
					strs[i] = arr[i];
				}
			}
			if (tmp <= maxcal)
				powersetlist.add(strs);

			return;
		}
		sel[idx] = false;
		powerset(cal, arr, idx + 1, sel);
		sel[idx] = true;
		powerset(cal, arr, idx + 1, sel);
	}
	// 조합 끝

	@Override
	public Food search(String parameter) {
		return repo.search(parameter);
	}

	@Override
	public List<Food> search_name(String name) {
		return repo.search_name(name);
	}
}
