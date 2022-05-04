package history.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruit.dao.FruitDao;
import fruit.domain.Fruit;
import history.dao.HistoryDao;
import history.domain.History;


/**
 * Servlet implementation class UserServlet
 */

public class HistoryServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServletRead() {
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
		History history = null;
		HistoryDao historyDao = new HistoryDao();
		
		try {
			history = historyDao.findByOrderID(Integer.parseInt(request.getParameter("order_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(history.getOrder_id()!=null){
					System.out.println(history);
					request.setAttribute("history", history);
					request.getRequestDispatcher("/jsps/history/history_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "History not found");
			request.getRequestDispatcher("/jsps/history/history_read_output.jsp").forward(request, response);
		}
	}
}



