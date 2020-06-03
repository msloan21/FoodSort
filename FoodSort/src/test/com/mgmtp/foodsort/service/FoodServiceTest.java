package com.mgmtp.foodsort.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mgmtp.foodsort.model.Food;
import com.mgmtp.foodsort.model.Potato;
import com.mgmtp.foodsort.model.Response;
import com.mgmtp.foodsort.model.Tomato;
import com.mgmtp.foodsort.repository.FoodRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FoodServiceTest {
	@InjectMocks
	private FoodServiceImpl service;
	
	@Mock
	private FoodRepository mockRepo;
	
	private List<Food> foods;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		foods = service.initilizeFood();
	}
	
	@After
	public void teardown() {
		service = null;
		foods = null;
	}
	
	@Test
	public void testSortFoodOriginal() {
		
		Food[] result = service.sortFoodsOriginal(foods);
		
		assertTrue(result.length == 10);
		
		assertTrue(result[0].getWhoAMI().equals("Potato"));
		assertTrue(result[0].getSize() == 1);
		assertTrue(result[1].getWhoAMI().equals("Potato"));
		assertTrue(result[1].getSize() == 9);
		assertTrue(result[2].getWhoAMI().equals("Potato"));
		assertTrue(result[2].getSize() == 11);
		assertTrue(result[3].getWhoAMI().equals("Tomato"));
		assertTrue(result[3].getSize() == 11);
		assertTrue(result[4].getWhoAMI().equals("Potato"));
		assertTrue(result[4].getSize() == 12);
		assertTrue(result[5].getWhoAMI().equals("Potato"));
		assertTrue(result[5].getSize() == 42);
		assertTrue(result[6].getWhoAMI().equals("Potato"));
		assertTrue(result[6].getSize() == 46);
		assertTrue(result[7].getWhoAMI().equals("Potato"));
		assertTrue(result[7].getSize() == 55);
		assertTrue(result[8].getWhoAMI().equals("Potato"));
		assertTrue(result[8].getSize() == 77);
		assertTrue(result[9].getWhoAMI().equals("Tomato"));
		assertTrue(result[9].getSize() == 121);
	}
	
	@Test
	public void testSortFoodLambda() {
		List<Food> result = service.sortFoodsLambda(foods);
		
		assertTrue(result.size() == 10);
		
		assertTrue(result.get(0).getWhoAMI().equals("Potato"));
		assertTrue(result.get(0).getSize() == 1);
		assertTrue(result.get(1).getWhoAMI().equals("Potato"));
		assertTrue(result.get(1).getSize() == 9);
		assertTrue(result.get(2).getWhoAMI().equals("Potato"));
		assertTrue(result.get(2).getSize() == 11);
		assertTrue(result.get(3).getWhoAMI().equals("Tomato"));
		assertTrue(result.get(3).getSize() == 11);
		assertTrue(result.get(4).getWhoAMI().equals("Potato"));
		assertTrue(result.get(4).getSize() == 12);
		assertTrue(result.get(5).getWhoAMI().equals("Potato"));
		assertTrue(result.get(5).getSize() == 42);
		assertTrue(result.get(6).getWhoAMI().equals("Potato"));
		assertTrue(result.get(6).getSize() == 46);
		assertTrue(result.get(7).getWhoAMI().equals("Potato"));
		assertTrue(result.get(7).getSize() == 55);
		assertTrue(result.get(8).getWhoAMI().equals("Potato"));
		assertTrue(result.get(8).getSize() == 77);
		assertTrue(result.get(9).getWhoAMI().equals("Tomato"));
		assertTrue(result.get(9).getSize() == 121);
	}
	
	@Test
	public void testCreateAllFoods() {
		Mockito.when(mockRepo.save(Mockito.any(Food.class))).thenReturn(new Potato());
		
		Response resp = service.createAllFoods();
		
		assertNotNull(resp);
		
		Mockito.verify(mockRepo, Mockito.times(10)).save(Mockito.any(Food.class));

	}
	
	@Test
	public void testCreateAllFoodsExisting() {
		Potato p1 = new Potato();
		p1.setSize(4);
		
		Tomato t1 = new Tomato();
		t1.setSize(2);
		
		Food[] foodArry = {p1, t1};	
		Iterable<Food> foods = Arrays.asList(foodArry);
		
		Mockito.when(mockRepo.findAll()).thenReturn(foods);
		Mockito.when(mockRepo.save(Mockito.any(Food.class))).thenReturn(new Potato());
		
		Response resp = service.createAllFoods();
		
		assertNotNull(resp);
		assertTrue(resp.getMessage().equals("Foods already exist."));
		Mockito.verify(mockRepo, Mockito.times(0)).save(Mockito.any(Food.class));

	}
	
	@Test
	public void testDeleteAllFoods() {
		Mockito.doNothing().when(mockRepo).deleteAll();
		
		Response resp = service.deleteAllFoods();
		
		assertNotNull(resp);
		
		Mockito.verify(mockRepo, Mockito.times(1)).deleteAll();
	}
	
	@Test
	public void testListAllFoodsSorted() {
		Potato p1 = new Potato();
		p1.setSize(4);
		
		Tomato t1 = new Tomato();
		t1.setSize(2);
		
		Food[] foodArry = {p1, t1};	
		Iterable<Food> foods = Arrays.asList(foodArry);
		
		Mockito.when(mockRepo.findAll()).thenReturn(foods);
		
		Response resp = service.listAllFoodsSorted();
		
		assertNotNull(resp);
		
		Mockito.verify(mockRepo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void testListAllFoodsUnsorted() {
		Potato p1 = new Potato();
		p1.setSize(4);
		
		Tomato t1 = new Tomato();
		t1.setSize(2);
		
		Food[] foodArry = {p1, t1};	
		Iterable<Food> foods = Arrays.asList(foodArry);
		
		Mockito.when(mockRepo.findAll()).thenReturn(foods);
		
		Response resp = service.listAllFoodsUnsorted();
		
		assertNotNull(resp);
		
		Mockito.verify(mockRepo, Mockito.times(1)).findAll();
	}
}
