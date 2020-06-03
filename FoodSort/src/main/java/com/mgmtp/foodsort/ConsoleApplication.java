package com.mgmtp.foodsort;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mgmtp.foodsort.model.Food;
import com.mgmtp.foodsort.service.FoodService;

/**
 * 
 * @author Matt
 *
 */
@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {
	
	@Autowired
	private FoodService foodService;
	
    public static void main(String[] args) {
    	SpringApplication.run(ConsoleApplication.class, args);
    }

	public void run(String... args) throws Exception {
		List<Food> unsortedFoods = foodService.initilizeFood();
		Food[] sortedFoods = foodService.sortFoodsOriginal(unsortedFoods);
		
		for (final Food food : Arrays.asList(sortedFoods)) {
			System.out.println(food.getWhoAMI() + " " + food.getSize());
		}
	}
}
