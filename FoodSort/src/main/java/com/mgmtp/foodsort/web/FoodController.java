package com.mgmtp.foodsort.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgmtp.foodsort.model.Response;
import com.mgmtp.foodsort.service.FoodService;

@RestController
@RequestMapping(path = "/api/foods")
public class FoodController {
	
	@Autowired
	private FoodService service;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/sorted", produces = "application/json")
    public Response findAllSorted() {
        Response resp = service.listAllFoodsSorted();
        resp.setMessage("SORTED SUCCESS");
        return resp;
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/unsorted", produces = "application/json")
    public Response findAllUnsorted() {
        Response resp = service.listAllFoodsUnsorted();
        resp.setMessage("UNSORTED SUCCESS");
        return resp;
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/create",  produces = "application/json")
    public Response createAll() {
        Response resp = service.createAllFoods();
        if(resp.getMessage() == null) {
        	resp.setMessage("CREATE SUCCESS");
        }
        return resp;
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/delete",  produces = "application/json")
	public Response deleteAll() {
		Response resp = service.deleteAllFoods();
		resp.setMessage("DELETE SUCCESS");
		return resp;
	}
	
	
}
