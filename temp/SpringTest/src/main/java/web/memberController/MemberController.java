package web.memberController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger= LoggerFactory.getLogger(MemberController.class);
	
	@Autowired MemberService memberService;
	
	@RequestMapping(value="/member/main")
	public String main(Model model) {
		logger.info("/member/main.do --STARTED");
		
		List list = memberService.getMembers();
		System.out.println(list);
		
		model.addAttribute("list",list);
		
		return "member/main";
	}
}
