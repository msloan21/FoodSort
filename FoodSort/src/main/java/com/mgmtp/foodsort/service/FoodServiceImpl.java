package com.mgmtp.foodsort.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgmtp.foodsort.model.Food;
import com.mgmtp.foodsort.model.Potato;
import com.mgmtp.foodsort.model.Response;
import com.mgmtp.foodsort.model.Tomato;
import com.mgmtp.foodsort.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Override
	public List<Food> initilizeFood() {
		List<Food> foods = new ArrayList<Food>();
		final Tomato t1 = new Tomato();
		t1.setSize(11);
		foods.add(t1);
		final Tomato t2 = new Tomato();
		foods.add(t2);
		

		final Potato p1 = new Potato();
		p1.setSize(1);
		foods.add(p1);
		final Potato p2 = new Potato();
		p2.setSize(42);
		foods.add(p2);
		final Potato p3 = new Potato();
		p3.setSize(77);
		foods.add(p3);
		final Potato p4 = new Potato();
		p4.setSize(55);
		foods.add(p4);
		final Food p5 = new Potato();
		p5.setSize(46);
		foods.add(p5);
		final Food p6 = new Potato();
		p6.setSize(12);
		foods.add(p6);
		final Potato p7 = new Potato();
		p7.setSize(11);
		foods.add(p7);
		final Potato p8 = new Potato();
		p8.setSize(9);
		foods.add(p8);
		
		return foods;
	}
	
	@Override
	public Food[] sortFoodsOriginal(List<Food> foods) {
		final Food[] SORTEDFOOD = new Food[10];
		Food[] foodsArr = foods.toArray(new Food[foods.size()]);
		for (int i = 0; i < 10; i++) {
//			final int index_of_the_smaller_food=i;  //final is immutable
			int index_of_the_smaller_food = i; 
			for (int j = i; j < 10; j++) {
				if(foodsArr[index_of_the_smaller_food].getSize() > foodsArr[j].getSize()) {
					index_of_the_smaller_food=j;
				}
				if(foodsArr[index_of_the_smaller_food].getSize() == foodsArr[j].getSize() 
						&& foodsArr[index_of_the_smaller_food].getWhoAMI().contains("Tomato")) {
					index_of_the_smaller_food=j;
				}
			}
			SORTEDFOOD[i] = foodsArr[index_of_the_smaller_food];
			foodsArr[index_of_the_smaller_food] = foodsArr[i];
		}
		
		return SORTEDFOOD;
	}
	
	@Override
	public List<Food> sortFoodsLambda(List<Food> foods) {
		foods.sort(Comparator
			    .comparing(Food::getSize)
			    .thenComparing(Food::getWhoAMI));
		return foods;
	}

	@Override
	public Response createAllFoods() {
		Response resp = new Response();
		Iterable<Food> existing = foodRepo.findAll();
		if(StreamSupport.stream(existing.spliterator(), false).count() > 0) {
			resp.setMessage("Foods already exist.");
			return resp;
		}
		
		List<Food> foods = initilizeFood();
		foods.forEach(food -> this.foodRepo.save(food));
		
		
		return resp;
	}

	@Override
	public Response deleteAllFoods() {
		foodRepo.deleteAll();
		
		return new Response();
	}

	@Override
	public Response listAllFoodsSorted() {
		Response resp = new Response();
		
		Iterable<Food> foods = foodRepo.findAll();
		
		List<Food> sortedData = this.sortFoodsLambda(StreamSupport.stream(foods.spliterator(), false)
				.collect(Collectors.toList()));
		
		resp.setData(sortedData);
		
		return resp;
	}

	@Override
	public Response listAllFoodsUnsorted() {
		Response resp = new Response();
		
		Iterable<Food> foods = foodRepo.findAll();
		
		resp.setData(StreamSupport.stream(foods.spliterator(), false)
				.collect(Collectors.toList()));
		
		return resp;
	}

}
