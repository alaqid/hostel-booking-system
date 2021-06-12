<% if(session.getAttribute("status") != null) { %>
<jsp:include page="header.jsp"></jsp:include>
<%@page import="java.util.*" %>
<%@page import="room.*" %>
<%@page import="guest.*" %>
<jsp:useBean id="obj10" scope="application" class="guest.GuestModel"/>
<jsp:useBean id="Roommodel" scope="application" class="room.Roommodel"></jsp:useBean>
<% List<guest.Guest> list = GuestModel.viewGuest(); %>
<% int id = Integer.parseInt(request.getParameter("room_id")); %>
<% Room i = Roommodel.getRoomById(id);%>
  <div class="container">
   <div class="row">
   	<div class="col-md-6 offset-md-3">
   	 <form action="Addbooking" method="post" id="form-register"><br>
   	                         <h2 class="text-center" style="color:black;">
                            Booking Details
                        </h2>
                        <label for="date">
                            Room Number
                        </label><br>
						 <input disabled type="text" name="room_no" class="form-control" id="room_no" value="<%= i.getRoom_no() %>"><br>
                          <label for="date">
                            Guest Name
                        </label><br>
                        <select name="guest_id" id="room" class="form-control form control-lg" required>
                            <option>--select--</option>
                            <% for(guest.Guest g : list) { %>
                            <option value="<%= g.getGuest_id() %>"><%= g.getGuest_name() %></option>
 							<% } %>
                        </select><br>
                         <label for="date">
                            Bed
                        </label><br>
                        <select name="bed" id="bed" class="form-control form control-lg">
                                             
                            
                            <% for (int w=1;w<=i.getBed_no();w++){ %>
                                 <option value="<%= w %>">
                                 Bed                                    
                                    <%= w %>
                                    
                                    </option> 
                                    <%  } %>
                         </select><br>
                        <label for="date">
                            Date Check-In
                        </label>
                        <input type="date" name="date_checkin" id="checkout" class="form-control form control-lg"
                            required><br>
                            <input type="hidden"  value="<%= i.getRoom_id() %>" name="room_id" id="checkout" class="form-control form control-lg"
                            required>
                        <label for="date">
                            Date Check-Out
                        </label>
                        <input type="date" name="date_checkout" id="checkin" class="form-control form control-lg"
                            required><br>
                        
                        <label for="date">
                            Bed
                        </label><br>
                        <br>
                        <a type="button" class="btn btn-dark" style="float: left;"  href="records.jsp">Back</a>
                        <button type="submit" class="btn btn-success" style="float: right;"
                            value="submit">Done</button>
                        
   	 </form>
   	</div>
   </div>
  </div>
  </body> 
  <jsp:include page="footer.jsp"></jsp:include>
  <% } %>