package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gongyingshangxinxi;

public interface GongyingshangxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gongyingshangxinxi record);

    int insertSelective(Gongyingshangxinxi record);

    Gongyingshangxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gongyingshangxinxi record);
	
    int updateByPrimaryKey(Gongyingshangxinxi record);
	public Gongyingshangxinxi quchongGongyingshangxinxi(Map<String, Object> gongyingshang);
	public List<Gongyingshangxinxi> getAll(Map<String, Object> map);
	public List<Gongyingshangxinxi> getsygongyingshangxinxi1(Map<String, Object> map);
	public List<Gongyingshangxinxi> getsygongyingshangxinxi3(Map<String, Object> map);
	public List<Gongyingshangxinxi> getsygongyingshangxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gongyingshangxinxi> getByPage(Map<String, Object> map);
	public List<Gongyingshangxinxi> select(Map<String, Object> map);
//	所有List
}

