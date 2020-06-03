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
	 * @return list of Food objects in an unsorted order
	 */
	public abstract List<Food> initilizeFood();
	
	/**
	 * This is the original code, fixed to compile and sort as expected.  It works, but 
	 * is hard to follow.
	 * @param foods
	 * @return list of Food objects sorted by size then whoAMI
	 */
	public abstract Food[] sortFoodsOriginal(List<Food> foods);
	
	/**
	 * This is a cleaner implementation of the same sort routine using 
	 * Lambda
	 * @param foods
	 * @return list of FOOD objects sorted by size then whoAMI
	 */
	public abstract List<Food> sortFoodsLambda(List<Food> foods);
	
	/**
	 * Checks to see if foods already exists, if not persist them
	 * to the database in the original order
	 * @return
	 */
	public abstract Response createAllFoods();
	
	/**
	 * Retrieves all the food records from the database
	 * and then sorts them using the Lambda method
	 * @return list of Food object sorted by size then whoAMI
	 */
	public abstract Response listAllFoodsSorted();
	
	/**
	 * Retrieves all the food records from the database,
	 * but does not sort them
	 * @return list of Food object unsorted
	 */
	public abstract Response listAllFoodsUnsorted();
	
	/**
	 * Deletes all the food records from the database
	 * @return
	 */
	public abstract Response deleteAllFoods();
}
