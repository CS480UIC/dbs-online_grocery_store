package history.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import history.service.HistoryService;

/**
 * Servlet implementation class findAll
 */

public class MostRecentHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HistoryService historyService = new HistoryService();
		try {
			request.setAttribute("HistoryList", historyService.findMostRecentHistory());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
//		try {
//			List<Object> li = historyService.findall();
//			for(int i = 0; i < li.size();i++){
//				System.out.println(li.get(i).toString());
//			}
//			
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
		request.getRequestDispatcher("/jsps/history/q2_most_recent_history.jsp").forward(request, response);
	}

}
