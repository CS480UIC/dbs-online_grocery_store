package vegetable.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruit.dao.FruitDao;
import fruit.domain.Fruit;
import vegetable.dao.VegetableDao;
import vegetable.domain.Vegetable;


/**
 * Servlet implementation class UserServlet
 */

public class VegetableServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VegetableServletRead() {
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
		Vegetable vegetable = null;
		VegetableDao vegetableDao = new VegetableDao();
		
		try {
			vegetable = vegetableDao.findByProductID(Integer.parseInt(request.getParameter("product_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(vegetable.getProduct_id()!=null){
					System.out.println(vegetable);
					request.setAttribute("vegetable", vegetable);
					request.getRequestDispatcher("/jsps/vegetable/vegetable_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Vegetable not found");
			request.getRequestDispatcher("/jsps/vegetable/vegetable_read_output.jsp").forward(request, response);
		}
	}
}



