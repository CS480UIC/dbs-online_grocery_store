package meat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import meat.domain.Meat;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class MeatDao {
	
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

	public Meat findByProductID(Integer productID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Meat meat = new Meat();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
		    String sql = "select * from meat where product_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,productID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("product_id"));
		    	if(id == productID){
		    		meat.setProduct_id(id);
		    		meat.setMeatName(resultSet.getString("meat_name"));
		    		meat.setMeatPrice(Double.parseDouble(resultSet.getString("meat_price")));
		    		meat.setMeatQuantity(Integer.parseInt(resultSet.getString("meat_quantity")));
		    		meat.setMeatPicture(resultSet.getString("meat_picture"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return meat;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException  
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Meat form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "insert into meat (product_id, meat_name, meat_price, meat_quantity, meat_picture) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getProduct_id());
		    preparestatement.setString(2,form.getMeatName());
		    preparestatement.setDouble(3,form.getMeatPrice());
		    preparestatement.setInt(4,form.getMeatQuantity());
		    preparestatement.setString(5,form.getMeatPicture());
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
	public void update(Meat form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			
			String sql = "UPDATE meat SET product_id = ?, meat_name = ?, meat_price = ?, meat_quantity = ?, meat_picture = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getProduct_id());
			preparestatement.setString(2,form.getMeatName());
		    preparestatement.setDouble(3,form.getMeatPrice());
		    preparestatement.setInt(4,form.getMeatQuantity());
		    preparestatement.setString(5,form.getMeatPicture());
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
			
			String sql = "delete from meat where product_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(product_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findExpensiveMeat() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_grocery_store", MySQL_user, MySQL_password);
			String sql = "SELECT * from meat where meat_price > 10 order by meat_price desc;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Meat meat = new Meat();
				meat.setProduct_id(resultSet.getInt("product_id"));
	    		meat.setMeatName(resultSet.getString("meat_name"));
	    		meat.setMeatPrice(resultSet.getDouble("meat_price"));
	    		meat.setMeatQuantity(resultSet.getInt("meat_quantity"));
	    		meat.setMeatPicture(resultSet.getString("meat_picture"));
	    		list.add(meat);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
