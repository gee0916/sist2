package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import kr.co.sist.domain.MakerDomain;
import kr.co.sist.domain.ModelDomain;

@Component
public class AJAXDao {

	public List<MakerDomain> selectMaker(String country) throws SQLException {
		List<MakerDomain> list=new ArrayList<MakerDomain>();
		
		DbcpDAO dd=DbcpDAO.getInstance();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
		//1. JNDI 사용객체 생성
		//2. DataSource얻기
		//3. Connection 얻기
			con=dd.getConn("jdbc/hyunji");
		//4. 쿼리문 생성객체 얻기
			String selectMaker="select maker from car_country where country=?";
			pstmt=con.prepareStatement(selectMaker);
		//5. 바인드변수에 값 설정
			pstmt.setString(1, country);
		//6. 쿼리문 실행
			rs=pstmt.executeQuery();
			
			MakerDomain md=null;
			
			while(rs.next()) {
				md=new MakerDomain(rs.getString("maker"));
				list.add(md);
			}//end while
			
		}catch(NamingException ne) {
			ne.printStackTrace();
		} finally {
		//7. 연결끊기
			if(rs!=null) {rs.close();} //end if
			if(pstmt!=null) {pstmt.close();} //end if
			if(con!=null) {con.close();} //end if
		}
		
		return list;
	}//selectMaker
	
	/**
	 * 제조사를 입력받아 모델명을 조회하는 일
	 * @param maker
	 * @return
	 * @throws SQLException
	 */
	public List<ModelDomain> selectModel(String maker) throws SQLException {
		List<ModelDomain> list=new ArrayList<ModelDomain>();
		
		DbcpDAO dd=DbcpDAO.getInstance();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
		//1. JNDI 사용객체 생성
		//2. DataSource얻기
		//3. Connection 얻기
			con=dd.getConn("jdbc/hyunji");
		//4. 쿼리문 생성객체 얻기
			String selectModel="select model from car_maker where maker=?";
			pstmt=con.prepareStatement(selectModel);
		//5. 바인드변수에 값 설정
			pstmt.setString(1, maker);
		//6. 쿼리문 실행
			rs=pstmt.executeQuery();
			
			ModelDomain md=null;
			
			while(rs.next()) {
				md=new ModelDomain(rs.getString("model"));
				list.add(md);
			}//end while
			
		}catch(NamingException ne) {
			ne.printStackTrace();
		} finally {
		//7. 연결끊기
			if(rs!=null) {rs.close();} //end if
			if(pstmt!=null) {pstmt.close();} //end if
			if(con!=null) {con.close();} //end if
		}
		
		return list;
	}//selectMaker
	
}//class
