<% if(session.getAttribute("status") != null) { %>
 <jsp:include page="header.jsp"></jsp:include>
 <%@page import="java.util.*" %>
<%@page import="room.Roommodel" %>
<jsp:useBean id="obj" scope="application" class="room.Roommodel"/>
<% List<room.Room> list = Roommodel.viewRoom(); %>
   <body>
    <!-- table -->
    <div class="container">
        <div class="row">
            <div class="col-md-12 mt-5">
                <div class="card-header">
                    <h4 class="text-center" style="color:black;">
                        Room/Bed List 
                    </h4>
                </div>
                <div class="card-body">
                
                    <table class="table table-hoverd table-bordered">
                        <thead class="thead-dark">
                            <tr class="text-center">
                                <th scope="col">#</th>
                                <th scope="col">Room <i class="fas fa-sort"></i></th>
                                <th scope="col">Bed</th>
                               <!--  <th scope="col">Status</th> -->
                                <th scope="col">Add Booking</th>
                                <th scope="col">Update</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        
                      <% for(room.Room r : list) { %>
                      
                        <tbody>
                            <tr class="text-center">
                                <th scope="row" class="text-center"><%= r.getRoom_id() %></th>
                                <th><%= r.getRoom_no() %></th>                               
                                <td><select>
                                <% for (int i=1;i<=r.getBed_no();i++){ %>
                                 <option>
                                 Bed                                   
                                    <%= i %>
                                    </option> <% } %>
                                </select>
                                </td>
                                <!-- <td>
                                <form action="checkstatus" method="post">
        								<input type="hidden" name="room_no" value="<%= r.getRoom_no() %>">
        								<input type="hidden" name="bed_no" value="<%= r.getBed_no() %>">
        								<button type="submit" class="btn btn-light" >Check</button> 
       							</form>
       							 -->
                                
                                <td>
                                <form action="registerroom.jsp" method="post">
        								<input type="hidden" name="room_id" value="<%= r.getRoom_id() %>">
        								<button type="submit" class="btn btn-success" >Add</button> 
       							</form>
                                </td>
                                <td>
                                    <form action="updateroom.jsp" method="POST">
        								<input type="hidden" name="room_id" value="<%= r.getRoom_id() %>">
      									<button type="submit" class="btn btn-primary">Update</button>
        							</form> 
        						</td>
        						<td>                                  
                                    <form action="Deleteroom" method="POST">
        								<input type="hidden" name="room_id" value="<%= r.getRoom_id() %>">
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