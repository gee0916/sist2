package day1110;

/**
 * @author user
 */
public class DataTypeInjection {

	private int day;
	private String msg;
	
	public DataTypeInjection(String msg) {
		this.msg=msg;
		System.out.println("문자열 의존성 주입받는 생성자");
	}//DataTypeInjection
	
	public DataTypeInjection(int day) {
		this.day=day;
		System.out.println("정수를 의존성 주입받는 생성자");
	}

	public int getDay() {
		return day;
	}

	public String getMsg() {
		return msg;
	}
	
}//class
