package web.memberController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Member;
import web.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger= LoggerFactory.getLogger(MemberController.class);
	
	@Autowired MemberService memberService;
	
	@RequestMapping(value="/member/main")
	public String main(Model model) {
//		logger.info("/member/main --STARTED");
		
		List list = memberService.getMembers();
//		System.out.println(list);
		
		model.addAttribute("list",list);
		
		return "member/main";
	}
	
	@RequestMapping(value="/member/insert", method=RequestMethod.POST)
	public String insert(Member m) {
		logger.info(m.toString());
		
		memberService.insertMember(m);
		
		return "redirect:/member/main";
	}
	
	@RequestMapping(value="/member/delete", method=RequestMethod.POST)
	public String main(Member m) {
		
		System.out.println("idx: "+m.getIdx());
		
		memberService.delete(m);
		
		return "redirect:/member/main";
	}
	
}
