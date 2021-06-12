package login;
 
import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/login")
public class LoginAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginAdd() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String admin_email = request.getParameter("admin_email");
        String admin_pwd = request.getParameter("admin_pwd");
        //String dest = "header.jsp";
        LoginModel im = new LoginModel();

     
		
			
			try {
				Login l = im.checkLogin(admin_email,admin_pwd);
				if (l != null) {
		            HttpSession session = request.getSession();
		            session.setAttribute("status", "loggedin");
		            //session.setAttribute("user", s);
		            
		            response.sendRedirect("home.jsp");

		        }
		        else{
		        	HttpSession session = request.getSession();
		        	String message = "Invalid email/password";
	                request.setAttribute("message", message);
	                session.setAttribute("danger", "Email/password is incorrect.");
		            response.sendRedirect("login.jsp");
		        }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
        
        //request.getRequestDispatcher(dest).include( request, response);
    }
}
             
         
    
