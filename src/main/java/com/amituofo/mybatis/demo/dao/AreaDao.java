package com.amituofo.mybatis.demo.dao;

import com.amituofo.mybatis.demo.entity.Area;
import java.util.List;


public interface AreaDao {
  List<Area> queryArea();

  Area queryAreaById(int areaId);

  int insertArea(Area area);

  int updateArea(Area area);

  int deleteArea(int areaId);
}
