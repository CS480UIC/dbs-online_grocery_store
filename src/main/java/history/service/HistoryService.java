package history.service;


import java.util.List;

import history.dao.HistoryDao;
import history.domain.History;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class HistoryService {
	private HistoryDao historyDao = new HistoryDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(History form) throws HistoryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		History entity1 = historyDao.findByOrderID(form.getOrder_id());
		if(entity1.getOrder_id()!=null && entity1.getOrder_id().equals(form.getOrder_id())) throw new HistoryException("This history has been registered!");
		historyDao.add(form);
	}
	
	public List<Object> findMostRecentHistory() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return historyDao.findMostRecentHistory();
		
	}
	
}
