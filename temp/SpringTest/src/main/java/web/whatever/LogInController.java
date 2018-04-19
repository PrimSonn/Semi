package web.whatever;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.dto.UserVo;

@Controller
public class LogInController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogInController.class);
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		logger.info("HelloLogger");
		return "web/SignIn";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public ModelAndView aaa(UserVo userVo, String id, String pw) {
		
		logger.info("Posted!  ID: "+id+"\tPW: "+pw);
		logger.info(userVo.toString());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",userVo);
//		mav.setViewName("/web/Main");
		mav.setViewName("redirect:/Main");
		
		return mav;
	}
	
	@RequestMapping(value="/Main", method=RequestMethod.GET)
	public ModelAndView bbb() {
		
		logger.info("MainController!");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/web/Main");
		
		return mav;
	}
	
}
