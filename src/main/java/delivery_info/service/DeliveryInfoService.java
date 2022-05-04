package delivery_info.service;


import java.util.List;

import delivery_info.dao.DeliveryInfoDao;
import delivery_info.domain.DeliveryInfo;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class DeliveryInfoService {
	private DeliveryInfoDao deliveryInfoDao = new DeliveryInfoDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(DeliveryInfo form) throws DeliveryInfoException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		DeliveryInfo entity1 = deliveryInfoDao.findByDriverID(form.getDriver_id());
		if(entity1.getDriver_id()!=null && entity1.getDriver_id() == form.getDriver_id()) throw new DeliveryInfoException("This driver Info has been registered!");
		deliveryInfoDao.add(form);
	}
	
	public List<Object> findDeliveryInfo() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return DeliveryInfoDao.findDeliveryInfo();
		
	}
	
}
