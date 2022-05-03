package user.domain;

/**
 * User object
 * @author Aayush Makharia
 */
public class User {
	/*
	 * Correspond to the user table
	 */
	
	private String username;
	private String password; 
	private String first_name;
	private String last_name;
	private String email;
	private String address;
	private Integer credit_card_number;
	

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	/**
	 * @return the first_name
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the credit_card_number
	 */
	public Integer getCreditCardNumber() {
		return credit_card_number;
	}

	/**
	 * @param credit_card_number the credit_card_number to set
	 */
	public void setCreditCardNumber(Integer credit_card_number) {
		this.credit_card_number = credit_card_number;
	}

	@Override
	public String toString() {
		return "User [ username=" + username + ", password="
				+ password + ", email=" + email +"]";
	}
}
