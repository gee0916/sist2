package day1110;

/**
 * @author user
 */
public class DataTypeInjection {

	private int day;
	private String msg;
	
	public DataTypeInjection(String msg) {
		this.msg=msg;
		System.out.println("���ڿ� ������ ���Թ޴� ������");
	}//DataTypeInjection
	
	public DataTypeInjection(int day) {
		this.day=day;
		System.out.println("������ ������ ���Թ޴� ������");
	}

	public int getDay() {
		return day;
	}

	public String getMsg() {
		return msg;
	}
	
}//class
