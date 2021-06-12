<% if(session.getAttribute("status") != null) { %>
 <jsp:include page="header.jsp"></jsp:include>
 <%@page import="java.util.*" %>
<%@page import="staff.StaffModel" %>
<jsp:useBean id="obj3" scope="application" class="staff.StaffModel"/>
<% List<staff.Staff> list = StaffModel.viewStaff(); %>
    <body>
    <!-- table -->
    <div class="container">
        <div class="row">
            <div class="col-md-12 mt-5">
                <div class="card-header">
                    <h4 class="text-center" style="color:black;">
                        Staff Records
                    </h4>
                </div>
                <div class="">
                    <table class="table table-hovered table-bordered">
                        <thead class="thead-dark">
                            <tr class="text-center">
                                <th scope="col">#</th>
                                <th scope="col">Name <i class="fas fa-sort"></i></th>
                                <th scope="col">ID <i class="fas fa-sort"></i></th>                                
                                <th scope="col">Position <i class="fas fa-sort"></i></th>
                                <th scope="col">Email <i class="fas fa-sort"></i></th>
                                <th scope="col">Phone <i class="fas fa-sort"></i></th>
                                <th scope="col">Address <i class="fas fa-sort"></i></th>
                                <th scope="col">Profile Picture<i class="fas fa-sort"></i></th>
                                <th scope="col">Action</th>
                                                               
                                
                            </tr>
                        </thead>
                        <% for(staff.Staff s : list) { %>
                        <tbody>
                            <tr class="text-center">
                                <th scope="row" class="text-center"><%= s.getStaff_id() %></th>                                
                                <th><%= s.getStaff_name() %></th>
                                <th><%= s.getStaff_ic() %></th>
                                <th><%= s.getStaff_position() %></th>
                                <th><%= s.getStaff_email() %></th>
                                <th><%= s.getStaff_phone() %></th>
                                <th><%= s.getStaff_address() %></th>
                                <td><img src="data:image/jpeg;base64,<%=s.getSqlimage() %>"  width="100px"/></td>                                                                
                                <td>
                                    <form action="updatestaff.jsp" method="POST">
        								<input type="hidden" name="staff_id" value="<%= s.getStaff_id() %>">
      									<button type="submit" class="btn btn-primary">Update</button>
        							</form> 
                                   
                                    <form action="Deletestaff" method="post">
        								<input type="hidden" name="staff_id" value="<%= s.getStaff_id() %>">
        								<button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure to delete this record?')">Delete</button> 
       								 </form>
                                </td>
                            </tr>                            
                        </tbody>
                        <%   } %>
                    </table>
                </div>
            </div>
        </div>
    </div>

</body>
<jsp:include page="footer.jsp"></jsp:include>
<% } %>