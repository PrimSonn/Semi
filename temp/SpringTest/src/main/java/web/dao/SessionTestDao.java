package web.dao;

import web.dto.SessionTestMember;

public interface SessionTestDao {
	
	public void join(SessionTestMember m);
	public SessionTestMember pick(SessionTestMember m);
	public int checkId (SessionTestMember m);
	public SessionTestMember pickById(String id);

}
