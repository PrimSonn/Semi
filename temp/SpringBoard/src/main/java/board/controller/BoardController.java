package board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dto.Board;
import board.service.BoardService;
import board.util.Paging;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, @RequestParam(defaultValue="0") int curPage) {
		
		int totalCount = boardService.getTotal();
		
		Paging paging = new Paging(totalCount, curPage);
		mv.addObject("paging", paging);
		
		List<Board> list = boardService.getPagingList(paging);
		mv.addObject("list",list);
		
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value="write",method=RequestMethod.GET)
	public ModelAndView writeView(ModelAndView mv) {
		
		
		mv.setViewName("board/write");
		return mv;
	}
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public ModelAndView doWrite(HttpSession session, ModelAndView mv, Board board) {
		
		board.setWriter("customWriter");
		boardService.write(board);
		
		mv.setViewName("redirect:list");
		return mv;
	}
}
