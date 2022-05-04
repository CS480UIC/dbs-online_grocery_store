package delivery_info.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_info.dao.DeliveryInfoDao;
import delivery_info.domain.DeliveryInfo;
import fruit.dao.FruitDao;
import fruit.domain.Fruit;


/**
 * Servlet implementation class UserServlet
 */

public class DeliveryInfoServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryInfoServletRead() {
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
		DeliveryInfo delivery_info = null;
		DeliveryInfoDao delivery_InfoDao = new DeliveryInfoDao();
		
		try {
			delivery_info = delivery_InfoDao.findByDriverID(Integer.parseInt(request.getParameter("driver_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(delivery_info.getDriver_id()!=null){
//					System.out.println(delivery_info);
					request.setAttribute("delivery_info", delivery_info);
					request.getRequestDispatcher("/jsps/delivery_info/delivery_info_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Delivery Info not found");
			request.getRequestDispatcher("/jsps/delivery_info/delivery_info_read_output.jsp").forward(request, response);
		}
	}
}



