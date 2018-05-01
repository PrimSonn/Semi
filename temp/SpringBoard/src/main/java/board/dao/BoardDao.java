package board.dao;

import java.util.List;

import board.dto.Board;
import board.dto.Comment;
import board.util.Paging;

public interface BoardDao {
	
	public List<Board> selectAll();
	public List<Board> getPagingList(Paging paging);
	public int getTotal ();
	public void write (Board board);
	public Board viewContent (Board board);
	public void hitUp (Board board);
	public void delete(Board board);
	public void edit (Board board);
	public Board recommendCheck (Board board);
	public void doRecommend (Board board);
	public void upRecommendCount (Board board);
	public void undoRecommend(Board board);
	public void downRecommendCount(Board board);
	public int getSearchTotal(Board board);
	public List<Board> searchTitle(Paging paging);
	public void writeComment(Comment comment);
	public List<Comment> listComment(Paging paging);
	public Integer checkComment(Comment comment);
	public Integer totalComment(int boardNo);
	public void deleteComment(Comment comment);
	public void deleteBoardList(Board board);
}
