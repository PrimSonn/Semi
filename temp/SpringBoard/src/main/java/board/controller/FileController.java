package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import board.dao.FileDao;
import board.dto.UploadFile;

@Controller
public class FileController {
	
	@Autowired ServletContext context;
	@Autowired FileDao fileDao;
	
	@RequestMapping(value="/file/fileForm",method=RequestMethod.GET)
	public void fileForm() {
	}
	
	@RequestMapping(value="/file/fileUpload",method=RequestMethod.POST)
	public String upload(MultipartFile file) {
		
//		System.out.println("getName: "+file.getName());
//		System.out.println("original fileName: "+file.getOriginalFilename());
		
		System.out.println(UUID.randomUUID().toString());
		
		String uID = UUID.randomUUID().toString().split("-")[0];
		
		String realpath = context.getRealPath("upload");
//		System.out.println("realPath(): "+ context.getRealPath("\\"));
		
		String storedName = file.getOriginalFilename() +"_"+uID;
		
		File dest = new File(realpath, storedName );
		
		try {
			file.transferTo(dest);
//			System.out.println(dest);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UploadFile uploadFile = new UploadFile();
		uploadFile.setOriginal_filename(file.getOriginalFilename());
		uploadFile.setStored_filename(storedName);
		uploadFile.setFile_size(file.getSize());
		
		fileDao.insert(uploadFile);
		
		return "redirect:fileForm";
	}
	
}
