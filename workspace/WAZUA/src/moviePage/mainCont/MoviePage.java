package moviePage.mainCont;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moviePage.dao.Gatherer;
import moviePage.dto.Pack;


@WebServlet("/MoviePage")
public class MoviePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = this.getServletContext();
		String id = (String) request.getSession().getAttribute("id");
		String mvIdx = request.getParameter("mvIdx");
		String realPath = (String) context.getAttribute("RealPath");
		
		
		Pack pack = (new Gatherer()).getThings(context.getContextPath(),realPath,id,mvIdx);
		
		request.setAttribute("pack", pack);
		request.setAttribute("mvIdx", mvIdx);
		request.getRequestDispatcher(context.getInitParameter("MoviePageView")).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("\'movie\' param: "+request.getParameter("movie"));
		doGet(request,response);
	}

}
