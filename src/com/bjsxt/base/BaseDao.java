package com.bjsxt.base;

import java.util.List;

public interface BaseDao<Entity> {

	
	void save(Entity obj) throws Exception ; 
	
	void update (Entity obj) throws Exception; 
	
	void delete(int id) throws Exception; 
	
	List<Entity> findAll() throws Exception;
	
	
	Entity findById( int id) throws Exception;
	 int getWeekNum();
	
}
