package day1108.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAO implements DAO {
	
	public MySQLDAO() {
		System.out.println("MySQLDAO ����");
	}

	/** 
	 * ��: MySQL DBMS�� �����ϱ����� �ۼ��� �������� ����� �̸� ��ȸ
	 */
	@Override
	public List<String> selectNames() throws SQLException {
		List<String> list=new ArrayList<String>();
		
		list.add("������");
		list.add("�ۼ���");
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("ȫ�ƶ�");
		
		return list;
	}

}

