package fruit.web.servlet;

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

public class FruitServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FruitServletDelete() {
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
		FruitDao fruitDao = new FruitDao();
		Fruit fruit = null;
		
		if(method.equals("search"))
		{
			try {
				fruit = fruitDao.findByProductID(Integer.parseInt(request.getParameter("product_id")));
				System.out.print(fruit.getProduct_id());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(fruit.getFruitPicture()!=null){
						//System.out.println(entity1);
						request.setAttribute("fruit", fruit);
						request.getRequestDispatcher("/jsps/fruit/fruit_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Fruit not found");
				request.getRequestDispatcher("/jsps/fruit/fruit_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			
			try {
				fruitDao.delete(request.getParameter("product_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Fruit Deleted");
			request.getRequestDispatcher("/jsps/fruit/fruit_read_output.jsp").forward(request, response);
		}
	}
}



