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

import person.domain.Person;
import person.service.PersonException;
import person.service.PersonService;

/**
 * Servlet implementation class UserServlet
 */

public class PersonServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServletCreate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonService personservice = new PersonService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Person form = new Person();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		form.setUsername(info.get(0));
		form.setFirstName(info.get(1));
		form.setLastName(info.get(2));
		form.setAddress(info.get(3));
		form.setEmail(info.get(4));
		form.setPassword(info.get(5));
		form.setCreditCardNumber(Integer.parseInt(info.get(6)));
		
		
		try {
			personservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
		} catch (ClassNotFoundException | PersonException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
