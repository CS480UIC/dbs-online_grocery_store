package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import user.domain.User;



/**
 * DDL functions performed in database
 */
public class UserDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "online_grocery_store";  //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "databased";  //TODO change password
	
	/**
	 * get the Search result with Username 
	 */
	public User findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
		    String sql = "select * from customer where username=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(username)){
		    		user.setUsername(resultSet.getString("username"));
		    		user.setPassword(resultSet.getString("password"));
		    		user.setFirstName(resultSet.getString("first_name"));
		    		user.setLastName(resultSet.getString("last_name"));
		    		user.setEmail(resultSet.getString("email"));
		    		user.setAddress(resultSet.getString("address"));
		    		user.setCreditCardNumber(Integer.parseInt(resultSet.getString("credit_card_number")));
		    		
		    	}
		    }
		
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	

	
	
	/**
	 * insert User
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "insert into customer(username,password, first_name, last_name, email, address, credit_card_number) values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		 
		    preparestatement.setString(3,user.getFirstName());
		    preparestatement.setString(4,user.getLastName());
		    
		    preparestatement.setString(5,user.getEmail());
		    preparestatement.setString(6,user.getAddress());
		    preparestatement.setInt(7,user.getCreditCardNumber());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			String sql = "select * from customer";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setUsername(resultSet.getString("username"));
	    		user.setPassword(resultSet.getString("password"));
	    		user.setEmail(resultSet.getString("email"));
	    		user.setFirstName(resultSet.getString("first_name"));
	    		user.setAddress(resultSet.getString("address"));
	    		user.setLastName(resultSet.getString("last_name"));
	    		user.setCreditCardNumber(Integer.parseInt(resultSet.getString("credit_card_number")));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
