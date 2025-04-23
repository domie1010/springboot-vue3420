package com.entity;

public class Shangpinxinxi {
    private Integer id;
	private String shangpinbianhao;
	private String shangpinmingcheng;
	private String leibie;
	private String kucun;
	private String baozhiqi;
	private String jg;
	private String xq;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShangpinbianhao() {
        return shangpinbianhao;
    }
    public void setShangpinbianhao(String shangpinbianhao) {
        this.shangpinbianhao = shangpinbianhao == null ? null : shangpinbianhao.trim();
    }
	public String getShangpinmingcheng() {
        return shangpinmingcheng;
    }
    public void setShangpinmingcheng(String shangpinmingcheng) {
        this.shangpinmingcheng = shangpinmingcheng == null ? null : shangpinmingcheng.trim();
    }
	public String getLeibie() {
        return leibie;
    }
    public void setLeibie(String leibie) {
        this.leibie = leibie == null ? null : leibie.trim();
    }
	public String getKucun() {
        return kucun;
    }
    public void setKucun(String kucun) {
        this.kucun = kucun == null ? null : kucun.trim();
    }
	public String getBaozhiqi() {
        return baozhiqi;
    }
    public void setBaozhiqi(String baozhiqi) {
        this.baozhiqi = baozhiqi == null ? null : baozhiqi.trim();
    }
	
	
	public String getJg() {
        return jg;
    }
    public void setJg(String jg) {
        this.jg = baozhiqi == null ? null : jg.trim();
    }
	
	public String getXq() {
        return xq;
    }
    public void setXq(String xq) {
        this.xq = xq == null ? null : xq.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
