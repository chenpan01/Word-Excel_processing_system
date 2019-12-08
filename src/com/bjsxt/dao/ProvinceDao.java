package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.base.BaseDao;
import com.bjsxt.model.City;
import com.bjsxt.model.Province;

public interface ProvinceDao extends BaseDao<Province>{

	List<City> findCitiesByProId(int parseInt) throws Exception;


}
