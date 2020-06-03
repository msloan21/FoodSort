package com.mgmtp.foodsort.repository;

import org.springframework.data.repository.CrudRepository;

import com.mgmtp.foodsort.model.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {

}
