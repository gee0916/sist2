package day1108.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day1108.dao.DAO;

/**
 * 업무로직을 구현한 클래스
 * 데이터는 DBMS에서부터 가져와서 이름에 "님"을 붙여서 반환
 * @author user
 */
public class ServiceImpl implements Service {

	private DAO dao; // 부모를 선언하면 모든 자식을 받을 수 있다.
	
	/**
	 * 이 생성자는 DAO의 모든 자식을 받을 수 있다.
	 * @param dao
	 */
	public ServiceImpl(DAO dao) {
		System.out.println("ServiceImpl 의존성 주입받는 생성자");
		this.dao=dao; //입력받은 DAO의 자식을 field에 올림으로 클래스안에서 사용할 수 있다
	}
	
	@Override
	public List<String> searchNames() {
		//OracleDAO dao=new OracleDAO();
		//사용할려는 객체코드안에서 직접 객체화하는 것을 강결합(strongly coupled)이라고 한다.
		
		List<String> listName=new ArrayList<String>();
		
		try {
			for(int i=0; i<dao.selectNames().size(); i++) {
				listName.add(dao.selectNames().get(i)+"님"); //LinkedList에 매우 적합한 작업
			}//end for
			dao.selectNames().clear();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return listName;
	}//searchNames

}//class
