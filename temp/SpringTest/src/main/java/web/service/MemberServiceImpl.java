package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired MemberDao memberDao;
	
	@Override
	public List getMembers() {
		return memberDao.selectAll();
	}

}
