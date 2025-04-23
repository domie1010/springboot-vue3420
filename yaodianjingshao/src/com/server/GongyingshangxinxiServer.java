package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gongyingshangxinxi;

public interface GongyingshangxinxiServer {

  public int add(Gongyingshangxinxi po);

  public int update(Gongyingshangxinxi po);
  
  
  
  public int delete(int id);

  public List<Gongyingshangxinxi> getAll(Map<String,Object> map);
  public List<Gongyingshangxinxi> getsygongyingshangxinxi1(Map<String,Object> map);
  public List<Gongyingshangxinxi> getsygongyingshangxinxi2(Map<String,Object> map);
  public List<Gongyingshangxinxi> getsygongyingshangxinxi3(Map<String,Object> map);
  public Gongyingshangxinxi quchongGongyingshangxinxi(Map<String, Object> acount);

  public Gongyingshangxinxi getById( int id);

  public List<Gongyingshangxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gongyingshangxinxi> select(Map<String, Object> map);
}
//	所有List
