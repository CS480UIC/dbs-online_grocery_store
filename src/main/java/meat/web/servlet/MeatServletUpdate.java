package meat.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meat.dao.MeatDao;
import meat.domain.Meat;



/**
 * Servlet implementation class UserServlet
 */

public class MeatServletUpdate extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
	public MeatServletUpdate() {
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
		MeatDao meatDao = new MeatDao();
		Meat meat = null;

		if(method.equals("search"))
		{
			try {
				meat = meatDao.findByProductID(Integer.parseInt(request.getParameter("product_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(meat.getMeatName()!=null){
				request.setAttribute("meat", meat);
				request.getRequestDispatcher("/jsps/meat/meat_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "meat not found");
				request.getRequestDispatcher("/jsps/meat/meat_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Meat form = new Meat();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setProduct_id(Integer.parseInt(info.get(1)));
			form.setMeatName(info.get(2));
			form.setMeatPrice(Integer.parseInt(info.get(3)));
			form.setMeatQuantity(Integer.parseInt(info.get(4)));
			form.setMeatPicture(info.get(5));
			

			try {
				meatDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "meat Updated");
			request.getRequestDispatcher("/jsps/meat/meat_read_output.jsp").forward(request, response);
		}
	}
}
