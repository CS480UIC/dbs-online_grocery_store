package vegetable.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Vegetable {
	/*
	 * Correspond to the user table
	 */
	private Integer product_id;
	private String veg_name;
	private double veg_price;
	private Integer veg_quantity;
	private String veg_picture;
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
	 * @return the veg_name
	 */
	public String getVegName() {
		return veg_name;
	}
	/**
	 * @param veg_name the veg_name to set
	 */
	public void setVegName(String veg_name) {
		this.veg_name = veg_name;
	}
	/**
	 * @return the veg_price
	 */
	public double getVegPrice() {
		return veg_price;
	}
	/**
	 * @param veg_price the veg_price to set
	 */
	public void setVegPrice(double veg_price) {
		this.veg_price = veg_price;
	}
	/**
	 * @return the veg_quantity
	 */
	public Integer getVegQuantity() {
		return veg_quantity;
	}
	/**
	 * @param veg_quantity the veg_quantity to set
	 */
	public void setVegQuantity(Integer veg_quantity) {
		this.veg_quantity = veg_quantity;
	}
	/**
	 * @return the veg_picture
	 */
	public String getVegPicture() {
		return veg_picture;
	}
	/**
	 * @param veg_picture the veg_picture to set
	 */
	public void setVegPicture(String veg_picture) {
		this.veg_picture = veg_picture;
	}
	
	
}
