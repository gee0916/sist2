package day1110;

/**
 * method ����������
 * @author user
 */
public class ProductService2 {

	private ProductDAO pDAO;
	
	public ProductService2() {//�̷��� �Ǹ� �⺻������
		System.out.println("ProductService�� �⺻������");
	}//ProductService

	public ProductDAO getpDAO() {
		return pDAO;
	}

	/**
	 * method ������ ���� <br>
	 * <property name="set�� ������ method��" ref="������������ ���̵�"/>
	 * @param pDAO
	 */
	public void setpDAO(ProductDAO pDAO) {
		this.pDAO = pDAO;
		System.out.println("method ������ ����");
	}
	
	

}//class
