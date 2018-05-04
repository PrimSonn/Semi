package board.dao;

import board.dto.UploadFile;

public interface FileDao {
	
	/*
	 * stores file upload
	 *
	 * @param uploadFile - upload file information
	 * 				property: original_filename
	 * 				property: 			
	 * 
	 * */
	public void insert(UploadFile uploadFile);
}
