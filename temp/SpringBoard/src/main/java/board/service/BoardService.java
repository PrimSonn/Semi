package board.service;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardService {
	public List<Board> getList();
	public List<Board> getPagingList(Paging paging);
	public int getTotal();
	public void write(Board board);
}
