package web.dao;

import java.util.List;

import web.dto.Member;

public interface MemberDao {
	public List selectAll();
	public void insert(Member m);
	public void delete(Member m);
	public void update(Member m);
	public Member select(Member m);
}