package fruit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import fruit.domain.Fruit;
import fruit.domain.FruitOrder;
import fruit.domain.FruitStock;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class FruitDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "online_grocery_store"; //TODO change user
	
	/**     
	 * 
	 * 
	 * 
	 * 
	 * 
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "databased"; //TODO change password

	public Fruit findByProductID(Integer productID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Fruit fruit = new Fruit();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
		    String sql = "select * from fruit where product_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,productID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("product_id"));
		  
		    	if(id.equals(productID)){
		    	
		    		fruit.setProduct_id(id);
		    		fruit.setFruit_name(resultSet.getString("fruit_name"));
		    		fruit.setFruit_price(Double.parseDouble(resultSet.getString("fruit_price")));
		    		fruit.setFruit_quantity(Integer.parseInt(resultSet.getString("fruit_quantity")));
		    		fruit.setFruit_picture(resultSet.getString("fruit_picture"));
		    	}
		  
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return fruit;
	}	
	
	/**
	 * insert Entity1       
	 * @param form
	 * @throws ClassNotFoundException  
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Fruit form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "insert into fruit (product_id, fruit_name, fruit_price, fruit_quantity, fruit_picture) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getProduct_id());
		    preparestatement.setString(2,form.getFruit_name());
		    preparestatement.setDouble(3,form.getFruit_price());
		    preparestatement.setInt(4,form.getFruit_quantity());
		    preparestatement.setString(5,form.getFruit_picture());
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
	public void update(Fruit form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "UPDATE fruit SET  fruit_name = ?, fruit_price = ?, fruit_quantity = ?, fruit_picture = ? where product_id =?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    
			preparestatement.setString(1,form.getFruit_name());
		    preparestatement.setDouble(2,form.getFruit_price());
		    preparestatement.setInt(3,form.getFruit_quantity());
		    preparestatement.setString(4,form.getFruit_picture());
		    preparestatement.setInt(5,form.getProduct_id());
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
			System.out.print(product_id_p);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "delete from fruit where product_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,product_id_p);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findFruits() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM fruits_stock";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				FruitStock fruit = new FruitStock();
				fruit.setName(resultSet.getString("name"));
				fruit.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
	    		list.add(fruit);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

		public List<Object> findFruitOrders() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM fruit_orders";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				FruitOrder fruit = new FruitOrder();
				fruit.setUser(resultSet.getString("user"));
				fruit.setFruit_name(resultSet.getString("fruit"));
				fruit.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
	    		list.add(fruit);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

		public List<Object> findExpensiveFruits() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM average_price";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Fruit fruit = new Fruit();
				fruit.setProduct_id(Integer.parseInt(resultSet.getString("id")));
				fruit.setFruit_name(resultSet.getString("fruit"));
				fruit.setFruit_price(Double.parseDouble(resultSet.getString("price")));
	    		list.add(fruit);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
