package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.AJAXDao;
import kr.co.sist.domain.MakerDomain;

@Component
public class DiService2 {
	
	@Autowired(required = false)
	private AJAXDao aDAO;
	
	public List<MakerDomain> searchMaker() {
		List<MakerDomain> list=null;
		
		try { //������ ���Թ��� aDAO���.
			list=aDAO.selectMaker("����");
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
	}//searchMaker
	
}//class
