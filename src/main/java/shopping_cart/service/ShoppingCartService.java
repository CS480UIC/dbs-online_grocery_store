package shopping_cart.service;


import shopping_cart.dao.ShoppingCartDao;
import shopping_cart.domain.ShoppingCart;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class ShoppingCartService {
	private ShoppingCartDao shoppingCartDao = new ShoppingCartDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(ShoppingCart form) throws ShoppingCartException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		ShoppingCart entity1 = shoppingCartDao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new ShoppingCartException("This shopping cart has been registered!");
		shoppingCartDao.add(form);
	}
	
}
