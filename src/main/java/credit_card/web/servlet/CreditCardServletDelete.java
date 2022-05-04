package credit_card.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import credit_card.dao.CreditCardDao;
import credit_card.domain.CreditCard;



/**
 * Servlet implementation class UserServlet
 */

public class CreditCardServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditCardServletDelete() {
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
		String method = request.getParameter("method");
		CreditCardDao creditCardDao = new CreditCardDao();
		CreditCard creditCard = null;
		if(method.equals("search"))
		{
			try {
				//System.out.print(request.getParameter("credit_card_number"));
				creditCard = creditCardDao.findByNumber(Integer.parseInt(request.getParameter("credit_card_number")));
				System.out.println(creditCard);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(creditCard.getCreditcardname()!=null){
						System.out.println(creditCard);
						request.setAttribute("creditCard", creditCard);
						request.getRequestDispatcher("/jsps/credit_card/credit_card_delete_output.jsp").forward(request, response);			
				}
			else{
				request.setAttribute("msg", "Credit Card not found");
				request.getRequestDispatcher("/jsps/credit_card/credit_card_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				creditCardDao.delete(request.getParameter("credit_card_number"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Credit Card Deleted");
			request.getRequestDispatcher("/jsps/credit_card/credit_card_read_output.jsp").forward(request, response);
		}
	}
}


