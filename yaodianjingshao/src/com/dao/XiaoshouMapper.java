package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xiaoshou;

public interface XiaoshouMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiaoshou record);

    int insertSelective(Xiaoshou record);

    Xiaoshou selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xiaoshou record);
	int updateByPrimaryKeySelectivelb(Xiaoshou record);
    int updateByPrimaryKey(Xiaoshou record);
	public Xiaoshou quchongXiaoshou(Map<String, Object> xiaoshouyuan);
	public List<Xiaoshou> getAll(Map<String, Object> map);
	public List<Xiaoshou> getsyxiaoshou1(Map<String, Object> map);
	public List<Xiaoshou> getsyxiaoshou3(Map<String, Object> map);
	public List<Xiaoshou> getsyxiaoshou2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xiaoshou> getByPage(Map<String, Object> map);
	public List<Xiaoshou> select(Map<String, Object> map);
//	所有List
}

