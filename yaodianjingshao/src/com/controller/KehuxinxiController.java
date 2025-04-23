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

import com.entity.Kehuxinxi;
import com.server.KehuxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KehuxinxiController {
	@Resource
	private KehuxinxiServer kehuxinxiService;


   
	@RequestMapping("addKehuxinxi.do")
	public String addKehuxinxi(HttpServletRequest request,Kehuxinxi kehuxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kehuxinxi.setAddtime(time.toString().substring(0, 19));
		kehuxinxiService.add(kehuxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kehuxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kehuxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKehuxinxi.do")
	public String doUpdateKehuxinxi(int id,ModelMap map,Kehuxinxi kehuxinxi){
		kehuxinxi=kehuxinxiService.getById(id);
		map.put("kehuxinxi", kehuxinxi);
		return "kehuxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("kehuxinxiDetail.do")
	public String kehuxinxiDetail(int id,ModelMap map,Kehuxinxi kehuxinxi){
		kehuxinxi=kehuxinxiService.getById(id);
		map.put("kehuxinxi", kehuxinxi);
		return "kehuxinxi_detail";
	}
//	前台详细
	@RequestMapping("khxxDetail.do")
	public String khxxDetail(int id,ModelMap map,Kehuxinxi kehuxinxi){
		kehuxinxi=kehuxinxiService.getById(id);
		map.put("kehuxinxi", kehuxinxi);
		return "kehuxinxidetail";
	}
//	
	@RequestMapping("updateKehuxinxi.do")
	public String updateKehuxinxi(int id,ModelMap map,Kehuxinxi kehuxinxi,HttpServletRequest request,HttpSession session){
		kehuxinxiService.update(kehuxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kehuxinxiList.do";
	}

//	分页查询
	@RequestMapping("kehuxinxiList.do")
	public String kehuxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kehuxinxi kehuxinxi, String kehu, String xingbie, String lianxishouji, String dizhi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(kehu==null||kehu.equals("")){pmap.put("kehu", null);}else{pmap.put("kehu", kehu);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=kehuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kehuxinxi> list=kehuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kehuxinxi_list";
	}
	
	
	
	@RequestMapping("khxxList.do")
	public String khxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kehuxinxi kehuxinxi, String kehu, String xingbie, String lianxishouji, String dizhi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(kehu==null||kehu.equals("")){pmap.put("kehu", null);}else{pmap.put("kehu", kehu);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=kehuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kehuxinxi> list=kehuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kehuxinxilist";
	}
	
	@RequestMapping("deleteKehuxinxi.do")
	public String deleteKehuxinxi(int id,HttpServletRequest request){
		kehuxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kehuxinxiList.do";
	}
	
	@RequestMapping("quchongKehuxinxi.do")
	public void quchongKehuxinxi(Kehuxinxi kehuxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("kehu", kehuxinxi.getKehu());
		   System.out.println("kehu==="+kehuxinxi.getKehu());
		   System.out.println("kehu222==="+kehuxinxiService.quchongKehuxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(kehuxinxiService.quchongKehuxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "客户可以用！");
				  
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
