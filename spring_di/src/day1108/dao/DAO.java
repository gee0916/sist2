package day1108.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * ���� Ŭ������ �ݵ�� �����ؾ��Ѵ� DB�۾��� ��ϸ� ����
 * @author user
 */
public interface DAO {

	public List<String> selectNames() throws SQLException;
	
	
}
