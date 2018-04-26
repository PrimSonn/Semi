package board.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	
	Integer boardNo;
	String title;
	String writerId;
	String writer;
	String content;
	Integer hit;
	Integer recommend;
	Date writtenDate;
	
	@Override
	public String toString() {
		
		return "Board [boardNo: "+getBoardNo()+" title: "+getTitle()+" writerId: "+getWriterId()+" writer: "+getWriter()+" content: "+getContent()+" hit: "+getHit()+" recommend: "+getRecommend()+" writtenDate: "+getWrittenDate()+" ]";
	}
	
	public Integer getBoardNo() {
		return boardNo = boardNo==null ? -1 : boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title = title==null||title==""? "empty": title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterId() {
		return writerId==null||writerId=="" ? "empty": writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriter() {
		return writer==null||writer=="" ? "empty" : writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content==null||content=="" ? "empty": content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getHit() {
		return hit==null ? - 1: hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	public Integer getRecommend() {
		return recommend==null? -1: recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public String getWrittenDate() {
		if(writtenDate!=null) {
			DateFormat formatter = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
			return formatter.format(writtenDate);
		}else {
			return "----/--/--";
		}
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	
}
/*
 CREATE TABLE board (
	boardNo NUMBER primary key,
	title VARCHAR2(500),
	writerId VARCHAR2(100),
	writer VARCHAR2(100),
	content VARCHAR2(4000),
	hit NUMBER,
	recommend NUMBER,
	writtenDate date DEFAULT sysdate
);
 */