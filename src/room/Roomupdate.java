package room;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Roomupdate")
public class Roomupdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Roomupdate(){
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  
   		 Room iv = new Room();
         iv.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
         iv.setRoom_no(Integer.parseInt(request.getParameter("room_no")));
         iv.setBed_no(Integer.parseInt(request.getParameter("bed_no")));


         Roommodel im = new Roommodel();
         try {
            im.updateRoom(iv);
        } catch (ClassNotFoundException e) {            
            e.printStackTrace();
        } catch (SQLException e) {           
            e.printStackTrace();
        }

         HttpSession session = request.getSession();
         session.setAttribute("success", "Success");
	 
		 response.sendRedirect("roomstatus.jsp");
    }

}
