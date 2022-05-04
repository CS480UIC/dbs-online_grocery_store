package vegetable.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vegetable.domain.Vegetable;
import vegetable.service.VegetableException;
import vegetable.service.VegetableService;


/**
 * Servlet implementation class UserServlet
 */

public class VegetableServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VegetableServletCreate() {
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
		VegetableService vegservice = new VegetableService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Vegetable form = new Vegetable();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		form.setProduct_id(Integer.parseInt(info.get(0)));
		form.setVegName(info.get(1));
		form.setVegPrice(Double.parseDouble(info.get(2)));		
		form.setVegQuantity(Integer.parseInt(info.get(3)));
		form.setVegPicture(info.get(4));
		
		try {
			vegservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | VegetableException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
