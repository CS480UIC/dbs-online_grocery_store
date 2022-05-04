package history.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class History {
	/*
	 * Correspond to the user table
	 */
	private Integer order_id;
	private Integer items;
	private String order_date;
	private String username;
	/**
	 * @return the order_id
	 */
	public Integer getOrder_id() {
		return order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	/**
	 * @return the items
	 */
	public Integer getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(Integer items) {
		this.items = items;
	}
	/**
	 * @return the order_date
	 */
	public String getOrder_date() {
		return order_date;
	}
	/**
	 * @param order_date the order_date to set
	 */
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
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
