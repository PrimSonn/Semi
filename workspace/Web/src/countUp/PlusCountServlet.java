package countUp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plusCount.do")
public class PlusCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		CntDao dao = new CntDao();
//		CntVo vo = dao.getCount();
		
		CntService service = new CntService();
		service.plusCount();
		response.sendRedirect("/countUp.do");
		
//		vo.setCnt(vo.getCnt()+1);
//		dao.setCount(vo);
		
	}

}
