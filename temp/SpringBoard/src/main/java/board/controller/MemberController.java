package board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.dto.User;
import board.service.SignService;

@Controller
public class MemberController {
	
	@Autowired SignService signService;

	@RequestMapping(value="/Sign/Main", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mv) {
		
		mv.setViewName("/Sign/Main");
		return mv;
	}
	
	@RequestMapping(value="/Sign/Up", method=RequestMethod.GET)
	public ModelAndView joinView(ModelAndView mv) {
		
		mv.setViewName("/Sign/Up");
		return mv;
	}
	
	@RequestMapping(value="/Sign/Up", method=RequestMethod.POST)
	public ModelAndView dojoin(ModelAndView mv, User user) {
		
		User newUser = signService.in(user);
		boolean check = newUser==null&&user.getId()!=null&&user.getPw()!=null&&!user.getId().equals("")&&!user.getPw().equals("");
		if(check) {
			
			signService.up(user);
			newUser = signService.in(user);
			if(newUser==null) {
				mv.setViewName("redirect:Up");
			}else {
				mv.setViewName("redirect:Main");
			}
			
		}else {
			mv.setViewName("redirect:Up");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/Sign/In",method=RequestMethod.GET)
	public ModelAndView signInView(ModelAndView mv) {
		
		mv.setViewName("/Sign/In");
		return mv;
	}
	
	@RequestMapping(value="/Sign/In",method=RequestMethod.POST)
	public ModelAndView doSignIn(ModelAndView mv,User user,HttpSession session) {
		
		if(user.getId()==null||user.getPw()==null||user.getId().equals("")|user.getPw().equals("")) {
			mv.setViewName("redirect:In");
		}else {
				User newUser = signService.in(user);
			if(newUser==null) {
				mv.setViewName("redirect:In");
			}else {
				session.setAttribute("id", newUser.getId());
				session.setAttribute("nick", newUser.getNick());
				mv.setViewName("redirect:Main");
			}
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="/Sign/Out",method=RequestMethod.GET)
	public ModelAndView out(ModelAndView mv,HttpSession session) {
		
		session.invalidate();
		mv.setViewName("/Sign/Main");
		return mv;
	}
	
	@RequestMapping(value="/Sign/Error",method=RequestMethod.GET)
	public String reject() {
		return "/Sign/Error";
	}
}
