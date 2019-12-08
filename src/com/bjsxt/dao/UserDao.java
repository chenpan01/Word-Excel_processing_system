package com.bjsxt.dao;

import java.util.*;

import com.bjsxt.base.BaseDao;
import com.bjsxt.model.Resource;
import com.bjsxt.model.Teacher_kcxx;
import com.bjsxt.model.Updatexx;
import com.bjsxt.model.User;
import com.bjsxt.stumodel.Kspk;
import com.bjsxt.stumodel.Xscj;


public interface UserDao extends BaseDao<User> {

	List<User> findByPagination(int currentPage, int pageSize , Map<String ,Object> m ) throws Exception;

	public int getTotal(Map<String ,Object> m) throws Exception ;

	List<User> searchByName(String q) throws Exception;
	public int getTotalkcxx();

	List<Teacher_kcxx> fingByPagination_kcxx(int i, int j, int xl);

	List<Xscj> getXscj(int currentPage, int pageSize);

	List<Kspk> getKspk(int currentPage, int pageSize);

	List<Updatexx> getUpdatexx(int currentPage, int pageSize);
}
