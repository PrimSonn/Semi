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

@WebServlet("/MoreComments")
public class MoreComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int PAGECOMMNUM;
	
	public void initMoreComments(int pageCommNum) {
		PAGECOMMNUM = pageCommNum;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		String realPath = (String) context.getAttribute("RealPath");
		
		String mvIdx = request.getParameter("mvIdx");
		String page = request.getParameter("page");
		String id = (String) request.getSession().getAttribute("id");
		
		Func func = new Func();
		
		
		if(((Bouncer)context.getAttribute("bouncer")).check(request, response)){
			
			if(mvIdx!=null&&!mvIdx.isEmpty()&func.isInt(mvIdx)&func.isInt(id)) {
				int intMvIdx =0;
				boolean isMvIdxParsable = false;
				try {
					intMvIdx=Integer.parseInt(mvIdx);
					isMvIdxParsable=true;
				}catch(NumberFormatException e) {
					System.out.println("mvIdx parsing error!!!!!");
					isMvIdxParsable=false;
				}
				
				if(page!=null&&isMvIdxParsable&page!=""&func.isNumber(page)) {
					int pageNumber;
					
					try {
						pageNumber = Integer.parseInt(page);
						int minCommNum = (pageNumber-1)*PAGECOMMNUM;
						int maxCommNum = pageNumber*PAGECOMMNUM;
						
						Pack pack = (new Gatherer()).moreComments(context.getContextPath(), realPath,mvIdx,minCommNum,maxCommNum);
						
						String comCount = pack.getList("MOVIE").get(intMvIdx).getProperty("COMMCOUNT");
						int intComCount = Integer.parseInt(comCount);
						request.setAttribute("COMMCOUNT", intComCount);
						
						request.setAttribute("pageNumber", pageNumber);
						request.setAttribute("pack", pack);
						request.setAttribute("mvIdx", mvIdx);
						
						request.getRequestDispatcher(context.getInitParameter("MoreCommentsView")).forward(request, response);
						
					} catch(NumberFormatException e) {
						System.out.println("Wrong Page Number or CommCount, parsing failed");
						//forward to Movie page
					} catch(Exception Noooooo) {
						System.out.println("Exception occured on MoreComments page!!!!!!!!!!!!");
						//forward to main?? movie??
					}//try catch ends
					
				}else {// if page parameter check failed
					// forward to MoviePAge?
				}
			}else {// mvIdx, id check failed
				response.sendRedirect(context.getContextPath()+context.getInitParameter("Main"));
			}
		}//no else. if bouncer check failed, request has already redirected to DoorView
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
