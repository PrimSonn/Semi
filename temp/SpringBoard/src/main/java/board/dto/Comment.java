package board.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import oracle.sql.DATE;

public class Comment {
	
	private Integer commentNo;
	private Integer boardNo;
	private String userId;
	private String pw;
	private String content;
	private DATE writtenDate;
	private String nick;
	
	@Override
	public String toString() {
		return "comment [ commentNo: "+getCommentNo()+" boardNo: "+getBoardNo()+" userId: "+getUserId()+" pw: "+getPw()+" content: "+getContent()+" writtenDate: "+getWrittenDate()+" nick: "+getNick()+" ]";
	}
	
	public Integer getCommentNo() {
		
		return commentNo = commentNo==null ? -1 : commentNo ;
	}
	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}
	public Integer getBoardNo() {
		return boardNo = boardNo==null? -1: boardNo;
	}
	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
	public String getUserId() {
		return userId = userId==null? "": userId ;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPw() {
		return pw = pw==null? "": pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content = content==null? "":content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrittenDate() {
		
		if(writtenDate==null) {
			return "----/--/-- --:--:--";
		}else {
			DateFormat formatter = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
			return formatter.format(writtenDate);
		}
	}
	public void setWrittenDate(DATE writtenDate) {
		this.writtenDate = writtenDate;
	}
	public String getNick() {
		return nick = nick==null? "":nick ;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
}
