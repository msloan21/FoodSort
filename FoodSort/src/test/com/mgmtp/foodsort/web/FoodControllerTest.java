package com.mgmtp.foodsort.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mgmtp.foodsort.model.Response;
import com.mgmtp.foodsort.service.FoodServiceImpl;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FoodControllerTest {
	@InjectMocks
	private FoodController controller;
	
	@Mock
	private FoodServiceImpl mockService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	 @Test
		public void testSorted() {
	    	MockitoAnnotations.initMocks(this);
	    	
	    	MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	        
	        Mockito.when(mockService.listAllFoodsSorted()).thenReturn(new Response());
	        
	        Response resp = controller.findAllSorted();
	        
	        assertNotNull(resp);
	        assertEquals("SORTED SUCCESS", resp.getMessage());
	        
	        Mockito.verify(mockService, Mockito.times(1)).listAllFoodsSorted();
		}
    
    @Test
	public void testUnsorted() {
    	MockitoAnnotations.initMocks(this);
    	
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Mockito.when(mockService.listAllFoodsUnsorted()).thenReturn(new Response());
        
        Response resp = controller.findAllUnsorted();
        
        assertNotNull(resp);
        assertEquals("UNSORTED SUCCESS", resp.getMessage());
        
        Mockito.verify(mockService, Mockito.times(1)).listAllFoodsUnsorted();
	}
    
    @Test
   	public void testCreate() {
       	MockitoAnnotations.initMocks(this);
       	
       	MockHttpServletRequest request = new MockHttpServletRequest();
           RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
           
           Mockito.when(mockService.createAllFoods()).thenReturn(new Response());
           
           Response resp = controller.createAll();
           
           assertNotNull(resp);
           assertEquals("CREATE SUCCESS", resp.getMessage());
           
           Mockito.verify(mockService, Mockito.times(1)).createAllFoods();
   	}
    
    @Test
   	public void testCreateExisting() {
       	MockitoAnnotations.initMocks(this);
       	
       	MockHttpServletRequest request = new MockHttpServletRequest();
           RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
           Response mockResp = new Response();
           mockResp.setMessage("Foods already exist.");
           Mockito.when(mockService.createAllFoods()).thenReturn(mockResp);
           
           Response resp = controller.createAll();
           
           assertNotNull(resp);
           assertEquals("Foods already exist.", resp.getMessage());
           
           Mockito.verify(mockService, Mockito.times(1)).createAllFoods();
   	}
    
    @Test
   	public void testDelete() {
       	MockitoAnnotations.initMocks(this);
       	
       	MockHttpServletRequest request = new MockHttpServletRequest();
           RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
           
           Mockito.when(mockService.deleteAllFoods()).thenReturn(new Response());
           
           Response resp = controller.deleteAll();
           
           assertNotNull(resp);
           assertEquals("DELETE SUCCESS", resp.getMessage());
           
           Mockito.verify(mockService, Mockito.times(1)).deleteAllFoods();
   	}
}
