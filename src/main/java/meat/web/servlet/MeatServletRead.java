package meat.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruit.dao.FruitDao;
import fruit.domain.Fruit;
import meat.dao.MeatDao;
import meat.domain.Meat;


/**
 * Servlet implementation class UserServlet
 */

public class MeatServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeatServletRead() {
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
		Meat meat = null;
		MeatDao meatDao = new MeatDao();
		
		try {
			meat = meatDao.findByProductID(Integer.parseInt(request.getParameter("product_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(meat.getProduct_id()!=null){
					System.out.println(meat);
					request.setAttribute("meat", meat);
					request.getRequestDispatcher("/jsps/meat/meat_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Meat not found");
			request.getRequestDispatcher("/jsps/meat/meat_read_output.jsp").forward(request, response);
		}
	}
}



