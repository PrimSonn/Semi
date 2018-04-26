package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDao;
import board.dto.Board;
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

}
