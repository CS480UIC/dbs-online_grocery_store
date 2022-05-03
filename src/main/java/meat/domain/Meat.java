package meat.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Meat {
	/*
	 * Correspond to the user table
	 */
	private Integer product_id;
	private String meat_name;
	private double meat_price;
	private Integer meat_quantity;
	private String meat_picture;
	/**
	 * @return the product_id
	 */
	public Integer getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the meat_name
	 */
	public String getMeatName() {
		return meat_name;
	}
	/**
	 * @param meat_name the meat_name to set
	 */
	public void setMeatName(String meat_name) {
		this.meat_name = meat_name;
	}
	/**
	 * @return the meat_price
	 */
	public double getMeatPrice() {
		return meat_price;
	}
	/**
	 * @param meat_price the meat_price to set
	 */
	public void setMeatPrice(double meat_price) {
		this.meat_price = meat_price;
	}
	/**
	 * @return the meat_quantity
	 */
	public Integer getMeatQuantity() {
		return meat_quantity;
	}
	/**
	 * @param meat_quantity the meat_quantity to set
	 */
	public void setMeatQuantity(Integer meat_quantity) {
		this.meat_quantity = meat_quantity;
	}
	/**
	 * @return the meat_picture
	 */
	public String getMeatPicture() {
		return meat_picture;
	}
	/**
	 * @param meat_picture the meat_picture to set
	 */
	public void setMeatPicture(String meat_picture) {
		this.meat_picture = meat_picture;
	}
	
	
	

}
