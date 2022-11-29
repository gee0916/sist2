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
		//1. JNDI ��밴ü ����
		//2. DataSource���
		//3. Connection ���
			con=dd.getConn("jdbc/hyunji");
		//4. ������ ������ü ���
			String selectMaker="select maker from car_country where country=?";
			pstmt=con.prepareStatement(selectMaker);
		//5. ���ε庯���� �� ����
			pstmt.setString(1, country);
		//6. ������ ����
			rs=pstmt.executeQuery();
			
			MakerDomain md=null;
			
			while(rs.next()) {
				md=new MakerDomain(rs.getString("maker"));
				list.add(md);
			}//end while
			
		}catch(NamingException ne) {
			ne.printStackTrace();
		} finally {
		//7. �������
			if(rs!=null) {rs.close();} //end if
			if(pstmt!=null) {pstmt.close();} //end if
			if(con!=null) {con.close();} //end if
		}
		
		return list;
	}//selectMaker
	
	/**
	 * �����縦 �Է¹޾� �𵨸��� ��ȸ�ϴ� ��
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
		//1. JNDI ��밴ü ����
		//2. DataSource���
		//3. Connection ���
			con=dd.getConn("jdbc/hyunji");
		//4. ������ ������ü ���
			String selectModel="select model from car_maker where maker=?";
			pstmt=con.prepareStatement(selectModel);
		//5. ���ε庯���� �� ����
			pstmt.setString(1, maker);
		//6. ������ ����
			rs=pstmt.executeQuery();
			
			ModelDomain md=null;
			
			while(rs.next()) {
				md=new ModelDomain(rs.getString("model"));
				list.add(md);
			}//end while
			
		}catch(NamingException ne) {
			ne.printStackTrace();
		} finally {
		//7. �������
			if(rs!=null) {rs.close();} //end if
			if(pstmt!=null) {pstmt.close();} //end if
			if(con!=null) {con.close();} //end if
		}
		
		return list;
	}//selectMaker
	
}//class
