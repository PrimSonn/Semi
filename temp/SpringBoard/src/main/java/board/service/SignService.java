package board.service;

import board.dto.User;

public interface SignService {

	public void up(User user);
	public User in(User user);
	public User selectAccountById(User user);
}
