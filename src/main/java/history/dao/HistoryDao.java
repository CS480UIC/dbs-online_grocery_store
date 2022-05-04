package history.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import history.domain.History;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class HistoryDao {
	
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

	public History findByOrderID(Integer orderID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		History history = new History();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
		    String sql = "select * from history where order_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,orderID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("order_id"));
		    	if(id == orderID){
		    		history.setOrder_id(id);
		    		history.setUsername(resultSet.getString("username"));
		    		history.setItems(Integer.parseInt(resultSet.getString("items")));
		    		history.setOrder_date(resultSet.getString("order_date"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return history;
	}	
	
	/**
	 * insert Entity1       
	 * @param form
	 * @throws ClassNotFoundException  
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(History form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "insert into history (order_id, items, order_date, username) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getOrder_id());
		    preparestatement.setInt(2,form.getItems());
		    preparestatement.setDate(3, java.sql.Date.valueOf(form.getOrder_date()));
		    preparestatement.setString(4,form.getUsername());

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
	public void update(History form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "UPDATE history SET order_id = ?, items = ?, order_date = ?, username = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getOrder_id());
			preparestatement.setInt(2,form.getItems());
		    preparestatement.setDate(3,java.sql.Date.valueOf(form.getOrder_date()));
		    preparestatement.setString(4,form.getUsername());
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
	public void delete(String order_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "delete from history where order_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(order_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findMostRecentHistory() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			String sql = "SELECT order_id, order_date\n"
					+ "from history\n"
					+ "where DATE(order_date) > '2021-10-14'\n"
					+ "order by order_id asc;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				History history = new History();
				history.setOrder_id(resultSet.getInt("order_id"));
				history.setOrder_date(resultSet.getString("order_date"));
	    		list.add(history);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
}