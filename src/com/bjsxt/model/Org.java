package com.bjsxt.model;
/**
 * treegrid
 * @author Administrator
 *
 */
public class Org {
	private int id ;
	private String name ; 
	private String iconCls ; 
	private String principal ; 		//负责人
	private int count ;				//总人数 
	private String description;		//描述
	private String state = "open";	//状态
	private int parent_id;			//父id

	
	public Org(int id, String name, String iconCls, String principal,
			int count, String description, String state, int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.iconCls = iconCls;
		this.principal = principal;
		this.count = count;
		this.description = description;
		this.state = state;
		parent_id = parentId;
	}
	public Org() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parentId) {
		parent_id = parentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
