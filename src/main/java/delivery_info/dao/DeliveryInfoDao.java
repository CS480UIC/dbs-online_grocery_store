package delivery_info.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import delivery_info.domain.DeliveryInfo;

/**
 * DDL functions performed in database
 */
public class DeliveryInfoDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "store"; //TODO change user
	
	/**     
	 * 
	 * 
	 * 
	 * 
	 * 
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password"; //TODO change password

	public DeliveryInfo findByDriverID(Integer driverID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		DeliveryInfo deliveryInfo = new DeliveryInfo();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
		    String sql = "select * from delivery_info where driver_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,driverID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("driver_id"));
		    	if(id == driverID){
		    		deliveryInfo.setDriver_id(id);
		    		deliveryInfo.setUsername(resultSet.getString("username"));
		    		deliveryInfo.setDriver_proximity(resultSet.getString("driver_proximity"));
		    		deliveryInfo.setVehicle_type(resultSet.getString("vehicle_type"));
		  
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return deliveryInfo;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException  
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(DeliveryInfo form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "insert into delivery_info (driver_id, username, driver_proximity, vehicle_type) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getDriver_id());
		    preparestatement.setString(2,form.getUsername());
		    preparestatement.setString(3,form.getDriver_proximity());
		    preparestatement.setString(4,form.getVehicle_type());
		
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(DeliveryInfo form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "UPDATE delivery_info SET driver_id = ?, username = ?, driver_proximity = ?, vehicle_type = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getDriver_id());
			preparestatement.setString(2,form.getUsername());
		    preparestatement.setString(3,form.getDriver_proximity());
		    preparestatement.setString(4,form.getVehicle_type());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String driver_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "delete from delivery_info where driver_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(driver_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
