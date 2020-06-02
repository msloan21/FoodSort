package com.mgmtp.foodsort.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mgmtp.foodsort.model.FOOD;
import com.mgmtp.foodsort.model.Potato;
import com.mgmtp.foodsort.model.Tomato;

@Service
public class FoodServiceImpl implements FoodService {

	public FOOD[] initilizeFood() {
		FOOD[] potatoes = new FOOD[10];
		final Tomato p0 = new Tomato();
		p0.size = 11;
		potatoes[0] = p0;
		final Tomato p1 = new Tomato();
		potatoes[1] = p1;

		final Potato p2 = new Potato();
		p2.size = 1;
		potatoes[2] = p2;
		final Potato p3 = new Potato();
		p3.size = 42;
		potatoes[3] = p3;
		final Potato p4 = new Potato();
		p4.size = 77;
		potatoes[4] = p4;
		final Potato p5 = new Potato();
		p5.size = 55;
		potatoes[5] = p5;
		final FOOD p6 = new Potato();
		p6.size = 46;
		potatoes[6] = p6;
		final FOOD p7 = new Potato();
		p7.size = 12;
		potatoes[7] = p7;
		final Potato p8 = new Potato();
		p8.size = 11;
		potatoes[8] = p8;
		final Potato p9 = new Potato();
		p9.size = 9;
		potatoes[9] = p9;
		
		return potatoes;
	}

	public FOOD[] sortFoodsOriginal(FOOD[] foods) {
		final FOOD[] SORTEDFOOD = new FOOD[10];
		for (int i = 0; i < 10; i++) {
//			final int index_of_the_smaller_food=i;  //final is immutable
			int index_of_the_smaller_food = i; 
			for (int j = i; j < 10; j++) {
				if(foods[index_of_the_smaller_food].size > foods[j].size){
					index_of_the_smaller_food=j;
				}
				if(foods[index_of_the_smaller_food].size == foods[j].size && foods[index_of_the_smaller_food].whoAMI.contains("Tomato")){
					index_of_the_smaller_food=j;
				}
			}
			SORTEDFOOD[i]=foods[index_of_the_smaller_food];
			foods[index_of_the_smaller_food]=foods[i];
		}
		
		return SORTEDFOOD;
	}
	public List<FOOD> sortFoodsLambda(List<FOOD> foods) {
		foods.sort(Comparator
			    .comparing(FOOD::getSize)
			    .thenComparing(FOOD::getWhoAMI));
		return foods;
	}

}
