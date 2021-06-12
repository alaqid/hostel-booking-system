<% if(session.getAttribute("status") != null) { %>
 <jsp:include page="header.jsp"></jsp:include>
 <%@page import="java.util.*" %>
<%@page import="guest.GuestModel" %>
<jsp:useBean id="obj2" scope="application" class="guest.GuestModel"/>
<% List<guest.Guest> list = GuestModel.viewGuest(); %>
    <body>
    <!-- table -->
    <div class="container">
        <div class="row">
            <div class="col-md-12 mt-5">
                <div class="card-header">
                    <h4 class="text-center" style="color:black;">
                        Guest Records
                    </h4>
                </div>
                <!-- <p style="color:red">Press "CTRL+F" to search specified customer.</p> -->
                <div class="">
                    <table class="table table-hovered table-bordered">
                        <thead class="thead-dark">
                            <tr class="text-center">
                                <th scope="col">#</th>
                                <th scope="col">Name </th>
                                <th scope="col">Age </th>
                                <th scope="col">Gender </th>
                                <th scope="col">Email </th>
                                <th scope="col">Phone </th>                                
                                <th scope="col">Update</th>
                                <th scope="col">Delete</th>
                                <th scope="col">Booking </th>
                            </tr>
                        </thead>
                        <% for(guest.Guest g : list) { %>
                        <tbody>
                            <tr class="text-center">
                                <th scope="row" class="text-center"><%= g.getGuest_id() %></th>
                                <th><%= g.getGuest_name() %></th> 
                                <th><%= g.getGuest_age() %></th>
                                <th><%= g.getGuest_gender() %></th>
                                <th><%= g.getGuest_email() %></th>
                                <th><%= g.getGuest_phone() %></th>  
                                <td>
                                <form action="updateguest.jsp" method="POST">
        								<input type="hidden" name="guest_id" value="<%= g.getGuest_id() %>">
      									<button type="submit" class="btn btn-primary">Update</button>
        							</form> 
                                </td>                                                          
                                <td>                                
                                                                       
                                    <form action="Deleteguest" method="post">
        								<input type="hidden" name="guest_id" value="<%= g.getGuest_id() %>">
        								<button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure to delete this record?')">Delete</button> 
       								 </form>
                                </td>
                                <td>                                                                  
                                    <form action="viewbooking.jsp" method="post">
        								<input type="hidden" name="guest_id" value="<%= g.getGuest_id() %>">
        								<button type="submit" class="btn btn-success">View</button> 
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