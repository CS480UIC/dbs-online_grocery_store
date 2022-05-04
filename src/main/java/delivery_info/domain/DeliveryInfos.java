package delivery_info.domain;

public class DeliveryInfos {
	
	private Integer driver_id;
	private String username;
	private String vehicle_type;
	private String driver_proximity;
	
	public Integer getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(Integer driver_id) {
		this.driver_id = driver_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getDriver_proximity() {
		return driver_proximity;
	}
	public void setDriver_proximity(String driver_proximity) {
		this.driver_proximity = driver_proximity;
	}
	
	
	
}
