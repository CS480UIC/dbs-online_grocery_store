package meat.service;


import java.util.List;

import meat.dao.MeatDao;
import meat.domain.Meat;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class MeatService {
	private MeatDao meatDao = new MeatDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Meat form) throws MeatException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Meat entity1 = meatDao.findByProductID(form.getProduct_id());
		if(entity1.getProduct_id()!=null && entity1.getProduct_id() == form.getProduct_id()) throw new MeatException("This meat has been registered!");
		meatDao.add(form);
	}
	
	public List<Object> findExpensiveMeat() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return meatDao.findExpensiveMeat();
	}
}
