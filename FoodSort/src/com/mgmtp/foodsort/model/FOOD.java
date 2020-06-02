package com.mgmtp.foodsort.model;

public abstract class FOOD {
	public int size = -1;
	public String whoAMI = "FOOD";

	public String whoAMI() {
		return this.getClass().getSimpleName();
	}
}
