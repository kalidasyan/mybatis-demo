package com.amituofo.mybatis.demo.dao;

import com.amituofo.mybatis.demo.entity.Area;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class AreaDaoTest {

  @Autowired
  private AreaDao _areaDao;

  @Test
  void queryArea() {
    List<Area> areas = _areaDao.queryArea();
    assertEquals(2, areas.size());
  }

  @Test
  void queryAreaById() {
    Area area = _areaDao.queryAreaById(1);
    assertEquals("东苑", area.getAreaName());
  }

  @Test
  void insertArea() {
    Area area = new Area();
    area.setAreaName("南苑");
    area.setPriority(1);
    int affectedNum = _areaDao.insertArea(area);
    assertEquals(1, affectedNum);
  }

  @Test
  void updateArea() {
    Area area = new Area();
    area.setAreaId(3);
    area.setAreaName("西苑");
    area.setLastEditTime(new Date());
    int affectedNum = _areaDao.updateArea(area);
    assertEquals(1, affectedNum);
  }

  @Test
  void deleteArea() {
    int affectedNum = _areaDao.deleteArea(3);
    assertEquals(1, affectedNum);
  }
}