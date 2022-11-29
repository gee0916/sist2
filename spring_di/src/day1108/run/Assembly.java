package day1108.run;

import day1108.dao.MySQLDAO;
import day1108.dao.OracleDAO;
import day1108.service.Service;
import day1108.service.ServiceImpl;

/**
 * 객체간의 관계를 객체외부에서 설정하고, 반환하기 위해 만드는 클래스.
 * (조립자 클래스 - 필요한 객체들을 조립하는 일)
 * 의존성 주입 - 업무로직을 처리하기 위해서는 반드시 DB를 사용해야한다.
 * => 업무는 DB에 의존성이 있습니다.
 * 약결합(loosely coupled): 의존성주입을 쉽게 하는 것.
 * @author user
 */
public class Assembly {

	public Service getBean() {
		//ServiceImp에 OracleDAO를 의존성 주입
		//1. 의존성 주입할 객체를 생성
		//OracleDAO od=new OracleDAO();
		
		MySQLDAO md=new MySQLDAO();
		
		//2. 의존성 주입받을 객체를 생성하면서 의존성 주입 수행
		ServiceImpl si=new ServiceImpl(md); //의존성주입: 약결합
		
		//3. 의존성 주입받은 객체(bean)를 반환
		return si;
		
	}//getBean
	
}//class
