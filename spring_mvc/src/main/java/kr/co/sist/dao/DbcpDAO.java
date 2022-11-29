package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * DBCP를 사용한 DAO
 * @author user
 *
 */
public class DbcpDAO {
	
	private static DbcpDAO dDAO;
	
	public DbcpDAO() {
	}
	
	public static DbcpDAO getInstance() {
		if(dDAO==null) {
			dDAO=new DbcpDAO();
		}//end if
		return dDAO;
	}//getInstance
	
	/**
	 * 입력된 Naming으로 DBCP를 찾아 Connection을 얻는 일
	 * @param dbcpName server.xml에 설정된 Resource의 name 속성명
	 * @return 연결된 Connection
	 * @throws NamingException
	 * @throws SQLException
	 */
	public Connection getConn(String dbcpName)throws NamingException, SQLException {
		Connection con=null;
		
		//1. JNDI 사용객체 생성
		Context ctx=new InitialContext();
		
		//2. DBCP를 찾고 DataSource얻기
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/"+dbcpName);
		
		//3. DataSource로 부터 Connection 얻기
		con=ds.getConnection();
		
		return con;
	}//getConn
	
}
