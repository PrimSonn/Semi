package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.Recommend;
import service.RecommendService;
import service.RecommendServiceimpl;


@WebServlet("/recommend/ajaxCheck.do")
public class RecommendAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecommendService service = new RecommendServiceimpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/json; charset=utf-8");
//		response.setCharacterEncoding("UTF-8");
//		System.out.println("Ajax Check");
		
		String id = request.getParameter("recommendId");
//		System.out.println("recommendId: "+id);
		
		Recommend user = new Recommend();
		user.setRecommendId(id);
		service.check(user);
				
//		response.getWriter().write("json");
//		response.getWriter().write("{\"json\":\"test\"}");
//		response.getWriter().write("<h1>test</h1>);
		
		int cnt =service.getTotal();
		List<Recommend> ids = service.getIDs();
		Gson gson = new Gson();
		
		System.out.println("============ gson =================");
		System.out.println("cnt: " + gson.toJson(cnt) );
		System.out.println("ids: " + gson.toJson(ids) );
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("cnt", gson.toJson(cnt));
		jsonObject.addProperty("list", gson.toJson(ids));
		response.getWriter().write(gson.toJson(jsonObject));
	}

}
