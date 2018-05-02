package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.dto.Board;
import board.dto.Comment;
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
		
		if(!board.isTitleNull()) {
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
		boardService.write(board);
		
		mv.setViewName("redirect:list");
		return mv;
	}
	
	@RequestMapping(value="view",method=RequestMethod.GET)
	public ModelAndView viewContent(HttpSession session, ModelAndView mv,Board board, @RequestParam(defaultValue="0")int curPage) {
		
		Board newBoard = boardService.viewContent(board);
		int totalCount = boardService.totalComment(board.getBoardNo());
		newBoard = newBoard==null? new Board() : newBoard;
		mv.addObject("board",newBoard);
		
		board.setWriterId((String)session.getAttribute("id"));
		board = boardService.recommendCheck(board);
		mv.addObject("recBoard", board);
		
		Paging paging = new Paging(totalCount, curPage);
		mv.addObject("paging", paging);
		
		List<Comment> list = boardService.listComment(paging);
		mv.addObject("commentList", list);
		
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
		
		if(board!=null) {
			if(session.getAttribute("id").equals(board.getWriterId())) {
				boardService.delete(board);
			}else {}
		}else {}
		mv.setViewName("redirect:list");
		return mv;
	}
	
	@RequestMapping(value="recommend",method=RequestMethod.GET)
	@ResponseBody
	public String recommend(HttpServletResponse response,HttpSession session, Board board) {
		
		Board newBoard=null;
		
		if((String)session.getAttribute("id")!=null&&board!=null) {
			
			board.setWriterId((String)session.getAttribute("id"));
			newBoard = boardService.recommendCheck(board);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			if(newBoard==null) {
				boardService.doRecommend(board);
				return boardService.viewContent(board).getRecommend().toString();
//				mv.setViewName("redirect:view?boardNo="+board.getBoardNo());
//				return mv;
			}else {
				return boardService.viewContent(board).getRecommend().toString();
			}
		}
		
//		mv.setViewName("list");
		return "error";
	}
	
	@RequestMapping(value="undoRecommend",method=RequestMethod.GET)
	@ResponseBody
	public String undoRecommend(HttpServletResponse response,HttpSession session, Board board) {
		
		if(session.getAttribute("id")!=null) {
			
			board.setWriterId( (String)session.getAttribute("id"));
			Board newBoard = boardService.recommendCheck(board);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			if(newBoard!=null) {
				boardService.undoRecommend(board);
				return boardService.viewContent(board).getRecommend().toString();
			}else {
				return boardService.viewContent(board).getRecommend().toString();
			}
//			mv.setViewName("redirect:view?boardNo="+board.getBoardNo());
			
			
//			return mv;	
		}
		return "error";
//		mv.setViewName("redirect:list");
//		return mv;
	}
	
	@RequestMapping(value="writeComment",method=RequestMethod.POST)
	public ModelAndView writeComment(ModelAndView mv,HttpSession session, Comment comment) {
		
		comment.setUserId((String)session.getAttribute("id"));
		comment.setNick((String)session.getAttribute("nick"));
		boardService.writeComment(comment);
		
		mv.setViewName("redirect:view?boardNo="+comment.getBoardNo());
		return mv;
	}
	
	@RequestMapping(value="deleteComment",method=RequestMethod.GET)
	public ModelAndView deleteComment(ModelAndView mv,HttpSession session, Comment comment) {
		
		System.out.println(comment);
		comment.setUserId((String)session.getAttribute("id"));
		
		if(boardService.checkComment(comment)) {
			boardService.deleteComment(comment);
			mv.setViewName("redirect:view?boardNo="+comment.getBoardNo());
		}else {
			mv.setViewName("redirect:view?boardNo="+comment.getBoardNo());
		}
		
		return mv;
	}
	
	@RequestMapping(value="deleteBoardList",method=RequestMethod.POST)
	public ModelAndView deleteBoardList (ModelAndView mv, Board board, @RequestParam(defaultValue="0")int curPage) {
		
		if(!board.getContent().equals("")) boardService.deleteBoardList(board);
		
		if(!board.getTitle().equals("")) {
			mv.setViewName("redirect:list?curPage="+curPage+"&title="+board.getTitle());
		}else {
			mv.setViewName("redirect:list?curPage="+curPage);
		}
		
		return mv;
		
	}
	
}
