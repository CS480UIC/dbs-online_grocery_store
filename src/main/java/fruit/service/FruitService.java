package fruit.service;


import java.util.List;

import fruit.dao.FruitDao;
import fruit.domain.Fruit;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class FruitService {
	private FruitDao fruitDao = new FruitDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Fruit form) throws FruitException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Fruit entity1 = fruitDao.findByProductID(form.getProduct_id());
		if(entity1.getProduct_id()!=null && entity1.getProduct_id() == form.getProduct_id()) throw new FruitException("This fruit has been registered!");
		fruitDao.add(form);
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return fruitDao.findFruits();
		
	}
	
	public List<Object> findallOrders() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return fruitDao.findFruitOrders();
		
	}

	public List<Object> findExpensiveFruits()  throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		return fruitDao.findExpensiveFruits();
	}
	
	
}
