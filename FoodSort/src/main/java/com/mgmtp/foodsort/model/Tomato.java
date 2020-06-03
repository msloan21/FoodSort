package com.mgmtp.foodsort.model;

import javax.persistence.Entity;

@Entity
public class Tomato extends Food {
	// default size for tomato
	//public int size = 121;  //hides FOOD size
	
	public Tomato() {
		super.setWhoAMI("Tomato");
		super.setSize(121);
	}	
}
