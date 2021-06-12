package staff;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Updatestaff", urlPatterns = {"/Updatestaff"})
@MultipartConfig(maxFileSize = 16177216)//1.5mb
public class Updatestaff extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Updatestaff(){
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  
   		 Staff iv = new Staff();
         iv.setStaff_id(Integer.parseInt(request.getParameter("staff_id")));
         iv.setStaff_name(request.getParameter("staff_name"));
         iv.setStaff_ic(request.getParameter("staff_ic"));
         iv.setStaff_position(request.getParameter("staff_position"));
         iv.setStaff_email(request.getParameter("staff_email"));
         iv.setStaff_phone(request.getParameter("staff_phone"));
         iv.setStaff_address(request.getParameter("staff_address"));
         iv.setImage(request.getPart("image"));         


         StaffModel im = new StaffModel();
         try {
            im.updateStaff(iv);
        } catch (ClassNotFoundException e) {            
            e.printStackTrace();
        } catch (SQLException e) {           
            e.printStackTrace();
        }

         HttpSession session = request.getSession();
         session.setAttribute("success", "Success");
	 
		 response.sendRedirect("staffrecords.jsp");
    }

}
