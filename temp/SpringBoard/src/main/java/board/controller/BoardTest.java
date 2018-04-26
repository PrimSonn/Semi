package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardTest {
	
	@RequestMapping(value="/boardTest", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("/boardTest/1");
		return mv;
		
		
	}
}