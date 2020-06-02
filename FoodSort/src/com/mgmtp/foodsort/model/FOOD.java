package com.mgmtp.foodsort.model;

public abstract class FOOD {
	public int size = -1;
	public String whoAMI = "FOOD";
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
