package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XiaoshouMapper;
import com.entity.Xiaoshou;
import com.server.XiaoshouServer;
@Service
public class XiaoshouServerImpi implements XiaoshouServer {
   @Resource
   private XiaoshouMapper gdao;
	@Override
	public int add(Xiaoshou po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xiaoshou po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Xiaoshou po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xiaoshou> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xiaoshou> getsyxiaoshou1(Map<String, Object> map) {
		return gdao.getsyxiaoshou1(map);
	}
	public List<Xiaoshou> getsyxiaoshou2(Map<String, Object> map) {
		return gdao.getsyxiaoshou2(map);
	}
	public List<Xiaoshou> getsyxiaoshou3(Map<String, Object> map) {
		return gdao.getsyxiaoshou3(map);
	}
	
	@Override
	public Xiaoshou quchongXiaoshou(Map<String, Object> account) {
		return gdao.quchongXiaoshou(account);
	}

	@Override
	public List<Xiaoshou> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xiaoshou> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xiaoshou getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

