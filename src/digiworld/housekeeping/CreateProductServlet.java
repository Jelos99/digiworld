package digiworld.housekeeping;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digiworld.database.connectionManager;
import digiworld.store.Product;
import digiworld.store.ProductUtils;
import digiworld.user.UserUtils;

@WebServlet(name = "CreateProductServlet", urlPatterns = {"/createproduct"})
public class CreateProductServlet extends HttpServlet{
	
	public void init(ServletConfig config) throws ServletException {
		connectionManager.createConnection();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher req = request.getRequestDispatcher("/skeletons/pages/housekeeping/createproduct.jsp");
		
		String SessionKey = (String) session.getAttribute("sessionkey");
		if(SessionKey == null)
		{
			response.sendRedirect("login");
		} else if(UserUtils.isAdmin(SessionKey)) {
			
		} else {
			response.sendRedirect("user");
		}
		
		req.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String Product_name = request.getParameter("product_name");
		String Product_description = request.getParameter("product_description");
		int Product_service = Integer.parseInt(request.getParameter("product_service"));
		float Product_price = Float.parseFloat(request.getParameter("product_price"));
		String Product_region = request.getParameter("product_region");
		int Product_discount = Integer.parseInt(request.getParameter("product_discount"));
		boolean Product_isDLC = Boolean.parseBoolean(request.getParameter("product_isdlc"));
		String Product_Category = request.getParameter("product_category");
	
		HttpSession session = request.getSession();
		String SessionKey = (String) session.getAttribute("sessionkey");
		
		if(SessionKey == null || !UserUtils.isAdmin(SessionKey)) { return; }
	
		try {
			if(ProductUtils.addNewProduct(new Product(
					0, 
					Product_name, 
					Product_service,
					Product_description, 
					Product_price, 
					Product_discount, 
					Product_region, 
					Product_isDLC,
					Product_Category
					))) 
			{ session.setAttribute("success", "Prodotto creato con successo!"); } else { session.setAttribute("error", "Si é verificato un errore nell'aggiunta del prodotto.");}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		response.sendRedirect("housekeeping");
	}

}
