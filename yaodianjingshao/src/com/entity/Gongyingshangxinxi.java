package com.entity;

public class Gongyingshangxinxi {
    private Integer id;
	private String gongyingshang;	private String fuzeren;	private String lianxishouji;	private String dizhi;	private String beizhu;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGongyingshang() {
        return gongyingshang;
    }
    public void setGongyingshang(String gongyingshang) {
        this.gongyingshang = gongyingshang == null ? null : gongyingshang.trim();
    }	public String getFuzeren() {
        return fuzeren;
    }
    public void setFuzeren(String fuzeren) {
        this.fuzeren = fuzeren == null ? null : fuzeren.trim();
    }	public String getLianxishouji() {
        return lianxishouji;
    }
    public void setLianxishouji(String lianxishouji) {
        this.lianxishouji = lianxishouji == null ? null : lianxishouji.trim();
    }	public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
