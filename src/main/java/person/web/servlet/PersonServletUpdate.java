
   
package person.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.dao.PersonDao;
import person.domain.Person;



/**
 * Servlet implementation class UserServlet
 */

public class PersonServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
	public PersonServletUpdate() {
		super();
	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		PersonDao personDao = new PersonDao();
		Person person = null;

		if(method.equals("search"))
		{
			try {
				person = personDao.findByUsername(request.getParameter("username"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(person.getUsername()!=null){
				request.setAttribute("person", person);
				request.getRequestDispatcher("/jsps/person/person_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "person not found");
				request.getRequestDispatcher("/jsps/person/person_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Person form = new Person();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setUsername(info.get(1));
			form.setPassword(info.get(2));
			form.setFirstName(info.get(3));
			form.setLastName(info.get(4));
			form.setEmail(info.get(5));
			form.setAddress(info.get(6));
			form.setCreditCardNumber(Integer.parseInt(info.get(7)));
			
			
			try {
				personDao.update(form);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Person Updated");
			request.getRequestDispatcher("/jsps/person/person_read_output.jsp").forward(request, response);
		}
	}
}




