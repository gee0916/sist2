package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.ProductVO;

/**
 * business logic ó��
 * @author user
 *
 */
public class TestService {
	
	public List<ProductVO> companyList() {
		List<ProductVO> list=new ArrayList<ProductVO>();
		
		list.add(new ProductVO(1, 51600, "īī��", "daum.png"));
		list.add(new ProductVO(2, 1735000, "���̹�", "naver.png"));
		list.add(new ProductVO(3, 775, "�ֿ��������", "sist.png"));
		list.add(new ProductVO(4, 128349, "����", "error_temp.jpg"));
		
		return list;
	}
}
