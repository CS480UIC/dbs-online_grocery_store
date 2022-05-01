package shopping_cart.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping_cart.dao.ShoppingCartDao;
import shopping_cart.domain.ShoppingCart;



/**
 * Servlet implementation class UserServlet
 */

public class ShoppingCartServletUpdate extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
	public ShoppingCartServletUpdate() {
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
		ShoppingCartDao ShoppingCartDao = new ShoppingCartDao();
		ShoppingCart shopping_cart = null;

		if(method.equals("search"))
		{
			try {
				shopping_cart = ShoppingCartDao.findByUsername(request.getParameter("shopping_cart"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(shopping_cart.getUsername()!=null){
				request.setAttribute("shopping_cart", shopping_cart);
				request.getRequestDispatcher("/jsps/shopping_cart/shopping_cart_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/shopping_cart/shopping_cart_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			ShoppingCart form = new ShoppingCart();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setUsername(info.get(1));
			form.setProduct_id(Integer.parseInt(info.get(2)));
			form.setProduct_price(Integer.parseInt(info.get(3)));
			form.setQuantity(Integer.parseInt(info.get(4)));
			
			try {
				ShoppingCartDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "shopping_cart Updated");
			request.getRequestDispatcher("/jsps/shopping_cart/shopping_cart_read_output.jsp").forward(request, response);
		}
	}
}



