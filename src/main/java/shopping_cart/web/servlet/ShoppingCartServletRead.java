package shopping_cart.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruit.dao.FruitDao;
import fruit.domain.Fruit;
import shopping_cart.dao.ShoppingCartDao;
import shopping_cart.domain.ShoppingCart;


/**
 * Servlet implementation class UserServlet
 */

public class ShoppingCartServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServletRead() {
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
		ShoppingCart shopping_cart = null;
		ShoppingCartDao shopping_cartDao = new ShoppingCartDao();
		
		try {
			shopping_cart = shopping_cartDao.findByUsername(request.getParameter("username"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(shopping_cart.getUsername()!=null){
					System.out.println(shopping_cart);
					request.setAttribute("shopping_cart", shopping_cart);
					request.getRequestDispatcher("/jsps/shopping_cart/shopping_cart_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Shopping Cart not found");
			request.getRequestDispatcher("/jsps/shopping_cart/shopping_cart_read_output.jsp").forward(request, response);
		}
	}
}



