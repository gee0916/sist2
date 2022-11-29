package kr.co.sist.domain;

public class MakerDomain {

	private String maker;

	public MakerDomain() {
		super();
	}

	public MakerDomain(String maker) {
		super();
		this.maker = maker;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String toString() {
		return "MakerDomain [maker=" + maker + "]";
	}
	
}//class
