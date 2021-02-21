package digiworld.payments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
import com.paypal.base.rest.PayPalRESTException;

import digiworld.store.CartItem;
import digiworld.store.CartUtils;
import digiworld.store.Checkout_utils;
import digiworld.user.UserUtils;

@WebServlet(name = "AuthorizePaymentServlet", urlPatterns = {"/paypalAuthorize"})
public class AuthorizePaymentServlet extends HttpServlet{
	
	private final static String CLIENT_ID = "AawLroSmfeuP3scS8e7oL9FMXHCzlEPUqjuFfY8qkKf96KS-u_fptl9zJcRrBai8A1sWIlKuIjra5zPz";
	private final static String CLIENT_SECRET = "EP8FwgO522ve_qDcrF3oxITwQSc88bl4syGQcT0Ipg52_Tdyyjt5hUPRn_7c-UrnCrlyJSWDBKfWzqV1";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<CartItem> cart_items = new ArrayList<CartItem>();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String SessionKey = (String) session.getAttribute("sessionkey");
		
		if(SessionKey != null || UserUtils.getUser(SessionKey) != null) {
		
			cart_items = CartUtils.getCartItems(SessionKey);
			
			if(cart_items == null) { response.sendRedirect("login"); } 
			if(!cart_items.isEmpty())
			{
		        PaymentServices paymentService;
		        if (request.getParameter("PayerID") != null) {
		            paymentService = new PaymentServices(CLIENT_ID,CLIENT_SECRET,"sandbox");
		            paymentService.completePayment(request, response, SessionKey, cart_items);
		             
		        } else {
		            paymentService = new PaymentServices(CLIENT_ID,CLIENT_SECRET,"sandbox");
		            paymentService.processPayment(request, response, SessionKey, cart_items);
		        }
			}
		}
	}
}
	