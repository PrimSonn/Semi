package board.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		File file = (File)model.get("file");
		
		if(file.exists()) {
			response.setContentType("application/octet-stream");
			response.setContentLength((int)file.length());

			String[] splitted = file.getName().split("_");
			
			String filename = URLEncoder.encode(file.getName().split("_")[splitted.length-2], "utf-8");
			
			filename = filename.replace("+", "%20");
			filename = filename.replace("%5B", "[");
			filename = filename.replace("%5D", "]");
			filename = filename.replace("%21", "!");
			filename = filename.replace("%23", "#");
			filename = filename.replace("%24", "$");
			filename = filename.replace("%25", "%");
			filename = filename.replace("%26", "&");
			filename = filename.replace("%27", "'");
			filename = filename.replace("%28", "(");
			filename = filename.replace("%29", ")");
			filename = filename.replace("%2B", "+");
			filename = filename.replace("%2C", ",");
			filename = filename.replace("%40", "@");
			filename = filename.replace("%5E", "^");
			
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			OutputStream out = response.getOutputStream();
			
			try(FileInputStream fis = new FileInputStream(file)){
				
				FileCopyUtils.copy(fis, out);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			out.flush();
			
		}else {
			System.out.println("notexist");
		}
		
		
	}

}
