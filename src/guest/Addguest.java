package guest;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


	@WebServlet("/Addguest")
		public class Addguest extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		public Addguest() {
			super();
			
		}
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	
				Guest iv = new Guest();
				iv.setGuest_name(request.getParameter("guest_name"));
		 		iv.setGuest_age(Integer.parseInt(request.getParameter("guest_age")));
		 		iv.setGuest_gender(request.getParameter("guest_gender"));
		 		iv.setGuest_email(request.getParameter("guest_email"));
		 		iv.setGuest_gender(request.getParameter("guest_gender"));
		 		iv.setGuest_phone(request.getParameter("guest_phone"));

				GuestModel im = new GuestModel();
				try {
						im.addGuest(iv);
					} 				
				
				catch (SQLException | ClassNotFoundException e) {

					e.printStackTrace();
				}


				 HttpSession session = request.getSession();
		         session.setAttribute("success", "Success");
			 
				 response.sendRedirect("records.jsp");


			}


}
