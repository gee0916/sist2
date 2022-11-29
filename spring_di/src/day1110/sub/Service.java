package day1110.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 의존성 주입받을 클래스
 * @author user
 */
@Component
public class Service {

	@Autowired
	private DAO dao;

	public DAO getDao() {
		return dao;
	}
	
}
