package board.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadFile {
	
	private int fileno;
	private String original_filename;
	private String stored_filename;
	private long file_size;
	private Date upload_date;
	private Integer boardNo;
	
	
	@Override
	public String toString() {
		return "UploadFile [ fileno "+getFileno()+" original_filename "+getOriginal_filename()+" stored_filename "+getStored_filename()+" file_size "+getFile_size()+" upload_date "+getUpload_date()+" ]";
	}
	
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public String getOriginal_filename() {
		return original_filename;
	}
	public void setOriginal_filename(String original_filename) {
		this.original_filename = original_filename;
	}
	public String getStored_filename() {
		return stored_filename;
	}
	public void setStored_filename(String stored_filename) {
		this.stored_filename = stored_filename;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public String getUpload_date() {
		DateFormat formatter = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		if(upload_date==null) {
			upload_date = new Date();
		}
		return formatter.format(upload_date);
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}public Integer getBoardNo() {
		return boardNo;
	}public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
}
