package com.mgmtp.foodsort.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Food {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = false)
	private int size = -1;
	
	@Column(nullable = false, unique = false)
	private String whoAMI = "FOOD";
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getWhoAMI() {
		return whoAMI;
	}
	public void setWhoAMI(String whoAMI) {
		this.whoAMI = whoAMI;
	}
}
