package service;

import java.util.List;

import dao.RecommendDao;
import dao.RecommendDaoImpl;
import dto.Recommend;

public class RecommendServiceimpl implements RecommendService{
	
	private RecommendDao dao = new RecommendDaoImpl();
	
	@Override
	public int getTotal() {
		
		
		return dao.getTotal();
	}
	
	public List<Recommend> getIDs() {
		
		return dao.getIds();
		
	}
	
	@Override
	public void check(Recommend user) {
		
		if( dao.check(user) ) {
			dao.delete(user);
		}else {
			dao.insert(user);
		}
	}
	
}
