package person.service;


import person.dao.PersonDao;
import person.domain.Person;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class PersonService {
	private PersonDao personDao = new PersonDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Person form) throws PersonException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Person entity1 = personDao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals( form.getUsername()))throw new PersonException("This person has been registered!");
		personDao.add(form);
	}
	
}
