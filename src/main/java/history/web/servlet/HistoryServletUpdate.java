package history.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import history.dao.HistoryDao;
import history.domain.History;



/**
 * Servlet implementation class UserServlet
 */

public class HistoryServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
	public HistoryServletUpdate() {
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
		HistoryDao historyDao = new HistoryDao();
		History history = null;

		if(method.equals("search"))
		{
			try {
				history = historyDao.findByOrderID(Integer.parseInt(request.getParameter("order_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(history.getUsername()!=null){
				request.setAttribute("history", history);
				request.getRequestDispatcher("/jsps/history/history_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "history not found");
				request.getRequestDispatcher("/jsps/history/history_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			History form = new History();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setOrder_id(Integer.parseInt(info.get(1)));
			form.setUsername(info.get(4));
			form.setItems(Integer.parseInt(info.get(2)));
			form.setOrder_date(info.get(3));
		
			
		
			try {
				historyDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "History Updated");
			request.getRequestDispatcher("/jsps/history/history_read_output.jsp").forward(request, response);
		}
	}
}



