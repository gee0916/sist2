package day1110;

/**
 * 생성자 의존성 주입
 * @author user
 */
public class ProductService {

	private ProductDAO pDAO;
	
	/**
	 * <constructor-arg ref="아이디"/>
	 * @param pDAO
	 */
	public ProductService(ProductDAO pDAO) {
		this.pDAO=pDAO;
		System.out.println("ProductService의 생성자 의존성 주입");
	}//ProductService

	public ProductDAO getpDAO() {
		return pDAO;
	}
	
	
}//class
