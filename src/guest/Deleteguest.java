package guest;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
 @WebServlet("/Deleteguest")
 	public class Deleteguest extends HttpServlet {
	 private static final long serialVersionUID = 1L;

 /* @see HttpServlet#HttpServlet()
 */
	 public Deleteguest() {
		 super();
 // TODO Auto-generated constructor stub
	 }


	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
 // TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	 }		


	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {


     int id = Integer.parseInt(request.getParameter("guest_id"));

     GuestModel gm = new GuestModel();
     try {
    	 gm.deleteGuestById(id);
     	 } catch (SQLException | ClassNotFoundException e) {

     e.printStackTrace();
     	 }


     HttpSession session = request.getSession();
     session.setAttribute("success", "Success");
 
	 response.sendRedirect("records.jsp");
	 }

 }