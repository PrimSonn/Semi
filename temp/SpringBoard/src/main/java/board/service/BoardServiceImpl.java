package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDao;
import board.dto.Board;
import board.dto.Comment;
import board.util.Paging;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired BoardDao boardDao;
	
	@Override
	public List<Board> getList() {
		return boardDao.selectAll();
	}

	@Override
	public List<Board> getPagingList(Paging paging) {
		return boardDao.getPagingList(paging);
	}

	@Override
	public int getTotal() {
		return boardDao.getTotal();
	}

	@Override
	public void write(Board board) {
		
		boardDao.write(board);
	}

	@Override
	public Board viewContent(Board board) {
		
		Board newBoard = boardDao.viewContent(board);
		boardDao.hitUp(board);
		
		return newBoard;
	}

	@Override
	public void delete(Board board) {
		boardDao.delete(board);
	}

	@Override
	public void edit(Board board) {
		
		boardDao.edit(board);
	}

	@Override
	public Board recommendCheck(Board board) {
		return boardDao.recommendCheck(board);
	}

	@Override
	public void doRecommend(Board board) {
		boardDao.doRecommend(board);
		boardDao.upRecommendCount(board);
	}

	@Override
	public void undoRecommend(Board board) {
		boardDao.undoRecommend(board);
		boardDao.downRecommendCount(board);
	}

	@Override
	public int getSearchTotal(Board board) {
		return boardDao.getSearchTotal(board);
	}

	@Override
	public List<Board> searchTitle(Paging paging) {
		return boardDao.searchTitle(paging);
	}

	@Override
	public void writeComment(Comment comment) {
		boardDao.writeComment(comment);
	}

	@Override
	public List<Comment> listComment(Paging paging) {
		return boardDao.listComment(paging);
	}

	@Override
	public boolean checkComment(Comment comment) {
		return !(boardDao.checkComment(comment)==0) ;
	}

	@Override
	public Integer totalComment(int boardNo) {
		return boardDao.totalComment(boardNo);
	}

	@Override
	public void deleteComment(Comment comment) {
		boardDao.deleteComment(comment);
	}

	@Override
	public void deleteBoardList(Board board) {
		boardDao.deleteBoardList(board);
	}

}
