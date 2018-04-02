package countUp;

public class CntService {
	
	void plusCount() {
		CntDao dao = new CntDao();
		CntVo vo = dao.getCount();
		vo.setCnt(vo.getCnt()+1);
		dao.setCount(vo);
	}

}
