package com.mgmtp.foodsort.model;

import java.util.List;

public class Response {
	private List data;
	private String message;
	
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
