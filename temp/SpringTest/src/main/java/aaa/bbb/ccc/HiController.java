package aaa.bbb.ccc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HiController {

	@RequestMapping(value ="/path1/hi", method=RequestMethod.GET)
	public String hi(Model model) {
		
		System.out.println("hi.do");
		
		model.addAttribute("AA", "BB");
		
		return "/path2/hi";
	}
}
