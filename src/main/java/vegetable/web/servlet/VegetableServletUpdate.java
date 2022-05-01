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

import vegetable.dao.VegetableDao;
import vegetable.domain.Vegetable;



/**
 * Servlet implementation class UserServlet
 */

public class VegetableServletUpdate extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
	public VegetableServletUpdate() {
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
		VegetableDao vegDao = new VegetableDao();
		Vegetable vegetable = null;

		if(method.equals("search"))
		{
			try {
				vegetable = vegDao.findByProductID(Integer.parseInt(request.getParameter("product_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(vegetable.getVegName()!=null){
				request.setAttribute("vegetable", vegetable);
				request.getRequestDispatcher("/jsps/vegetable/vegetable_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "vegetable not found");
				request.getRequestDispatcher("/jsps/vegetable/vegetable_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Vegetable form = new Vegetable();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setProduct_id(Integer.parseInt(info.get(1)));
			form.setVegName(info.get(2));
			form.setVegPrice(Integer.parseInt(info.get(3)));
			form.setVegQuantity(Integer.parseInt(info.get(4)));
			form.setVegPicture(info.get(5));

			try {
				vegDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "vegetable Updated");
			request.getRequestDispatcher("/jsps/vegetable/vegetable_read_output.jsp").forward(request, response);
		}
	}
}




