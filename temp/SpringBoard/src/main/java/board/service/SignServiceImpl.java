package board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.SignDao;
import board.dto.User;

@Service
public class SignServiceImpl implements SignService{
	
	@Autowired SignDao signDao;
	
	@Override
	public void up(User user) {
		signDao.up(user);
	}

	@Override
	public User in(User user) {
		
		return signDao.in(user);
	}

	@Override
	public User selectAccountById(User user) {
		return signDao.selectAccountById(user);
	}
}
