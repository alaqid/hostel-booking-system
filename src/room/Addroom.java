package room;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


	@WebServlet("/Addroom")
		public class Addroom extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		public Addroom() {
			super();
			
		}
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	
				Room iv = new Room();
		 		iv.setRoom_no(Integer.parseInt(request.getParameter("room")));
		 		iv.setBed_no(Integer.parseInt(request.getParameter("bed")));

				Roommodel im = new Roommodel();
				try {
						im.addRoom(iv);
					} 				
				
				catch (SQLException | ClassNotFoundException e) {

					e.printStackTrace();
				}


				 HttpSession session = request.getSession();
		         session.setAttribute("success", "Success");
			 
				 response.sendRedirect("roomstatus.jsp");


			}


}
