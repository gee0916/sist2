package kr.co.sist.vo;

public class ProductVO {

	private int prdNum, price;
	private String prdName, img;
	
	public ProductVO() {
		super();
	}
	public ProductVO(int prdNum, int price, String prdName, String img) {
		super();
		this.prdNum = prdNum;
		this.price = price;
		this.prdName = prdName;
		this.img = img;
	}
	public int getPrdNum() {
		return prdNum;
	}
	public void setPrdNum(int prdNum) {
		this.prdNum = prdNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "ProductVO [prdNum=" + prdNum + ", price=" + price + ", prdName=" + prdName + ", img=" + img + "]";
	}

}
