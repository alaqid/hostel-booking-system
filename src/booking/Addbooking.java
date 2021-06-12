package booking;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

  @WebServlet("/Addbooking")
 	public class Addbooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	public Addbooking() {
	super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-mm-dd");
	     java.util.Date date_checkin = null;
	     java.util.Date date_checkout = null;

	         try {
	        	 date_checkin = (java.util.Date) format.parse(request.getParameter("date_checkin"));
	        	 date_checkout = (java.util.Date) format.parse(request.getParameter("date_checkout"));
	        } catch (java.text.ParseException e) {	            
	            e.printStackTrace();
	        }

	         java.sql.Date sqldate1 = new java.sql.Date(date_checkin.getTime());
	         java.sql.Date sqldate2 = new java.sql.Date(date_checkout.getTime());
	         
	 		
		
		Booking iv = new Booking();
 		iv.setGuest_id(Integer.parseInt(request.getParameter("guest_id")));
		iv.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
		iv.setBed_no(Integer.parseInt(request.getParameter("bed")));
		iv.setDate_checkin(sqldate1);
		iv.setDate_checkout(sqldate2);


		BookingModel im = new BookingModel();
		try {
				im.addBooking(iv);
			} 				
		
		catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}


		 HttpSession session = request.getSession();
         session.setAttribute("success", "Success");
	 
		 response.sendRedirect("records.jsp");


	}

 }