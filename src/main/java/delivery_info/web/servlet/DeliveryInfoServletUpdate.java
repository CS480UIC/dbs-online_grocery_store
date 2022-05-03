package delivery_info.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_info.dao.DeliveryInfoDao;
import delivery_info.domain.DeliveryInfo;



/**
 * Servlet implementation class UserServlet
 */

public class DeliveryInfoServletUpdate extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
	public DeliveryInfoServletUpdate() {
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
		DeliveryInfoDao deliverydao = new DeliveryInfoDao();
		DeliveryInfo delivery_info = null;

		if(method.equals("search"))
		{
			try {
				delivery_info = deliverydao.findByDriverID(Integer.parseInt(request.getParameter("driver_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(delivery_info.getUsername()!=null){
				request.setAttribute("deliver_info", delivery_info);
				request.getRequestDispatcher("/jsps/delivery_info/delivery_info_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "delivery_info not found");
				request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			DeliveryInfo form = new DeliveryInfo();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setDriver_id(Integer.parseInt(info.get(1)));
			form.setUsername(info.get(2));
			form.setDriver_proximity(info.get(3));
			form.setVehicle_type(info.get(4));
			

			try {
				deliverydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "delivery_info Updated");
			request.getRequestDispatcher("/jsps/delivery_info/delivery_info_read_output.jsp").forward(request, response);
		}
	}
}
