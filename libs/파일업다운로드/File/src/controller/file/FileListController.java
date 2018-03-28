package controller.file;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.file.FileDao;
import dto.Image;
import dto.Video;

@WebServlet("/FileList")
@SuppressWarnings("serial")
public class FileListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileDao dao = new FileDao();
		
		List<Image> images = dao.getImage();
		List<Video> videos = dao.getVideo();
		
//		for(Image i : images)
//			System.out.println(i.getImage());
//		for(Video v : videos)
//			System.out.println(v.getVideo());
		
		request.setAttribute("images", images);
		request.setAttribute("videos", videos);
		
		request.getRequestDispatcher("/file/list.jsp").forward(request, response);
	}
}
