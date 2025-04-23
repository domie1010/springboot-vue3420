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

import com.entity.Gongyingshangxinxi;
import com.server.GongyingshangxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GongyingshangxinxiController {
	@Resource
	private GongyingshangxinxiServer gongyingshangxinxiService;


   
	@RequestMapping("addGongyingshangxinxi.do")
	public String addGongyingshangxinxi(HttpServletRequest request,Gongyingshangxinxi gongyingshangxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gongyingshangxinxi.setAddtime(time.toString().substring(0, 19));
		gongyingshangxinxiService.add(gongyingshangxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gongyingshangxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gongyingshangxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGongyingshangxinxi.do")
	public String doUpdateGongyingshangxinxi(int id,ModelMap map,Gongyingshangxinxi gongyingshangxinxi){
		gongyingshangxinxi=gongyingshangxinxiService.getById(id);
		map.put("gongyingshangxinxi", gongyingshangxinxi);
		return "gongyingshangxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("gongyingshangxinxiDetail.do")
	public String gongyingshangxinxiDetail(int id,ModelMap map,Gongyingshangxinxi gongyingshangxinxi){
		gongyingshangxinxi=gongyingshangxinxiService.getById(id);
		map.put("gongyingshangxinxi", gongyingshangxinxi);
		return "gongyingshangxinxi_detail";
	}
//	前台详细
	@RequestMapping("gysxxDetail.do")
	public String gysxxDetail(int id,ModelMap map,Gongyingshangxinxi gongyingshangxinxi){
		gongyingshangxinxi=gongyingshangxinxiService.getById(id);
		map.put("gongyingshangxinxi", gongyingshangxinxi);
		return "gongyingshangxinxidetail";
	}
//	
	@RequestMapping("updateGongyingshangxinxi.do")
	public String updateGongyingshangxinxi(int id,ModelMap map,Gongyingshangxinxi gongyingshangxinxi,HttpServletRequest request,HttpSession session){
		gongyingshangxinxiService.update(gongyingshangxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gongyingshangxinxiList.do";
	}

//	分页查询
	@RequestMapping("gongyingshangxinxiList.do")
	public String gongyingshangxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongyingshangxinxi gongyingshangxinxi, String gongyingshang, String fuzeren, String lianxishouji, String dizhi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gongyingshang==null||gongyingshang.equals("")){pmap.put("gongyingshang", null);}else{pmap.put("gongyingshang", gongyingshang);}
		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=gongyingshangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongyingshangxinxi> list=gongyingshangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongyingshangxinxi_list";
	}
	
	
	
	@RequestMapping("gysxxList.do")
	public String gysxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongyingshangxinxi gongyingshangxinxi, String gongyingshang, String fuzeren, String lianxishouji, String dizhi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gongyingshang==null||gongyingshang.equals("")){pmap.put("gongyingshang", null);}else{pmap.put("gongyingshang", gongyingshang);}
		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=gongyingshangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongyingshangxinxi> list=gongyingshangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongyingshangxinxilist";
	}
	
	@RequestMapping("deleteGongyingshangxinxi.do")
	public String deleteGongyingshangxinxi(int id,HttpServletRequest request){
		gongyingshangxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gongyingshangxinxiList.do";
	}
	
	@RequestMapping("quchongGongyingshangxinxi.do")
	public void quchongGongyingshangxinxi(Gongyingshangxinxi gongyingshangxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gongyingshang", gongyingshangxinxi.getGongyingshang());
		   System.out.println("gongyingshang==="+gongyingshangxinxi.getGongyingshang());
		   System.out.println("gongyingshang222==="+gongyingshangxinxiService.quchongGongyingshangxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(gongyingshangxinxiService.quchongGongyingshangxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "供应商可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
