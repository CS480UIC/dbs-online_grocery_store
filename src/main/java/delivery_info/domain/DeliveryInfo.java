package delivery_info.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class DeliveryInfo {
	/*
	 * Correspond to the user table
	 */
	private Integer driver_id;
	private String username;
	private String vehicle_type;
	private String driver_proximity;
	/**
	 * @return the driver_id
	 */
	public Integer getDriver_id() {
		return driver_id;
	}
	/**
	 * @param driver_id the driver_id to set
	 */
	public void setDriver_id(Integer driver_id) {
		this.driver_id = driver_id;
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
	/**
	 * @return the vehicle_type
	 */
	public String getVehicle_type() {
		return vehicle_type;
	}
	/**
	 * @param vehicle_type the vehicle_type to set
	 */
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	/**
	 * @return the driver_proximity
	 */
	public String getDriver_proximity() {
		return driver_proximity;
	}
	/**
	 * @param driver_proximity the driver_proximity to set
	 */
	public void setDriver_proximity(String driver_proximity) {
		this.driver_proximity = driver_proximity;
	}
	
}
