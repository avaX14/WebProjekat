package model;

public class Rating {
	
	private Integer positive;
	private Integer negative;
	
	public Rating(){
		
	}

	public Rating(Integer positive, Integer negative) {
		super();
		this.positive = positive;
		this.negative = negative;
	}

	public Integer getPositive() {
		return positive;
	}

	public void setPositive(Integer positive) {
		this.positive = positive;
	}

	public Integer getNegative() {
		return negative;
	}

	public void setNegative(Integer negative) {
		this.negative = negative;
	}


	
	
}
