package moviePage.mainCont;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moviePage.dao.Gatherer;
import moviePage.dto.Pack;
import moviePage.dto.entities.Entity;


@WebServlet("/MoviePage")
public class MoviePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) request.getSession().getAttribute("id");
		String mvIdx = request.getParameter("movie");
		String realPath = (String) this.getServletContext().getAttribute("RealPath");
		
		Pack pack = (new Gatherer()).getThings(this.getServletContext().getContextPath(),realPath,id,mvIdx);
		
		for(String key :pack.getKeys()) {
			System.out.println(key);
			for(Entity e :pack.getList(key)){
				System.out.println("\tProperties: "+e.getPropertiesTable());
				System.out.println("\tImgs: "+e.getImgsTable());
			}
		}
		request.setAttribute("pack", pack);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\'movie\' param: "+request.getParameter("movie"));
	}

}
