package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kehuxinxi;

public interface KehuxinxiServer {

  public int add(Kehuxinxi po);

  public int update(Kehuxinxi po);
  
  
  
  public int delete(int id);

  public List<Kehuxinxi> getAll(Map<String,Object> map);
  public List<Kehuxinxi> getsykehuxinxi1(Map<String,Object> map);
  public List<Kehuxinxi> getsykehuxinxi2(Map<String,Object> map);
  public List<Kehuxinxi> getsykehuxinxi3(Map<String,Object> map);
  public Kehuxinxi quchongKehuxinxi(Map<String, Object> acount);

  public Kehuxinxi getById( int id);

  public List<Kehuxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kehuxinxi> select(Map<String, Object> map);
}
//	所有List
