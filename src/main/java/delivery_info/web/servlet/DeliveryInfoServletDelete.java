package delivery_info.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_info.dao.DeliveryInfoDao;
import delivery_info.domain.DeliveryInfo;


/**
 * Servlet implementation class UserServlet
 */

public class DeliveryInfoServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
//     * @see HttpServlet#HttpServlet()
//     */
    public DeliveryInfoServletDelete() {
        super();
    }
    
	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		DeliveryInfoDao deliveryInfoDao = new DeliveryInfoDao();
		DeliveryInfo deliveryInfo = null;
		if(method.equals("search"))
		{
			try {
				deliveryInfo = deliveryInfoDao.findByDriverID(Integer.parseInt(request.getParameter("driver_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(deliveryInfo.getDriver_id()!=null){
						//System.out.println(entity1);
						request.setAttribute("delivery_info", deliveryInfo);
						request.getRequestDispatcher("/jsps/delivery_info/delivery_info_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Delivery Info not found");
				request.getRequestDispatcher("/jsps/delivery_info/delivery_info_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				deliveryInfoDao.delete(request.getParameter("driver_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Delivery Info Deleted");
			request.getRequestDispatcher("/jsps/delivery_info/delivery_info_read_output.jsp").forward(request, response);
		}
	}
}



