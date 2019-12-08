package com.bjsxt.dao;


import java.util.List;

import com.bjsxt.base.BaseDao;
import com.bjsxt.dto.TreeDTO;
import com.bjsxt.model.Resource;

public interface ResourceDao extends BaseDao<Resource>{

	List<TreeDTO> getChildrenByParentId(String id) throws Exception;

	public List<Resource> getChildren(int pid) throws Exception;
}
