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

import com.entity.Caigou;
import com.server.CaigouServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CaigouController {
	@Resource
	private CaigouServer caigouService;


   
	@RequestMapping("addCaigou.do")
	public String addCaigou(HttpServletRequest request,Caigou caigou,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		caigou.setAddtime(time.toString().substring(0, 19));
		caigouService.add(caigou);
			String sql="";
		sql="update shangpinxinxi set kucun=kucun+"+caigou.getCaigoushuliang()+" where shangpinbianhao='"+caigou.getShangpinbianhao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "caigouList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:caigouList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCaigou.do")
	public String doUpdateCaigou(int id,ModelMap map,Caigou caigou){
		caigou=caigouService.getById(id);
		map.put("caigou", caigou);
		return "caigou_updt";
	}
	
	
	
	@RequestMapping("doUpdateCaigoulb.do")
	public String doUpdateCaigoulb(int id,ModelMap map,Caigou caigou){
		caigou=caigouService.getById(id);
		map.put("caigou", caigou);
		return "caigou_updtlb";
	}
	
@RequestMapping("updateCaigoulb.do")
	public String updateCaigoulb(int id,ModelMap map,Caigou caigou){
		caigouService.updatelb(caigou);
		
		String sql2="";
		sql2="update shangpinxinxi set kucun=kucun-"+caigou.getTuihuoshuliang()+" where shangpinbianhao='"+caigou.getShangpinbianhao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql2);
		return "redirect:caigouList.do";
	}
	
//	后台详细
	@RequestMapping("caigouDetail.do")
	public String caigouDetail(int id,ModelMap map,Caigou caigou){
		caigou=caigouService.getById(id);
		map.put("caigou", caigou);
		return "caigou_detail";
	}
//	前台详细
	@RequestMapping("cgDetail.do")
	public String cgDetail(int id,ModelMap map,Caigou caigou){
		caigou=caigouService.getById(id);
		map.put("caigou", caigou);
		return "caigoudetail";
	}
//	
	@RequestMapping("updateCaigou.do")
	public String updateCaigou(int id,ModelMap map,Caigou caigou,HttpServletRequest request,HttpSession session){
		caigouService.update(caigou);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:caigouList.do";
	}

//	分页查询
	@RequestMapping("caigouList.do")
	public String caigouList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caigou caigou, String shangpinbianhao, String shangpinmingcheng, String leibie, String kucun, String gongyingshang, String caigoushuliang1,String caigoushuliang2, String caigoushijian1,String caigoushijian2, String caigouyuan, String tuihuoshuliang, String tuihuoyuanyin){
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
		if(gongyingshang==null||gongyingshang.equals("")){pmap.put("gongyingshang", null);}else{pmap.put("gongyingshang", gongyingshang);}
		if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
		if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
		if(caigoushijian1==null||caigoushijian1.equals("")){pmap.put("caigoushijian1", null);}else{pmap.put("caigoushijian1", caigoushijian1);}
		if(caigoushijian2==null||caigoushijian2.equals("")){pmap.put("caigoushijian2", null);}else{pmap.put("caigoushijian2", caigoushijian2);}
		if(caigouyuan==null||caigouyuan.equals("")){pmap.put("caigouyuan", null);}else{pmap.put("caigouyuan", caigouyuan);}
		if(tuihuoshuliang==null||tuihuoshuliang.equals("")){pmap.put("tuihuoshuliang", null);}else{pmap.put("tuihuoshuliang", tuihuoshuliang);}
		if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
		
		int total=caigouService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caigou> list=caigouService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caigou_list";
	}
	
	@RequestMapping("caigouList2.do")
	public String caigouList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caigou caigou, String shangpinbianhao, String shangpinmingcheng, String leibie, String kucun, String gongyingshang, String caigoushuliang1,String caigoushuliang2, String caigoushijian1,String caigoushijian2, String caigouyuan, String tuihuoshuliang, String tuihuoyuanyin,HttpServletRequest request){
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
		
		pmap.put("caigouyuan", (String)request.getSession().getAttribute("username"));
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(gongyingshang==null||gongyingshang.equals("")){pmap.put("gongyingshang", null);}else{pmap.put("gongyingshang", gongyingshang);}
		if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
		if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
		if(caigoushijian1==null||caigoushijian1.equals("")){pmap.put("caigoushijian1", null);}else{pmap.put("caigoushijian1", caigoushijian1);}
		if(caigoushijian2==null||caigoushijian2.equals("")){pmap.put("caigoushijian2", null);}else{pmap.put("caigoushijian2", caigoushijian2);}
		if(tuihuoshuliang==null||tuihuoshuliang.equals("")){pmap.put("tuihuoshuliang", null);}else{pmap.put("tuihuoshuliang", tuihuoshuliang);}
		if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
		
		
		int total=caigouService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caigou> list=caigouService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caigou_list2";
	}
	
	
	@RequestMapping("cgList.do")
	public String cgList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caigou caigou, String shangpinbianhao, String shangpinmingcheng, String leibie, String kucun, String gongyingshang, String caigoushuliang1,String caigoushuliang2, String caigoushijian1,String caigoushijian2, String caigouyuan, String tuihuoshuliang, String tuihuoyuanyin){
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
		if(gongyingshang==null||gongyingshang.equals("")){pmap.put("gongyingshang", null);}else{pmap.put("gongyingshang", gongyingshang);}
		if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
		if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
		if(caigoushijian1==null||caigoushijian1.equals("")){pmap.put("caigoushijian1", null);}else{pmap.put("caigoushijian1", caigoushijian1);}
		if(caigoushijian2==null||caigoushijian2.equals("")){pmap.put("caigoushijian2", null);}else{pmap.put("caigoushijian2", caigoushijian2);}
		if(caigouyuan==null||caigouyuan.equals("")){pmap.put("caigouyuan", null);}else{pmap.put("caigouyuan", caigouyuan);}
		if(tuihuoshuliang==null||tuihuoshuliang.equals("")){pmap.put("tuihuoshuliang", null);}else{pmap.put("tuihuoshuliang", tuihuoshuliang);}
		if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
		
		int total=caigouService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caigou> list=caigouService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caigoulist";
	}
	
	@RequestMapping("deleteCaigou.do")
	public String deleteCaigou(int id,HttpServletRequest request){
		caigouService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:caigouList.do";
	}
	
	
}
