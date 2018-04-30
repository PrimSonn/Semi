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
import board.dto.User;
import board.service.BoardService;
import board.service.SignService;
import board.util.Paging;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	@Autowired SignService signService;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, @RequestParam(defaultValue="0") int curPage, Board board) {
		
		if(!board.getTitle().equals("empty")) {
			return listPost(mv,curPage,board);
		}
		int totalCount = boardService.getTotal();
		
		Paging paging = new Paging(totalCount, curPage);
		mv.addObject("paging", paging);
		
		List<Board> list = boardService.getPagingList(paging);
		mv.addObject("list",list);
		
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value="list",method=RequestMethod.POST)
	public ModelAndView listPost(ModelAndView mv, @RequestParam(defaultValue="0") int curPage, Board board) {
		
		int totalCount= boardService.getSearchTotal(board);
				
		Paging paging = new Paging(totalCount, curPage);
		paging.setTitle(board.getTitle());
		mv.addObject("paging", paging);
		
		List<Board> list = boardService.searchTitle(paging);
		mv.addObject("list", list);
		
		mv.setViewName("board/list");
		return mv;
	}
	
	
	@RequestMapping(value="write",method=RequestMethod.GET)
	public ModelAndView writeView(HttpSession session, ModelAndView mv) {
		
		User user = new User();
		
		if(session.getAttribute("id")!=null) {
			
			user.setId((String)session.getAttribute("id"));
			signService.selectAccountById(user);
			
			mv.addObject("user", user);
		}
		
		mv.setViewName("board/write");
		return mv;
	}
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public ModelAndView doWrite(HttpSession session, ModelAndView mv, Board board) {
		
		String writerId = (String) session.getAttribute("id");
		board.setWriterId(writerId);
		System.out.println(board);
		boardService.write(board);
		
		mv.setViewName("redirect:list");
		return mv;
	}
	
	@RequestMapping(value="view",method=RequestMethod.GET)
	public ModelAndView viewContent(HttpSession session, ModelAndView mv,Board board) {
		
		Board newBoard = boardService.viewContent(board);
		newBoard = newBoard==null? new Board() : newBoard;
		mv.addObject("board",newBoard);
		
		if(session.getAttribute("id")!=null) {
			board.setWriterId((String)session.getAttribute("id"));
			board = boardService.recommendCheck(board);
			mv.addObject("recBoard", board);
		}
		
		mv.setViewName("board/contentView");
		return mv;
	}
	
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView edit(HttpSession session,ModelAndView mv,Board board) {
		
		Board newBoard = boardService.viewContent(board);
		if(newBoard!=null&&session.getAttribute("id")!=null&&newBoard.getWriterId().equals((String)session.getAttribute("id"))) {
			
			newBoard = newBoard==null? new Board() : newBoard;
			mv.addObject("board",newBoard);
			mv.setViewName("board/edit");
		}else {
			mv.setViewName("board/list");
		}
		return mv;
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public ModelAndView editPost(HttpSession session, ModelAndView mv, Board board) {
		
		Board newBoard = boardService.viewContent(board);
		if(newBoard!=null&&session.getAttribute("id")!=null&&newBoard.getWriterId().equals((String)session.getAttribute("id"))) {
			
			boardService.edit(board);
			mv.setViewName("redirect:view?boardNo="+board.getBoardNo());
		}else{
			mv.setViewName("board/list");
		}
		
		return mv;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public ModelAndView delete(ModelAndView mv,HttpSession session,Board board) {
		
		System.out.println(board);
		System.out.println(session.getAttribute("id"));
		if(board!=null) {
			if(session.getAttribute("id").equals(board.getWriterId())) {
				boardService.delete(board);
			}else {}
		}else {}
		
		mv.setViewName("redirect:list");
		
		return mv;
	}
	
	@RequestMapping(value="recommend",method=RequestMethod.GET)
	public ModelAndView recommend(ModelAndView mv, HttpSession session, Board board) {
		
		Board newBoard=null;
		
		if((String)session.getAttribute("id")!=null&&board!=null) {
			
			board.setWriterId((String)session.getAttribute("id"));
			newBoard = boardService.recommendCheck(board);
			
			if(newBoard==null) {
				boardService.doRecommend(board);
				mv.setViewName("redirect:view?boardNo="+board.getBoardNo());
				return mv;
			}
		}
		
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping(value="undoRecommend",method=RequestMethod.GET)
	public ModelAndView undoRecommend(ModelAndView mv, HttpSession session, Board board) {
		
		if(session.getAttribute("id")!=null) {
			
			board.setWriterId( (String)session.getAttribute("id"));
			boardService.undoRecommend(board);
			mv.setViewName("redirect:view?boardNo="+board.getBoardNo());
			return mv;	
		}
		
		mv.setViewName("redirect:list");
		return mv;
	}
	
}
