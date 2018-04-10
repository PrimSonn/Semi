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
import moviePage.dto.entities.Entity;
import moviePage.func.Func;

@WebServlet("/MoreComments")
public class MoreComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int PAGECOMMAMOUNT;
	
	public void initMoreComments(int PAGECOMMAMOUNT) {
		MoreComments.PAGECOMMAMOUNT = PAGECOMMAMOUNT;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		
		String mvIdx = request.getParameter("mvIdx");
		String page = request.getParameter("page");
		String id = (String) request.getSession().getAttribute("id");
		
		Func func = new Func();
		
		
		if(mvIdx!=null&&!mvIdx.isEmpty()&func.isInt(mvIdx)&func.isInt(id)) {
			
			if(page!=null&&page!=""&func.isNumber(page)) {
				
				int pageNumber;
				
				try {
					pageNumber = Integer.parseInt(page);
					int minCommNum = (pageNumber-1)*PAGECOMMAMOUNT+1;
					int maxCommNum = pageNumber*PAGECOMMAMOUNT;
					
					
					Pack pack = (new Gatherer()).moreComments(context.getContextPath(), context.getRealPath("/") ,mvIdx,minCommNum,maxCommNum);
					
					String comCount = null;
					for(Entity mv: pack.getList("MOVIE")) {
						if( mvIdx.matches(mv.getIdx()) ) {
							comCount= mv.getProperty("COMMCOUNT");
							break;
						}
					}
					if(comCount!=null) {
						
						int intComCount = Integer.parseInt(comCount);
						request.setAttribute("COMMCOUNT", intComCount);
						request.setAttribute("PAGECOMMAMOUNT", PAGECOMMAMOUNT);
						request.setAttribute("pageNumber", pageNumber);
						request.setAttribute("pack", pack);
						request.setAttribute("mvIdx", mvIdx);
						
						request.getRequestDispatcher(context.getInitParameter("MoreCommentsView")).forward(request, response);
						
					}else {
						System.out.println("No CommCount!!!!!");
						//send back to moviepage
					}
					
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
