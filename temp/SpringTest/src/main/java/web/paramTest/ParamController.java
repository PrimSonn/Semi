package web.paramTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Person;

@Controller
public class ParamController {
	
	private static final Logger logger= LoggerFactory.getLogger(ParamController.class);
	
	@RequestMapping(value="/paramTest",method=RequestMethod.GET)
	public String paramGet() {
		return "test/paramForm";
	}
	
	@RequestMapping(value="/paramTest",method=RequestMethod.POST)
	public String paramPost(Person p, Model m) {
		if(m!=null) {
			m.addAttribute(m);
			return "test/paramResult";
		}else {
			return "test/paramForm";
		}
	}
	
}
