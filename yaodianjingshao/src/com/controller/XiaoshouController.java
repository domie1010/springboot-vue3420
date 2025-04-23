package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Xiaoshou;
import com.server.XiaoshouServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XiaoshouController {
	@Resource
	private XiaoshouServer xiaoshouService;


   
	@RequestMapping("addXiaoshou.do")
	public String addXiaoshou(HttpServletRequest request,Xiaoshou xiaoshou,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xiaoshou.setAddtime(time.toString().substring(0, 19));
		xiaoshouService.add(xiaoshou);
		String sql="";
		sql="update shangpinxinxi set kucun=kucun-"+xiaoshou.getXiaoshoushuliang()+" where shangpinbianhao='"+xiaoshou.getShangpinbianhao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql);

		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xiaoshouList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xiaoshouList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXiaoshou.do")
	public String doUpdateXiaoshou(int id,ModelMap map,Xiaoshou xiaoshou){
		xiaoshou=xiaoshouService.getById(id);
		map.put("xiaoshou", xiaoshou);
		return "xiaoshou_updt";
	}
	
	
	
	@RequestMapping("doUpdateXiaoshoulb.do")
	public String doUpdateXiaoshoulb(int id,ModelMap map,Xiaoshou xiaoshou){
		xiaoshou=xiaoshouService.getById(id);
		map.put("xiaoshou", xiaoshou);
		return "xiaoshou_updtlb";
	}
	
@RequestMapping("updateXiaoshoulb.do")
	public String updateXiaoshoulb(int id,ModelMap map,Xiaoshou xiaoshou){
		xiaoshouService.updatelb(xiaoshou);
		String sql2="";
		sql2="update shangpinxinxi set kucun=kucun+"+xiaoshou.getTuihuoshuliang()+" where shangpinbianhao='"+xiaoshou.getShangpinbianhao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql2);
		return "redirect:xiaoshouList.do";
	}
	
//	后台详细
	@RequestMapping("xiaoshouDetail.do")
	public String xiaoshouDetail(int id,ModelMap map,Xiaoshou xiaoshou){
		xiaoshou=xiaoshouService.getById(id);
		map.put("xiaoshou", xiaoshou);
		return "xiaoshou_detail";
	}
//	前台详细
	@RequestMapping("xsDetail.do")
	public String xsDetail(int id,ModelMap map,Xiaoshou xiaoshou){
		xiaoshou=xiaoshouService.getById(id);
		map.put("xiaoshou", xiaoshou);
		return "xiaoshoudetail";
	}
//	
	@RequestMapping("updateXiaoshou.do")
	public String updateXiaoshou(int id,ModelMap map,Xiaoshou xiaoshou,HttpServletRequest request,HttpSession session){
		xiaoshouService.update(xiaoshou);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xiaoshouList.do";
	}

