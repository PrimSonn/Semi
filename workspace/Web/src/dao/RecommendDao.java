package dao;

import java.util.List;
import dto.Recommend;

public interface RecommendDao {
	public int getTotal();
	public boolean check(Recommend r);
	public void insert(Recommend r);
	public void delete(Recommend r);
	public List getIds();
}
