package com.mgmtp.foodsort;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mgmtp.foodsort.model.FOOD;
import com.mgmtp.foodsort.service.FoodService;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {
	
	@Autowired
	private FoodService foodService;
	
    public static void main(String[] args) {
    	SpringApplication.run(ConsoleApplication.class, args);
    }

	public void run(String... args) throws Exception {
		FOOD[] unsortedFoods = foodService.initilizeFood();
		FOOD[] SORTEDFOOD = foodService.sortFoods(unsortedFoods);
		
//		//print result
		for (final FOOD food : Arrays.asList(SORTEDFOOD)) {
			System.out.println(food.whoAMI() + " " + food.size);
		}
	}
}
