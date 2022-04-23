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

import delivery_info.domain.DeliveryInfo;
import delivery_info.service.DeliveryInfoException;
import delivery_info.service.DeliveryInfoService;
 

/**
 * Servlet implementation class UserServlet
 */

public class DeliveryInfoServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryInfoServletCreate() {
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
		DeliveryInfoService deliveryInfoservice = new DeliveryInfoService();
		Map<String,String[]> paramMap = request.getParameterMap();
		DeliveryInfo form = new DeliveryInfo();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		
		form.setDriver_id(Integer.parseInt(info.get(0)));
		form.setUsername(info.get(1));		
		form.setDriver_proximity(info.get(2));
		form.setVehicle_type(info.get(3));
		
		try {
			deliveryInfoservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | DeliveryInfoException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
