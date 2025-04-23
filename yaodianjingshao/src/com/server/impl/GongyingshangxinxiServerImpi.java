package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GongyingshangxinxiMapper;
import com.entity.Gongyingshangxinxi;
import com.server.GongyingshangxinxiServer;
@Service
public class GongyingshangxinxiServerImpi implements GongyingshangxinxiServer {
   @Resource
   private GongyingshangxinxiMapper gdao;
	@Override
	public int add(Gongyingshangxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gongyingshangxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gongyingshangxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gongyingshangxinxi> getsygongyingshangxinxi1(Map<String, Object> map) {
		return gdao.getsygongyingshangxinxi1(map);
	}
	public List<Gongyingshangxinxi> getsygongyingshangxinxi2(Map<String, Object> map) {
		return gdao.getsygongyingshangxinxi2(map);
	}
	public List<Gongyingshangxinxi> getsygongyingshangxinxi3(Map<String, Object> map) {
		return gdao.getsygongyingshangxinxi3(map);
	}
	
	@Override
	public Gongyingshangxinxi quchongGongyingshangxinxi(Map<String, Object> account) {
		return gdao.quchongGongyingshangxinxi(account);
	}

	@Override
	public List<Gongyingshangxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gongyingshangxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gongyingshangxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

