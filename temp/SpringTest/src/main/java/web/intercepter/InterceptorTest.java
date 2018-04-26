package web.intercepter;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterceptorTest {
	
	private static final Logger logger= LoggerFactory.getLogger(InterceptorTest.class);
	
	@RequestMapping(value="intercepter/main",method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mv) {
		
		logger.info("intercepter.main");
		
		mv.setViewName("intercepter/main");
		return mv;
	}
	
	@RequestMapping(value="intercepter/signIn",method=RequestMethod.GET)
	public ModelAndView signInGet(ModelAndView mv) {
		
		logger.info("SignInGet");
		mv.setViewName("intercepter/signIn");
		return mv;
	}
	
	@RequestMapping(value="intercepter/signIn",method=RequestMethod.POST)
	public ModelAndView signInPost(ModelAndView mv, String id, String pw, HttpSession session) {
		
		logger.info("SignInPost");
		
		if("abc".equals(id)) {
			logger.info("ordinary user SignIn");
			session.setAttribute("nick", "ordinary user");
		}else if("admin".equals(id)) {
			session.setAttribute("nick", "admin user");
			logger.info("admin user SignIn");
		}else {
			logger.info("SignIn Failed");
			mv.setViewName("redirect:signIn");
			return mv;
		}
		
		mv.setViewName("redirect:signIn");
		return mv;
	}
	
	@RequestMapping(value="intercepter/signOut",method=RequestMethod.GET)
	public ModelAndView signOut(ModelAndView mv, HttpSession session) {
		
		logger.info("SignOut");
		session.invalidate();
		mv.setViewName("redirect:main");
		return mv;
	}
	
	@RequestMapping(value="intercepter/forum/list",method=RequestMethod.GET)
	public ModelAndView forum(ModelAndView mv) {
		
		mv.setViewName("intercepter/forum/list");
		return mv;
	}
	
	@RequestMapping(value="intercepter/forum/write",method=RequestMethod.GET)
	public ModelAndView forumWrite(ModelAndView mv) {
		
		mv.setViewName("intercepter/forum/write");
		return mv;
	}
	
	@RequestMapping(value="intercepter/forum/failed",method=RequestMethod.GET)
	public ModelAndView forumFailed(ModelAndView mv) {
		
		mv.setViewName("intercepter/forum/failed");
		return mv;
	}
}
