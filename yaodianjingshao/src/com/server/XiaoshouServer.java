package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xiaoshou;

public interface XiaoshouServer {

  public int add(Xiaoshou po);

  public int update(Xiaoshou po);
  
  public int updatelb(Xiaoshou po);
  
  public int delete(int id);

  public List<Xiaoshou> getAll(Map<String,Object> map);
  public List<Xiaoshou> getsyxiaoshou1(Map<String,Object> map);
  public List<Xiaoshou> getsyxiaoshou2(Map<String,Object> map);
  public List<Xiaoshou> getsyxiaoshou3(Map<String,Object> map);
  public Xiaoshou quchongXiaoshou(Map<String, Object> acount);

  public Xiaoshou getById( int id);

  public List<Xiaoshou> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xiaoshou> select(Map<String, Object> map);
}
//	所有List
