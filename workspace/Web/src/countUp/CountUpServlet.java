package countUp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/countUp.do")
public class CountUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CntDao dao = new CntDao();
		CntVo vo = dao.getCount();
//		System.out.println(vo.getCnt());
		
		request.setAttribute("cnt",vo);
		RequestDispatcher rd = request.getRequestDispatcher("/count/main.jsp");
		rd.forward(request, response);
	}
}
