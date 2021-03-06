package web.service;

import java.util.List;

import web.dto.Member;

public interface MemberService {
	public List getMembers();
	public void insertMember(Member m);
	public void delete(Member m);
	public void update(Member m);
	public Member select(Member m);
}
