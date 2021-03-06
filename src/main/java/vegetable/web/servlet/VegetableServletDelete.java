package vegetable.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vegetable.dao.VegetableDao;
import vegetable.domain.Vegetable;

/**
 * Servlet implementation class UserServlet
 */

public class VegetableServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VegetableServletDelete() {
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
		String method = request.getParameter("method");
		VegetableDao vegDao = new VegetableDao();
		Vegetable veg = null;
		if(method.equals("search"))
		{
			try {
				veg = vegDao.findByProductID(Integer.parseInt(request.getParameter("product_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(veg.getVegName()!=null){
						System.out.println(veg);
						request.setAttribute("vegetable", veg);
						request.getRequestDispatcher("/jsps/vegetable/vegetable_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Vegetable not found");
				request.getRequestDispatcher("/jsps/vegetable/vegetable_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				vegDao.delete(request.getParameter("product_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Vegetable Deleted");
			request.getRequestDispatcher("/jsps/vegetable/vegetable_read_output.jsp").forward(request, response);
		}
	}
}



