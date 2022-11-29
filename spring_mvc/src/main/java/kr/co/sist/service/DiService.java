package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.AJAXDao;
import kr.co.sist.domain.MakerDomain;

public class DiService {

	private AJAXDao aDAO;
	
	public DiService(AJAXDao aDAO) {
		this.aDAO=aDAO;
	}//DiService
	
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
