package board.dao;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardDao {
	public List<Board> selectAll();
	public List<Board> getPagingList(Paging paging);
	public int getTotal();
	public void write(Board board);
}
