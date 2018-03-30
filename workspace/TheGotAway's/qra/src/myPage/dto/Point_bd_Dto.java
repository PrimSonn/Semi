package myPage.dto;

import java.sql.Date;

public class Point_bd_Dto {

	private int idx;
	private Date cng_date;
	private String cng_cus;
	private int rec_pnt;
	private int use_pnt;
	private String status;
	
	
	
	public String getCng_cus() {
		return cng_cus;
	}

	public void setCng_cus(String cng_cus) {
		this.cng_cus = cng_cus;
	}
	public Point_bd_Dto(int idx,Date cng_date,String cng_cus,int rec_pnt, int use_pnt, String status) {

	this.idx = idx;
	this.cng_date = cng_date;
	this.cng_cus = cng_cus;
	this.rec_pnt = rec_pnt;
	this.use_pnt = use_pnt;
	this.status = status;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Date getCng_date() {
		return cng_date;
	}
	public void setCng_date(Date cng_date) {
		this.cng_date = cng_date;
	}
	public int getRec_pnt() {
		return rec_pnt;
	}
	public void setRec_pnt(int rec_pnt) {
		this.rec_pnt = rec_pnt;
	}
	public int getUse_pnt() {
		return use_pnt;
	}
	public void setUse_pnt(int use_pnt) {
		this.use_pnt = use_pnt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
