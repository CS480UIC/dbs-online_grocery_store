package fruit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruit.dao.FruitDao;
import fruit.domain.Fruit;

/**
 * Servlet implementation class UserServlet
 */

public class FruitServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
	public FruitServletUpdate() {
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
		FruitDao fruitDao = new FruitDao();
		Fruit fruit = null;

		if(method.equals("search"))
		{
			try {
				fruit = fruitDao.findByProductID(Integer.parseInt(request.getParameter("product_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(fruit.getFruit_name()!=null){
				request.setAttribute("fruit", fruit);
				request.getRequestDispatcher("/jsps/fruit/fruit_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "fruit not found");
				request.getRequestDispatcher("/jsps/fruit/fruit_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Fruit form = new Fruit();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setProduct_id(Integer.parseInt(info.get(1)));
			form.setFruit_name(info.get(2));
			form.setFruit_price(Double.parseDouble(info.get(3)));
			form.setFruit_quantity(Integer.parseInt(info.get(4)));
			form.setFruit_picture(info.get(5));
			
			

			try {
				fruitDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "fruit Updated");
			request.getRequestDispatcher("/jsps/fruit/fruit_read_output.jsp").forward(request, response);
		}
	}
}

