package delivery_info.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_info.service.DeliveryInfoService;

/**
 * Servlet implementation class findAll
 */

public class customerAndDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeliveryInfoService deliveryInfoService = new DeliveryInfoService();
		try {
			request.setAttribute("CustomerAndDriverList", deliveryInfoService.findCustomerAndDriver());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
//		try {
//			List<Object> li = deliveryInfoService.findall();
//			for(int i = 0; i < li.size();i++){
//				System.out.println(li.get(i).toString());
//			}
//			
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
		request.getRequestDispatcher("/jsps/delivery_info/q3_customer_and_driver.jsp").forward(request, response);
	}

}
