package fruit.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Fruit {
	/*
	 * Correspond to the user table
	 */
	private Integer product_id;
	private String fruit_name;
	private double fruit_price;
	private Integer fruit_quantity;
	private String fruit_picture;
	
	
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
	 * @return the fruitName
	 */
	public String getFruitName() {
		return fruit_name;
	}


	/**
	 * @param fruitName the fruitName to set
	 */
	public void setFruitName(String fruitName) {
		this.fruit_name = fruitName;
	}

	/**
	 * @return the fruitPrice
	 */
	public double getFruitPrice() {
		return fruit_price;
	}

	/**
	 * @param fruitPrice the fruitPrice to set
	 */
	public void setFruitPrice(double  fruitPrice) {
		this.fruit_price = fruitPrice;
	}


	/**
	 * @return the fruitQuantity
	 */
	public Integer getFruitQuantity() {
		return fruit_quantity;
	}


	/**
	 * @param fruitQuantity the fruitQuantity to set
	 */
	public void setFruitQuantity(Integer fruitQuantity) {
		this.fruit_quantity = fruitQuantity;
	}


	/**
	 * @return the fruitPicture
	 */
	public String getFruitPicture() {
		return fruit_picture;
	}

	/**
	 * @param fruitPicture the fruitPicture to set
	 */
	public void setFruitPicture(String fruitPicture) {
		this.fruit_picture = fruitPicture;
	}

}
