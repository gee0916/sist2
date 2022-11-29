package kr.co.sist.domain;

public class ModelDomain {

	private String model;

	public ModelDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelDomain(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "ModelDomain [model=" + model + "]";
	}
	
}//class
