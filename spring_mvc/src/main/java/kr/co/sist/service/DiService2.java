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
		
		try { //의존성 주입받은 aDAO사용.
			list=aDAO.selectMaker("국산");
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
	}//searchMaker
	
}//class
