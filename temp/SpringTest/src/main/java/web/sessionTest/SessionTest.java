package web.sessionTest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.dao.SessionTestDao;
import web.dto.SessionTestMember;


@Controller
public class SessionTest {
	
	@Autowired SessionTestDao dao;
	
	@RequestMapping(value="/session/test",method=RequestMethod.GET)
	public String sessionTest(HttpSession session,Model m) {
		
		return "sessionTest/SessionTest";
	}
	
	@RequestMapping(value="/session/info",method=RequestMethod.GET)
	public String checkSession(HttpSession session,Model m) {
		
		session.setAttribute("1", "123");
		session.setAttribute("2", "234");
		session.setAttribute("3", "345");
		return "sessionTest/SessionAttr";
	}
	
	@RequestMapping(value="/session/delete",method=RequestMethod.GET)
	public String invalSession(HttpSession session,Model m) {
		
		session.invalidate();
		return "sessionTest/SessionAttr";
	}
	
	
	//--------------------------------------------------------------
	
	@RequestMapping(value="/log/main",method=RequestMethod.GET)
	public String main() {
		
		return "sessionTest/logmain";
	}
	
	@RequestMapping(value="/log/join",method=RequestMethod.GET)
	public String join() {
		
		return "sessionTest/join";
	}
	
	@RequestMapping(value="/log/join",method=RequestMethod.POST)
	public ModelAndView joinProc(ModelAndView modelV, SessionTestMember mem) {
		
		int i =1;
		
		if(mem.getId()!=null&&mem.getPw()!=null&&mem.getId()!=""&&mem.getPw()!="") {
			i = dao.checkId(mem);
			System.out.println("i: "+i);
		}
		if(i==0) {
			dao.join(mem);
			modelV.setViewName("sessionTest/logmain");
		}else {
			modelV.setViewName("redirect:join");
		}
		
		return modelV;
	}
	
	@RequestMapping(value="/log/in",method=RequestMethod.GET)
	public String login() {
		
		return "sessionTest/login";
	}
	
	@RequestMapping(value="/log/in",method=RequestMethod.POST)
	public ModelAndView loginProc(HttpSession session, ModelAndView modelV,SessionTestMember mem) {
		
		SessionTestMember checkMem=dao.pick(mem);
		if(checkMem==null) {
			modelV.setViewName("redirect:in");
		}else {
			session.setAttribute("id", checkMem.getId());
			modelV.setViewName("redirect:main");
		}
		return modelV;
	}
	
	@RequestMapping(value="/log/mypage",method=RequestMethod.GET)
	public ModelAndView mypage(HttpSession session,ModelAndView modelV) {
		
		SessionTestMember mem=null;
		modelV.addObject(
			mem=
			dao.pickById((String) session.getAttribute("id"))
		);
		modelV.setViewName("sessionTest/myPage");
		
		return modelV;
	}
	@RequestMapping(value="/log/out",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
	
}
