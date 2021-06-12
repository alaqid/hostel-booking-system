<% if(session.getAttribute("status") != null) { %>
<jsp:include page = "header.jsp"></jsp:include>
<%@ page import="room.*" %>
<%@ page import = "java.util.*" %>
<jsp:useBean id="Roommodel" scope="application" class="room.Roommodel"></jsp:useBean>
   <body>
    <!-- Form -->
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
            <% int id = Integer.parseInt(request.getParameter("room_id")); %>
			<% Room i = Roommodel.getRoomById(id);%>
                <form action="Roomupdate" method="post" id="form-register"><br>
                    <h1 class="text-center" style="color:black;">
                        Update Room
                    </h1>
                    <div class="form-group">
                        <label for="room">
                            Room Number
                        </label>                        
                            <input type="text" name="room_no" class="form-control" id="room_no" value="<%= i.getRoom_no() %>"><br>
                        <label for="bed">
                            Number of Bed
                        </label>
                        <input type="hidden" name="room_id" value="<%= i.getRoom_id() %>"></input>
                       <input type="text" name="bed_no" class="form-control" id="bed_no" value="<%= i.getBed_no() %>"><br><br>                        
                        <button type="submit" class="btn btn-success" style="float: right;" value="submit">Confirm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

<jsp:include page = "footer.jsp"></jsp:include>
<% } %>