package service;

import java.util.List;
import dto.Recommend;

public interface RecommendService {
	public int getTotal();
	public void check(Recommend user);
	public List getIDs();
}
