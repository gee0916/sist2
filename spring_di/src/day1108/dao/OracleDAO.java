package day1108.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleDAO implements DAO {
	
	public OracleDAO() {
		System.out.println("OracleDAO");
	}

	/**
	 * ��: Oracle �������� ����� �̸� ��ȸ
	 */
	@Override
	public List<String> selectNames() throws SQLException {
		List<String> list=new ArrayList<String>();
		
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("ġġ");
		
		return list;
	}

}