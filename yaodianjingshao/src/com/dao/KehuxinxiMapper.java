package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kehuxinxi;

public interface KehuxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kehuxinxi record);

    int insertSelective(Kehuxinxi record);

    Kehuxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kehuxinxi record);
	
    int updateByPrimaryKey(Kehuxinxi record);
	public Kehuxinxi quchongKehuxinxi(Map<String, Object> kehu);
	public List<Kehuxinxi> getAll(Map<String, Object> map);
	public List<Kehuxinxi> getsykehuxinxi1(Map<String, Object> map);
	public List<Kehuxinxi> getsykehuxinxi3(Map<String, Object> map);
	public List<Kehuxinxi> getsykehuxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kehuxinxi> getByPage(Map<String, Object> map);
	public List<Kehuxinxi> select(Map<String, Object> map);
//	所有List
}

