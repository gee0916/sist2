package day1108.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleDAO implements DAO {
	
	public OracleDAO() {
		System.out.println("OracleDAO");
	}

	/**
	 * 예: Oracle 쿼리문을 사용한 이름 조회
	 */
	@Override
	public List<String> selectNames() throws SQLException {
		List<String> list=new ArrayList<String>();
		
		list.add("차차");
		list.add("추추");
		list.add("초초");
		list.add("치치");
		
		return list;
	}

}