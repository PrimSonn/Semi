package moviePage.mainCont;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bouncer.Bouncer;
import moviePage.dao.Gatherer;
import moviePage.dto.Pack;
import moviePage.func.Func;


@WebServlet(asyncSupported = true, description = "comment writer", urlPatterns = { "/WriteComment" })
public class WriteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WriteComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mvIdx=null;
		ServletContext context = this.getServletContext();
		mvIdx = request.getParameter("mvIdx");
		Func func = new Func();
		
		if(((Bouncer)context.getAttribute("bouncer")).check(request, response)){
			if(mvIdx!=null&&!mvIdx.isEmpty()&func.isInt(mvIdx)) {
				String id = (String) request.getSession().getAttribute("id");
				String realPath = (String) context.getAttribute("RealPath");
				
				Pack pack = (new Gatherer()).mvCmtInit(context.getContextPath(), realPath, id, mvIdx);
				request.setAttribute("pack", pack);
				request.setAttribute("mvIdx", mvIdx);
				request.getRequestDispatcher(context.getInitParameter("WriteCommentView")).forward(request, response);
			}else {
				response.sendRedirect(context.getContextPath()+context.getInitParameter("Main"));
			}
		}//no else. if bouncer check was false, request has already redirected to DoorView
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("posted");//--------------------------------testcode
		
		ServletContext context = this.getServletContext();
		
//		System.out.println(request.getParameter("comment"));//-----------testcode
//		System.out.println(request.getParameter("mvIdx"));//----------------test
		System.out.println(request.getParameter("score"));
		
		String comment = request.getParameter("comment");
		String mvIdx = request.getParameter("mvIdx");
		String score = request.getParameter("score");
		String maxScore = context.getInitParameter("MaxScore");
		int intMvIdx;
		double doubleScore = 0, doubleMaxScore = 5;
		boolean error = false;
		boolean nullscore = true;
		Func func = new Func();
		if(score==null|score=="")nullscore=true;
		
		if(func.isInt(mvIdx)) {
			
			if(!nullscore&func.isNumber(score)) {
				try {
					doubleMaxScore = Double.parseDouble(maxScore);
					doubleScore = Double.parseDouble(score);
					if(doubleScore>doubleMaxScore|doubleScore<0) error=true;
				} catch(NumberFormatException Noooo) {
					error=true;
				}
			}
			try {
				intMvIdx = Integer.parseInt(mvIdx);
			}catch(NumberFormatException Noooo) {
				error=true;
			}
			
			if(((Bouncer)context.getAttribute("bouncer")).check(request, response)) {
				if(error|comment==null|comment.isEmpty()|mvIdx.isEmpty()) {
					doGet(request,response);
				} else {
					String id = (String)request.getSession().getAttribute("id");
					new Gatherer().mvCmtCommit(id, mvIdx, nullscore, doubleScore, comment);
					request.getRequestDispatcher(context.getInitParameter("MoviePage")).forward(request, response);
				}
			}//attribute check ends
			
		}//isNumber check ends
		
		
	}
	
}
