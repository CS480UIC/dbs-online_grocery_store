package shopping_cart.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruit.dao.FruitDao;
import fruit.domain.Fruit;


/**
 * Servlet implementation class UserServlet
 */

public class ShoppingCartServletRead extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public FruitServletRead() {
//        super();
//    }
//    
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request,response);
//	}
//	
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Fruit entity1 = null;
//		FruitDao entity1Dao = new FruitDao();
//		
//		try {
//			entity1 = entity1Dao.findByProductID(request.getParameter("username"));
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (InstantiationException e1) {
//			e1.printStackTrace();
//		} catch (IllegalAccessException e1) {
//			e1.printStackTrace();
//		}
//		
//		if(entity1.getUsername()!=null){
//					System.out.println(entity1);
//					request.setAttribute("entity1", entity1);
//					request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
//			}
//			else{
//			request.setAttribute("msg", "Entity not found");
//			request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
//		}
//	}
}



