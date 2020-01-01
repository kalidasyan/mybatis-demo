package com.amituofo.mybatis.demo.entity;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Area {
  private Integer areaId;

  private String areaName;

  private Integer priority;

  private Date createTime;

  private Date lastEditTime;
}
