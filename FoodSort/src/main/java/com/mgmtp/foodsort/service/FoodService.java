package com.mgmtp.foodsort.service;

import java.util.List;

import com.mgmtp.foodsort.model.Food;
import com.mgmtp.foodsort.model.Response;

/**
 * Service for handling all operations related to FOOD objects
 * 
 * @author Matt
 *
 */
public interface FoodService {
	/**
	 * Creates a list of different type of FOOD objects, defines their type 
	 * and sets the size attribute of the object.
	 * @return list of FOOD objects in an unsorted order
	 */
	public abstract List<Food> initilizeFood();
	
	/**
	 * This is the original code, fixed to compile and sort as expected.  It works, but 
	 * is hard to follow.
	 * @param foods
	 * @return list of FOOD object sorted by size then whoAMI
	 */
	public abstract Food[] sortFoodsOriginal(List<Food> foods);
	
	/**
	 * This is a cleaner implementation of the same sort routine using 
	 * Lambda
	 * @param foods
	 * @return list of FOOD object sorted by size then whoAMI
	 */
	public abstract List<Food> sortFoodsLambda(List<Food> foods);
	
	public abstract Response createAllFoods();
	
	public abstract Response listAllFoodsSorted();
	
	public abstract Response listAllFoodsUnsorted();
	
	public abstract Response deleteAllFoods();
}
