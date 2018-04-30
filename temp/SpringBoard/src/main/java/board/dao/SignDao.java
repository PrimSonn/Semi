package board.dao;

import board.dto.User;

public interface SignDao {
	
	public User in(User user);
	public void up(User user);
	public User selectAccountById(User user);

}
