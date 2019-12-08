package com.bjsxt.model;

public class Resource {
	
	private int id ; 
	private String name ; 
	private String url ; 
	private int checked ; 
	private String icon ; 
	private int parent_id ;
	
	
	
	
	public Resource() {
		super();
	}
	public Resource(int id, String name, String url, int checked, String icon,
			int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.checked = checked;
		this.icon = icon;
		parent_id = parentId;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parentId) {
		parent_id = parentId;
	}
	
	
}
