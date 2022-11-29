package day1108.run;

import day1108.dao.MySQLDAO;
import day1108.dao.OracleDAO;
import day1108.service.Service;
import day1108.service.ServiceImpl;

/**
 * ��ü���� ���踦 ��ü�ܺο��� �����ϰ�, ��ȯ�ϱ� ���� ����� Ŭ����.
 * (������ Ŭ���� - �ʿ��� ��ü���� �����ϴ� ��)
 * ������ ���� - ���������� ó���ϱ� ���ؼ��� �ݵ�� DB�� ����ؾ��Ѵ�.
 * => ������ DB�� �������� �ֽ��ϴ�.
 * �����(loosely coupled): ������������ ���� �ϴ� ��.
 * @author user
 */
public class Assembly {

	public Service getBean() {
		//ServiceImp�� OracleDAO�� ������ ����
		//1. ������ ������ ��ü�� ����
		//OracleDAO od=new OracleDAO();
		
		MySQLDAO md=new MySQLDAO();
		
		//2. ������ ���Թ��� ��ü�� �����ϸ鼭 ������ ���� ����
		ServiceImpl si=new ServiceImpl(md); //����������: �����
		
		//3. ������ ���Թ��� ��ü(bean)�� ��ȯ
		return si;
		
	}//getBean
	
}//class
