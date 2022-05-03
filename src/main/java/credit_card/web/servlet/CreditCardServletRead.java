package credit_card.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import credit_card.dao.CreditCardDao;
import credit_card.domain.CreditCard;
import fruit.dao.FruitDao;
import fruit.domain.Fruit;


/**
 * Servlet implementation class UserServlet
 */

public class CreditCardServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditCardServletRead() {
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
		CreditCard credit_card = null;
		CreditCardDao credit_CardDao = new CreditCardDao();
		
		try {
			credit_card = credit_CardDao.findByNumber(Integer.parseInt(request.getParameter("credit_card_number")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(credit_card.getCreditcardnumber()!=null){
//					System.out.println(credit_card);
					request.setAttribute("credit_card", credit_card);
					request.getRequestDispatcher("/jsps/credit_card/credit_card_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Credit Card not found");
			request.getRequestDispatcher("/jsps/credit_card/credit_card_read_output.jsp").forward(request, response);
		}
	}
}



