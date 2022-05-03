package vegetable.service;


import vegetable.dao.VegetableDao;
import vegetable.domain.Vegetable;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class VegetableService {
	private VegetableDao vegetableDao = new VegetableDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Vegetable form) throws VegetableException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Vegetable entity1 = vegetableDao.findByProductID(form.getProduct_id());
		if(entity1.getProduct_id()!=null && entity1.getProduct_id() == form.getProduct_id()) throw new VegetableException("This veg has been registered!");
		vegetableDao.add(form);
	}
	
}
