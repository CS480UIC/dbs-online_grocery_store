package shopping_cart.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class ShoppingCart {
	/*
	 * Correspond to the user table
	 */
	private Integer product_id;
	private double product_price;
	private Integer quantity;
	private String username;
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
	 * @return the product_price
	 */
	public double getProduct_price() {
		return product_price;
	}
	/**
	 * @param product_price the product_price to set
	 */
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
