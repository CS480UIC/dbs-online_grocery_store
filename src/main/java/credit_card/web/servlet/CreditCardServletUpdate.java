package credit_card.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import credit_card.dao.CreditCardDao;
import credit_card.domain.CreditCard;

/**
 * Servlet implementation class UserServlet
 */

public class CreditCardServletUpdate extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
	public CreditCardServletUpdate() {
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
		CreditCardDao credit_carddao = new CreditCardDao();
		CreditCard credit_card = null;

		if(method.equals("search"))
		{
			try {
				credit_card = credit_carddao.findByNumber(Integer.parseInt(request.getParameter("credit_card")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(credit_card.getCreditcardnumber()!=null){
				request.setAttribute("credit_card", credit_card);
				request.getRequestDispatcher("/jsps/credit_card/credit_card_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "credit_card not found");
				request.getRequestDispatcher("/jsps/credit_card/credit_card_read_output.jsp").forward(request, response); 
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			CreditCard form = new CreditCard();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setCreditcardnumber(Integer.parseInt(info.get(1)));
			form.setCvv(Integer.parseInt(info.get(2)));
			form.setExpirationdate(info.get(3));
			form.setCreditcardname(info.get(4));

			try {
				credit_carddao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "credit_card Updated");
			request.getRequestDispatcher("/jsps/credit_card/credit_card_read_output.jsp").forward(request, response);
		}
	}
}