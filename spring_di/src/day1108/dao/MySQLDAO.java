package day1108.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAO implements DAO {
	
	public MySQLDAO() {
		System.out.println("MySQLDAO 생성");
	}

	/** 
	 * 예: MySQL DBMS를 연동하기위해 작성된 쿼리문을 사용한 이름 조회
	 */
	@Override
	public List<String> selectNames() throws SQLException {
		List<String> list=new ArrayList<String>();
		
		list.add("차승주");
		list.add("송성우");
		list.add("정주은");
		list.add("정현지");
		list.add("이유리");
		list.add("홍아람");
		
		return list;
	}

}

