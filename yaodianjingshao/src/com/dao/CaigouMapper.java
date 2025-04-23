package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Caigou;

public interface CaigouMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Caigou record);

    int insertSelective(Caigou record);

    Caigou selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Caigou record);
	int updateByPrimaryKeySelectivelb(Caigou record);
    int updateByPrimaryKey(Caigou record);
	public Caigou quchongCaigou(Map<String, Object> caigouyuan);
	public List<Caigou> getAll(Map<String, Object> map);
	public List<Caigou> getsycaigou1(Map<String, Object> map);
	public List<Caigou> getsycaigou3(Map<String, Object> map);
	public List<Caigou> getsycaigou2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Caigou> getByPage(Map<String, Object> map);
	public List<Caigou> select(Map<String, Object> map);
//	所有List
}

