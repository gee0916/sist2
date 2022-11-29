package day1108.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * 구현 클래스가 반드시 구현해야한느 DB작업의 목록만 정의
 * @author user
 */
public interface DAO {

	public List<String> selectNames() throws SQLException;
	
	
}
