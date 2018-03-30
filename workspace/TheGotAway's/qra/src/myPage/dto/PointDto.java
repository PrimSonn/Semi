package myPage.dto;

import java.sql.Date;

public class PointDto {

	private int idx;
	private int point;
	private Date get_date;
	private Date exp_date;
	
	
	public PointDto(int idx, int point,Date get_date,Date exp_date) {

	this.idx = idx;
	this.point= point;
	this.get_date= get_date;
	this.exp_date = exp_date;

	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getGet_date() {
		return get_date;
	}
	public void setGet_date(Date get_date) {
		this.get_date = get_date;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

}
