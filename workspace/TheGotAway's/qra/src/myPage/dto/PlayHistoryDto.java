package myPage.dto;

public class PlayHistoryDto {
	private int idx;
	private int mem_idx;
	private int mv_idx;
	private String mcheck;

	public PlayHistoryDto(int idx,int mem_idx,int mv_idx,String mcheck) {
		this.idx = idx;
		this.mem_idx = mem_idx;
		this.mv_idx = mv_idx;
		this.mcheck = mcheck;
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
	public String getMcheck() {
		return mcheck;
	}
	public void setMcheck(String mcheck) {
		this.mcheck = mcheck;
	}
	
}
