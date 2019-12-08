package com.bjsxt.model;

public class Province {
	
	private int id ;
	private String name ;
	
	
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Province(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
