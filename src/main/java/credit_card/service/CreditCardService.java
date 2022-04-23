package credit_card.service;


import credit_card.dao.CreditCardDao;
import credit_card.domain.CreditCard;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class CreditCardService {
	private CreditCardDao creditCardDao = new CreditCardDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(CreditCard form) throws CreditCardException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		CreditCard entity1 = creditCardDao.findByNumber(form.getCreditcardnumber());
		if(entity1.getCreditcardnumber()!=null && entity1.getCreditcardnumber() == form.getCreditcardnumber()) throw new CreditCardException("This card has been registered!");
		creditCardDao.add(form);
	}
	
}
