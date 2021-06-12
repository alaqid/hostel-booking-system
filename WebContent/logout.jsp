<%
	if(session.getAttribute("status") != null){
		session.removeAttribute("status");
		
		response.sendRedirect("home.jsp");
	}
%>