package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KehuxinxiMapper;
import com.entity.Kehuxinxi;
import com.server.KehuxinxiServer;
@Service
public class KehuxinxiServerImpi implements KehuxinxiServer {
   @Resource
   private KehuxinxiMapper gdao;
	@Override
	public int add(Kehuxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kehuxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kehuxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kehuxinxi> getsykehuxinxi1(Map<String, Object> map) {
		return gdao.getsykehuxinxi1(map);
	}
	public List<Kehuxinxi> getsykehuxinxi2(Map<String, Object> map) {
		return gdao.getsykehuxinxi2(map);
	}
	public List<Kehuxinxi> getsykehuxinxi3(Map<String, Object> map) {
		return gdao.getsykehuxinxi3(map);
	}
	
	@Override
	public Kehuxinxi quchongKehuxinxi(Map<String, Object> account) {
		return gdao.quchongKehuxinxi(account);
	}

	@Override
	public List<Kehuxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kehuxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kehuxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

