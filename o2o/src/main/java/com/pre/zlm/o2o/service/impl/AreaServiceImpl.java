package com.pre.zlm.o2o.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pre.zlm.o2o.dao.AreaDao;
import com.pre.zlm.o2o.entity.Area;
import com.pre.zlm.o2o.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaDao dao;
	public List<Area> getAreaList(){
		return dao.listArea();
	}
}