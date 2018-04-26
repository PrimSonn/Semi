package web.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Admin {
	
	private static final Logger logger= LoggerFactory.getLogger(Admin.class);
	
	@RequestMapping(value="/intercepter/admin/main",method=RequestMethod.GET)
	public ModelAndView adminMain(ModelAndView mv) {
		
		
		
		mv.setViewName("/intercepter/admin/main");
		return mv;
	}

	@RequestMapping(value="intercepter/admin/fail",method=RequestMethod.GET)
	public ModelAndView fail(ModelAndView mv) {
		
		mv.setViewName("intercepter/admin/fail");
		return mv;
	}
	
}
