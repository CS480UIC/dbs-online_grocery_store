package credit_card.domain;


/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class CreditCard {
	/*
	 * Correspond to the user table
	 */
	private Integer credit_card_number;
	private Integer cvv;
	private String expiration_date;
	private String credit_card_name;
	/**
	 * @return the credit_card_number
	 */
	public Integer getCreditcardnumber() {
		return credit_card_number;
	}
	/**
	 * @param credit_card_number the credit_card_number to set
	 */
	public void setCreditcardnumber(Integer credit_card_number) {
		this.credit_card_number = credit_card_number;
	}
	/**
	 * @return the cvv
	 */
	public Integer getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	/**
	 * @return the expiration_date
	 */
	public String getExpirationdate() {
		return expiration_date;
	}
	/**
	 * @param expiration_date the expiration_date to set
	 */
	public void setExpirationdate(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	/**
	 * @return the credit_card_name
	 */
	public String getCreditcardname() {
		return credit_card_name;
	}
	/**
	 * @param credit_card_name the credit_card_name to set
	 */
	public void setCreditcardname(String credit_card_name) {
		this.credit_card_name = credit_card_name;
	}
	
	
	

}
