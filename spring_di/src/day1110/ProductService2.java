package day1110;

/**
 * method 의존성주입
 * @author user
 */
public class ProductService2 {

	private ProductDAO pDAO;
	
	public ProductService2() {//이렇게 되면 기본생성자
		System.out.println("ProductService의 기본생성자");
	}//ProductService

	public ProductDAO getpDAO() {
		return pDAO;
	}

	/**
	 * method 의존성 주입 <br>
	 * <property name="set을 제외한 method명" ref="의존성주입할 아이디"/>
	 * @param pDAO
	 */
	public void setpDAO(ProductDAO pDAO) {
		this.pDAO = pDAO;
		System.out.println("method 의존성 주입");
	}
	
	

}//class
