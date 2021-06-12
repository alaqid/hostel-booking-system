<% if(session.getAttribute("status") != null) { %>
<jsp:include page="header.jsp"></jsp:include>
<%@page import="java.util.*" %>
<%@page import="room.*" %>
<%@page import="guest.*" %>
<%@page import="booking.*" %>
<jsp:useBean id="obj11" scope="application" class="guest.GuestModel"/>
<jsp:useBean id="Roommodel" scope="application" class="room.Roommodel"></jsp:useBean>
<% List<guest.Guest> list1 = GuestModel.viewGuest(); %>
<% List<room.Room> list2 = Roommodel.viewRoom(); %>
<% int id = Integer.parseInt(request.getParameter("guest_id")); %>
<% Room i = Roommodel.getRoomById(id);%>
<% List<booking.Booking> list = BookingModel.viewBookingGuest(id); %>
    <body>
    <!-- table -->
    <div class="container">
        <div class="row">
            <div class="col-md-12 mt-5">
                <div class="card-header">
                    <h4 class="text-center" style="color:black;">
                        Bookings Records
                    </h4>
                </div>
                <div class="">
                    <table class="table table-hovered table-bordered">
                        <thead class="thead-dark">
                            <tr class="text-center">
                                <th scope="col">#</th>
                                <th scope="col">Date Check In <i class="fas fa-sort"></i></th>
                                <th scope="col">Date Check Out <i class="fas fa-sort"></i></th>  
                                <th scope="col">Room Number <i class="fas fa-sort"></i></th>
                                <th scope="col">Bed Number <i class="fas fa-sort"></i></th>                            
                                <th scope="col">Action</th>
                                <!-- <th scope="col">Profile Picture<i class="fas fa-sort"></i></th> -->                                
                                
                            </tr>
                        </thead>
                        <% for(booking.Booking b : list) { %>
                        <tbody>
                            <tr class="text-center">
                                <th scope="row" class="text-center"><%= b.getBooking_id() %></th>                                
                                <th><%= b.getDate_checkin() %></th>
                                <th><%= b.getDate_checkout() %></th>
                                
                                <th><%= b.getRoom_no() %></th>
                                <th><%= b.getBed_no() %></th>                               
                                
                                  <input type="hidden" name="guest_id" value="<%= b.getGuest_id() %>">                                                         
                               <td>
                                     <!-- <form action="updatestaff.jsp" method="POST">
        								<input type="hidden" name="staff_id" value="<%= b.getBooking_id() %>">
      									<button type="submit" class="btn btn-primary">Update</button>
        							</form>  -->
                                   
                                    <form action="Deletebooking" method="post">
        								<input type="hidden" name="booking_id" value="<%= b.getBooking_id() %>">
        								<button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure to delete this record?')">Delete</button> 
       								 </form>
                                </td>
                            </tr>                            
                        </tbody>
                        <% } %>
                    </table>
                </div>
            </div>
        </div>
    </div>

</body>
<jsp:include page="footer.jsp"></jsp:include>
<% } %>