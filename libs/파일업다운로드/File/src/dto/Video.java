package dto;

import java.sql.Blob;

public class Video {
	int no;
	String video_name;
	Blob video;
	long len;
	
	public Blob getVideo() {
		return video;
	}
	public void setVideo(Blob video) {
		this.video = video;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
}
