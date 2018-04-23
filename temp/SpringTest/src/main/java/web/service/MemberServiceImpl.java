package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.MemberDao;
import web.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired MemberDao memberDao;
	
	@Override
	public List getMembers() {
		return memberDao.selectAll();
	}

	@Override
	public void insertMember(Member m) {
		memberDao.insert(m);
	}

	@Override
	public void delete(Member m) {
		memberDao.delete(m);
	}

	@Override
	public void update(Member m) {
		memberDao.update(m);
	}

	@Override
	public Member select(Member m) {
		return memberDao.select(m);
	}
	

}
