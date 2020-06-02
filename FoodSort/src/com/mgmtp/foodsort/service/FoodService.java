package com.mgmtp.foodsort.service;

import com.mgmtp.foodsort.model.FOOD;

/**
 * 
 * @author Matt
 *
 */
public interface FoodService {
	/**
	 * 
	 * @return
	 */
	public abstract FOOD[] initilizeFood();
	/**
	 * 
	 * @param foods
	 * @return
	 */
	public abstract FOOD[] sortFoods(FOOD[] foods);
}
