package kr.co.sist.vo;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestParam;

public class MemberVO {
	private String id, pass, birth, email1, email2, emailFlag, gender;
	private String[] lang;
	private int age;
	
	public MemberVO() {
		System.out.println("MemberVO 기본생성자");
	}

	public MemberVO(String id, String pass, String birth, String email1, String email2, String emailFlag, String gender,
			String[] lang, int age) {
		System.out.println("MemberVO 매개변수 있는 생성자");
		this.id = id;
		this.pass = pass;
		this.birth = birth;
		this.email1 = email1;
		this.email2 = email2;
		this.emailFlag = emailFlag;
		this.gender = gender;
		this.lang = lang;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmailFlag() {
		return emailFlag;
	}

	public void setEmailFlag(String emailFlag) {
		this.emailFlag = emailFlag;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getLang() {
		return lang;
	}

	public void setLang(@RequestParam(required=false,defaultValue="0") String[] lang) {
		this.lang = lang;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", birth=" + birth + ", email1=" + email1 + ", email2="
				+ email2 + ", emailFlag=" + emailFlag + ", gender=" + gender + ", lang=" + Arrays.toString(lang)
				+ ", age=" + age + "]";
	}

	
}
