package kr.co.sist.vo;

public class UploadVO {

	private String uploader, upfile;
	private int age;
	
	public UploadVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UploadVO(String uploader, String upfile, int age) {
		super();
		this.uploader = uploader;
		this.upfile = upfile;
		this.age = age;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getUpfile() {
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UploadVO [uploader=" + uploader + ", upfile=" + upfile + ", age=" + age + "]";
	}
	
	
	
}//class
