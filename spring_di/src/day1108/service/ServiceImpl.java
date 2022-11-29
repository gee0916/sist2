package day1108.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day1108.dao.DAO;

/**
 * ���������� ������ Ŭ����
 * �����ʹ� DBMS�������� �����ͼ� �̸��� "��"�� �ٿ��� ��ȯ
 * @author user
 */
public class ServiceImpl implements Service {

	private DAO dao; // �θ� �����ϸ� ��� �ڽ��� ���� �� �ִ�.
	
	/**
	 * �� �����ڴ� DAO�� ��� �ڽ��� ���� �� �ִ�.
	 * @param dao
	 */
	public ServiceImpl(DAO dao) {
		System.out.println("ServiceImpl ������ ���Թ޴� ������");
		this.dao=dao; //�Է¹��� DAO�� �ڽ��� field�� �ø����� Ŭ�����ȿ��� ����� �� �ִ�
	}
	
	@Override
	public List<String> searchNames() {
		//OracleDAO dao=new OracleDAO();
		//����ҷ��� ��ü�ڵ�ȿ��� ���� ��üȭ�ϴ� ���� ������(strongly coupled)�̶�� �Ѵ�.
		
		List<String> listName=new ArrayList<String>();
		
		try {
			for(int i=0; i<dao.selectNames().size(); i++) {
				listName.add(dao.selectNames().get(i)+"��"); //LinkedList�� �ſ� ������ �۾�
			}//end for
			dao.selectNames().clear();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return listName;
	}//searchNames

}//class
