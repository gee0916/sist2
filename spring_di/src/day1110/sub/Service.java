package day1110.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ������ ���Թ��� Ŭ����
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
