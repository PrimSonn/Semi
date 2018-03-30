package myPage.dto;

public class RatingDto {
	private int idx;
	private String rate;
	
	public RatingDto(int idx, String rate) {
		this.idx= idx;
		this.rate = rate;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
}
