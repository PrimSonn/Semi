package myPage.dto;

import java.sql.Date;

public class QraDto {
	
	private int idx,mem_idx;
	private String q_title, q_ctnt,a_ctnt,status,q_type;
	private Date q_date,a_date;
	

	public QraDto(String q_type,int idx, int mem_idx,String q_title,String q_ctnt, String a_ctnt,Date q_date,Date a_date, String status) {
		this.q_type = q_type;
		this.idx= idx;
		this.mem_idx = mem_idx;
		this.q_title = q_title;
		this.q_ctnt = q_ctnt;
		this.a_ctnt = a_ctnt;
		this.q_date = q_date;
		this.a_date = a_date;
		this.status = status;
	}
	
	public String getQ_type() {
		return q_type;
	}

	public void setQ_type(String type) {
		this.q_type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_ctnt() {
		return q_ctnt;
	}

	public void setQ_ctnt(String q_ctnt) {
		this.q_ctnt = q_ctnt;
	}

	public String getA_ctnt() {
		return a_ctnt;
	}

	public void setA_ctnt(String a_ctnt) {
		this.a_ctnt = a_ctnt;
	}

	public Date getQ_date() {
		
		return q_date;
	}

	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}

	public Date getA_date() {
		return a_date;
	}

	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
}
