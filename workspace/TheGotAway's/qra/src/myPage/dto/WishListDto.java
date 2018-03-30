package myPage.dto;

public class WishListDto {
	private int idx ;
	private int mv_idx;
	private String flag;
	
	public WishListDto(int idx, int mv_idx,String flag) {
		this.idx = idx;
		this.mv_idx= mv_idx;
		this.flag = flag;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMv_idx() {
		return mv_idx;
	}
	public void setMv_idx(int mv_idx) {
		this.mv_idx = mv_idx;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
