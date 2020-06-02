package com.mgmtp.foodsort.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mgmtp.foodsort.model.FOOD;

@RunWith(SpringJUnit4ClassRunner.class)
public class FoodServiceTest {
	private FoodServiceImpl service;
	private List<FOOD> foods;
	
	
	@Before
	public void setup() {
		service = new FoodServiceImpl();
		
		
	}
	
	@After
	public void teardown() {
		service = null;
	}
	
	@Test
	public void testSortFoodOriginal() {
		FOOD[] foods = service.sortFoodsOriginal(service.initilizeFood());
		
		assertTrue(foods.length == 10);
		
		assertTrue(foods[0].whoAMI.equals("Potato"));
		assertTrue(foods[0].size == 1);
		assertTrue(foods[1].whoAMI.equals("Potato"));
		assertTrue(foods[1].size == 9);
		assertTrue(foods[2].whoAMI.equals("Potato"));
		assertTrue(foods[2].size == 11);
		assertTrue(foods[3].whoAMI.equals("Tomato"));
		assertTrue(foods[3].size == 11);
		assertTrue(foods[4].whoAMI.equals("Potato"));
		assertTrue(foods[4].size == 12);
		assertTrue(foods[5].whoAMI.equals("Potato"));
		assertTrue(foods[5].size == 42);
		assertTrue(foods[6].whoAMI.equals("Potato"));
		assertTrue(foods[6].size == 46);
		assertTrue(foods[7].whoAMI.equals("Potato"));
		assertTrue(foods[7].size == 55);
		assertTrue(foods[8].whoAMI.equals("Potato"));
		assertTrue(foods[8].size == 77);
		assertTrue(foods[9].whoAMI.equals("Tomato"));
		assertTrue(foods[9].size == 121);
	}
	
	@Test
	public void testSortFoodLambda() {
		List<FOOD> foods = service.sortFoodsLambda(Lists.newArrayList(service.initilizeFood()));
		
		assertTrue(foods.size() == 10);
		
		assertTrue(foods.get(0).whoAMI.equals("Potato"));
		assertTrue(foods.get(0).size == 1);
		assertTrue(foods.get(1).whoAMI.equals("Potato"));
		assertTrue(foods.get(1).size == 9);
		assertTrue(foods.get(2).whoAMI.equals("Potato"));
		assertTrue(foods.get(2).size == 11);
		assertTrue(foods.get(3).whoAMI.equals("Tomato"));
		assertTrue(foods.get(3).size == 11);
		assertTrue(foods.get(4).whoAMI.equals("Potato"));
		assertTrue(foods.get(4).size == 12);
		assertTrue(foods.get(5).whoAMI.equals("Potato"));
		assertTrue(foods.get(5).size == 42);
		assertTrue(foods.get(6).whoAMI.equals("Potato"));
		assertTrue(foods.get(6).size == 46);
		assertTrue(foods.get(7).whoAMI.equals("Potato"));
		assertTrue(foods.get(7).size == 55);
		assertTrue(foods.get(8).whoAMI.equals("Potato"));
		assertTrue(foods.get(8).size == 77);
		assertTrue(foods.get(9).whoAMI.equals("Tomato"));
		assertTrue(foods.get(9).size == 121);
	}
}
