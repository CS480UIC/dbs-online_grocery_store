package person.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import person.domain.Person;



/**
 * DDL functions performed in database
 */
public class PersonDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "store";  //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password";  //TODO change password
	
	/**
	 * get the Search result with Username 
	 */
	public Person findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Person person = new Person();
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
		    		person.setUsername(resultSet.getString("username"));
		    		person.setPassword(resultSet.getString("password"));
		    		person.setFirstName(resultSet.getString("first_name"));
		    		person.setLastName(resultSet.getString("last_name"));
		    		person.setEmail(resultSet.getString("email"));
		    		person.setAddress(resultSet.getString("address"));
		    		person.setCreditCardNumber(Integer.parseInt(resultSet.getString("credit_card_number")));
		    		
		    	}
		    }
		
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return person;
	}
	

	
	
	/**
	 * insert User
	 */
	public void add(Person person) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "insert into customer(username,password, first_name, last_name, email, address, credit_card_number) values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,person.getUsername());
		    preparestatement.setString(2,person.getPassword());
		 
		    preparestatement.setString(3,person.getFirstName());
		    preparestatement.setString(4,person.getLastName());
		    
		    preparestatement.setString(5,person.getEmail());
		    preparestatement.setString(6,person.getAddress());
		    preparestatement.setInt(7,person.getCreditCardNumber());
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
	public void update(Person form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "UPDATE customer SET username = ?, password = ?, first_name = ?, last_name = ?, email = ?, address = ?, credit_card_number = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getUsername());
			preparestatement.setString(2,form.getPassword());
		    preparestatement.setString(3,form.getFirstName());
		    preparestatement.setString(4,form.getLastName());
		    preparestatement.setString(5,form.getEmail());
		    preparestatement.setString(6,form.getAddress());
		    preparestatement.setInt(7,form.getCreditCardNumber());
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
	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "delete from customer where username = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}		
}
