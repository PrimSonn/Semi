package aaa.bbb.ccc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public void hello() {
		
		logger.info("HelloLogger");
	}
}
