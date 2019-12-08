package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.base.BaseDao;
import com.bjsxt.model.Org;

public interface OrgDao extends BaseDao<Org>{

	List<Org> findList(String id) throws Exception;
	public List<Org> getChildren(int id) throws Exception;

}
