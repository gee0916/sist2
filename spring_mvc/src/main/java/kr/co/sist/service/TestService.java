package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.ProductVO;

/**
 * business logic 처리
 * @author user
 *
 */
public class TestService {
	
	public List<ProductVO> companyList() {
		List<ProductVO> list=new ArrayList<ProductVO>();
		
		list.add(new ProductVO(1, 51600, "카카오", "daum.png"));
		list.add(new ProductVO(2, 1735000, "네이버", "naver.png"));
		list.add(new ProductVO(3, 775, "쌍용정보통신", "sist.png"));
		list.add(new ProductVO(4, 128349, "구글", "error_temp.jpg"));
		
		return list;
	}
}
