package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TilesController {
	
	@RequestMapping(value="/tiles/main",method=RequestMethod.GET)
	public void main() {
//		return "tiles/main";
	}
	
	@RequestMapping(value="/tiles/test/test",method=RequestMethod.GET)
	public String aaa() {
		return "empty/empty";
	}

}
