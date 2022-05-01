package vegetable.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import vegetable.domain.Vegetable;

/**
 * DDL functions performed in database
 */
public class VegetableDao {
	
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

	public Vegetable findByProductID(Integer productID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Vegetable vegetable = new Vegetable();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
		    String sql = "select * from vegetable where product_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,productID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("product_id"));
		    	if(id == productID){
		    		vegetable.setProduct_id(id);
		    		vegetable.setVegName(resultSet.getString("veg_name"));
		    		vegetable.setVegPrice(Double.parseDouble(resultSet.getString("veg_price")));
		    		vegetable.setVegQuantity(Integer.parseInt(resultSet.getString("veg_quantity")));
		    		vegetable.setVegPicture(resultSet.getString("veg_picture"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return vegetable;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException  
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Vegetable form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "insert into vegetable (product_id, veg_name, veg_price, veg_quantity, veg_picture) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getProduct_id());
		    preparestatement.setString(2,form.getVegName());
		    preparestatement.setDouble(3,form.getVegPrice());
		    preparestatement.setInt(4,form.getVegQuantity());
		    preparestatement.setString(5,form.getVegPicture());
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
	public void update(Vegetable form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "UPDATE vegetable SET product_id = ?, veg_name = ?, veg_price = ?, veg_quantity = ?, veg_picture = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getProduct_id());
			preparestatement.setString(2,form.getVegName());
		    preparestatement.setDouble(3,form.getVegPrice());
		    preparestatement.setInt(4,form.getVegQuantity());
		    preparestatement.setString(5,form.getVegPicture());
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
	public void delete(String product_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "delete from vegetable where username = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(product_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
