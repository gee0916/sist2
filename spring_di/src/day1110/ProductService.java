package day1110;

/**
 * ������ ������ ����
 * @author user
 */
public class ProductService {

	private ProductDAO pDAO;
	
	/**
	 * <constructor-arg ref="���̵�"/>
	 * @param pDAO
	 */
	public ProductService(ProductDAO pDAO) {
		this.pDAO=pDAO;
		System.out.println("ProductService�� ������ ������ ����");
	}//ProductService

	public ProductDAO getpDAO() {
		return pDAO;
	}
	
	
}//class
