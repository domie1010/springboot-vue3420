package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Caigou;

public interface CaigouServer {

  public int add(Caigou po);

  public int update(Caigou po);
  
  public int updatelb(Caigou po);
  
  public int delete(int id);

  public List<Caigou> getAll(Map<String,Object> map);
  public List<Caigou> getsycaigou1(Map<String,Object> map);
  public List<Caigou> getsycaigou2(Map<String,Object> map);
  public List<Caigou> getsycaigou3(Map<String,Object> map);
  public Caigou quchongCaigou(Map<String, Object> acount);

  public Caigou getById( int id);

  public List<Caigou> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Caigou> select(Map<String, Object> map);
}
//	所有List
