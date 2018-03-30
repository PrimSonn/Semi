package myPage.dto;

import java.sql.Date;

public class PayHistoryDto {
	
	private int idx;
	private int mem_idx;
	private int mv_idx;
	private int fs_idx;
	private Date p_date;
	private int pay;
	private String method;
	private String status;
	
public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

public PayHistoryDto(int idx,int mem_idx,int mv_idx,int fs_idx,Date p_date,int pay,String method,String status) {
	this.idx = idx;
	this.mem_idx = mem_idx;
	this.mv_idx = mv_idx;
	this.fs_idx = fs_idx;
	this.p_date = p_date;
	this.pay = pay;
	this.method = method;
	this.status = status;
}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public int getMv_idx() {
		return mv_idx;
	}
	public void setMv_idx(int mv_idx) {
		this.mv_idx = mv_idx;
	}
	public int getFs_idx() {
		return fs_idx;
	}
	public void setFs_idx(int fs_idx) {
		this.fs_idx = fs_idx;
	}
	public Date getP_date() {
		return p_date;
	}
	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	
	
	
}
