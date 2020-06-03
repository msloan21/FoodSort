package com.mgmtp.foodsort.model;

import javax.persistence.Entity;

@Entity
public class Potato extends Food {
	
	public Potato() {
		super.setWhoAMI("Potato");
	}
}
