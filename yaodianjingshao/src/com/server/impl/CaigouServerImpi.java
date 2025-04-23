package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CaigouMapper;
import com.entity.Caigou;
import com.server.CaigouServer;
@Service
public class CaigouServerImpi implements CaigouServer {
   @Resource
   private CaigouMapper gdao;
	@Override
	public int add(Caigou po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Caigou po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Caigou po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Caigou> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Caigou> getsycaigou1(Map<String, Object> map) {
		return gdao.getsycaigou1(map);
	}
	public List<Caigou> getsycaigou2(Map<String, Object> map) {
		return gdao.getsycaigou2(map);
	}
	public List<Caigou> getsycaigou3(Map<String, Object> map) {
		return gdao.getsycaigou3(map);
	}
	
	@Override
	public Caigou quchongCaigou(Map<String, Object> account) {
		return gdao.quchongCaigou(account);
	}

	@Override
	public List<Caigou> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Caigou> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Caigou getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

