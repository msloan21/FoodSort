package com.mgmtp.foodsort.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mgmtp.foodsort.model.FOOD;

@RunWith(SpringJUnit4ClassRunner.class)
public class FoodServiceTest {
	private FoodServiceImpl service;
	
	@Before
	public void setup() {
		service = new FoodServiceImpl();
	}
	
	@After
	public void teardown() {
		service = null;
	}
	
	@Test
	public void testInitFood() {
		FOOD[] foods = service.initilizeFood();
		
		assertTrue(foods.length == 10);
	}
}