//	分页查询
	@RequestMapping("xiaoshouList.do")
	public String xiaoshouList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshou xiaoshou, String shangpinbianhao, String shangpinmingcheng, String leibie, String kucun, String kehu, String xiaoshoushuliang1,String xiaoshoushuliang2, String xiaoshoushijian1,String xiaoshoushijian2, String xiaoshouyuan, String tuihuoshuliang, String tuihuoyuanyin){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(kehu==null||kehu.equals("")){pmap.put("kehu", null);}else{pmap.put("kehu", kehu);}
		if(xiaoshoushuliang1==null||xiaoshoushuliang1.equals("")){pmap.put("xiaoshoushuliang1", null);}else{pmap.put("xiaoshoushuliang1", xiaoshoushuliang1);}
		if(xiaoshoushuliang2==null||xiaoshoushuliang2.equals("")){pmap.put("xiaoshoushuliang2", null);}else{pmap.put("xiaoshoushuliang2", xiaoshoushuliang2);}
		if(xiaoshoushijian1==null||xiaoshoushijian1.equals("")){pmap.put("xiaoshoushijian1", null);}else{pmap.put("xiaoshoushijian1", xiaoshoushijian1);}
		if(xiaoshoushijian2==null||xiaoshoushijian2.equals("")){pmap.put("xiaoshoushijian2", null);}else{pmap.put("xiaoshoushijian2", xiaoshoushijian2);}
		if(xiaoshouyuan==null||xiaoshouyuan.equals("")){pmap.put("xiaoshouyuan", null);}else{pmap.put("xiaoshouyuan", xiaoshouyuan);}
		if(tuihuoshuliang==null||tuihuoshuliang.equals("")){pmap.put("tuihuoshuliang", null);}else{pmap.put("tuihuoshuliang", tuihuoshuliang);}
		if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
		
		int total=xiaoshouService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshou> list=xiaoshouService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshou_list";
	}
	
	@RequestMapping("xiaoshouList2.do")
	public String xiaoshouList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshou xiaoshou, String shangpinbianhao, String shangpinmingcheng, String leibie, String kucun, String kehu, String xiaoshoushuliang1,String xiaoshoushuliang2, String xiaoshoushijian1,String xiaoshoushijian2, String xiaoshouyuan, String tuihuoshuliang, String tuihuoyuanyin,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("xiaoshouyuan", (String)request.getSession().getAttribute("username"));
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(kehu==null||kehu.equals("")){pmap.put("kehu", null);}else{pmap.put("kehu", kehu);}
		if(xiaoshoushuliang1==null||xiaoshoushuliang1.equals("")){pmap.put("xiaoshoushuliang1", null);}else{pmap.put("xiaoshoushuliang1", xiaoshoushuliang1);}
		if(xiaoshoushuliang2==null||xiaoshoushuliang2.equals("")){pmap.put("xiaoshoushuliang2", null);}else{pmap.put("xiaoshoushuliang2", xiaoshoushuliang2);}
		if(xiaoshoushijian1==null||xiaoshoushijian1.equals("")){pmap.put("xiaoshoushijian1", null);}else{pmap.put("xiaoshoushijian1", xiaoshoushijian1);}
		if(xiaoshoushijian2==null||xiaoshoushijian2.equals("")){pmap.put("xiaoshoushijian2", null);}else{pmap.put("xiaoshoushijian2", xiaoshoushijian2);}
		if(tuihuoshuliang==null||tuihuoshuliang.equals("")){pmap.put("tuihuoshuliang", null);}else{pmap.put("tuihuoshuliang", tuihuoshuliang);}
		if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
		
		
		int total=xiaoshouService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshou> list=xiaoshouService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshou_list2";
	}
	
	
	@RequestMapping("xsList.do")
	public String xsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshou xiaoshou, String shangpinbianhao, String shangpinmingcheng, String leibie, String kucun, String kehu, String xiaoshoushuliang1,String xiaoshoushuliang2, String xiaoshoushijian1,String xiaoshoushijian2, String xiaoshouyuan, String tuihuoshuliang, String tuihuoyuanyin){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(kehu==null||kehu.equals("")){pmap.put("kehu", null);}else{pmap.put("kehu", kehu);}
		if(xiaoshoushuliang1==null||xiaoshoushuliang1.equals("")){pmap.put("xiaoshoushuliang1", null);}else{pmap.put("xiaoshoushuliang1", xiaoshoushuliang1);}
		if(xiaoshoushuliang2==null||xiaoshoushuliang2.equals("")){pmap.put("xiaoshoushuliang2", null);}else{pmap.put("xiaoshoushuliang2", xiaoshoushuliang2);}
		if(xiaoshoushijian1==null||xiaoshoushijian1.equals("")){pmap.put("xiaoshoushijian1", null);}else{pmap.put("xiaoshoushijian1", xiaoshoushijian1);}
		if(xiaoshoushijian2==null||xiaoshoushijian2.equals("")){pmap.put("xiaoshoushijian2", null);}else{pmap.put("xiaoshoushijian2", xiaoshoushijian2);}
		if(xiaoshouyuan==null||xiaoshouyuan.equals("")){pmap.put("xiaoshouyuan", null);}else{pmap.put("xiaoshouyuan", xiaoshouyuan);}
		if(tuihuoshuliang==null||tuihuoshuliang.equals("")){pmap.put("tuihuoshuliang", null);}else{pmap.put("tuihuoshuliang", tuihuoshuliang);}
		if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
		
		int total=xiaoshouService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshou> list=xiaoshouService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshoulist";
	}
	
	@RequestMapping("deleteXiaoshou.do")
	public String deleteXiaoshou(int id,HttpServletRequest request){
		xiaoshouService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xiaoshouList.do";
	}
	
	
}
