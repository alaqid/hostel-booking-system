package room;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


 @WebServlet("/Deleteroom")
 	public class Deleteroom extends HttpServlet {
	 private static final long serialVersionUID = 1L;

 /* @see HttpServlet#HttpServlet()
 */
	 public Deleteroom() {
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


     int id = Integer.parseInt(request.getParameter("room_id"));

     Roommodel rm = new Roommodel();
     try {
    	 rm.deleteRoomById(id);
     	 } catch (SQLException | ClassNotFoundException e) {

     e.printStackTrace();
     	 }


     HttpSession session = request.getSession();
     session.setAttribute("success", "Success");
 
	 response.sendRedirect("roomstatus.jsp");
	 }

 }