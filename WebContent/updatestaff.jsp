<% if(session.getAttribute("status") != null) { %>
<jsp:include page = "header.jsp"></jsp:include>
<%@ page import="staff.*" %>
<%@ page import = "java.util.*" %>
<jsp:useBean id="StaffModel" scope="application" class="staff.StaffModel"></jsp:useBean>

    <!-- Form -->
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
            <% int id = Integer.parseInt(request.getParameter("staff_id")); %>
			<% Staff s = StaffModel.getStaffById(id);%>
                <form action="Updatestaff" method="post" id="form-register" enctype="multipart/form-data"><br>
                    <h1 class="text-center" style="color:black;">
                        Update Staff
                    </h1>
                    <div class="form-group">
                        <label>
                            Name
                        </label>
                        <input type="text" name="staff_name" id="staff_name" class="form-control form control-lg"
                            placeholder="Enter staff name" required value="<%= s.getStaff_name() %>" ><br>
                        <label >
                            Identification Number
                        </label>
                        <input type="tel" name="staff_ic" id="staff_ic" class="form-control form control-lg"
                            placeholder="Enter staff IC (e.g. 999999-99-9999)" pattern="[0-9]{6}-[0-9]{2}-[0-9]{4}"
                            required value="<%= s.getStaff_ic() %>" ><br>
                        <label for="position">
                            Position
                        </label>
                        <input type="text" name="staff_position" id="staff_position" class="form-control form control-lg"
                            placeholder="Enter staff position" required value="<%= s.getStaff_position() %>" ><br>                        
                        <label for="email">
                            Email
                        </label>
                        <input type="email" name="staff_email" id="staff_email" class="form-control form control-lg"
                            placeholder="Enter email" required value="<%= s.getStaff_email() %>" ><br>
                        <label for="phone">
                            Phone Number
                        </label>
                        <input type="tel" name="staff_phone" id="staff_phone" class="form-control form control-lg"
                            placeholder="Enter phone number (e.g. 012-3456789)" pattern="[0-9]{3}-[0-9]{7,8}"
                            required value="<%= s.getStaff_phone() %>" ><br>
                        <label>
                            Address
                        </label>
                        <textarea  name="staff_address" id="staff_address" class="form-control form control-lg"
                            placeholder="" required > <%= s.getStaff_address() %>
                        </textarea><br>
                        
                        <div class="form-group">
                            <label for="">Staff Image</label><br>
                            <br>
                            <input type="file" class="input-group"
                            name="image" onchange="readURL(this);" required> <br>
                            <img id="img_preview"   class="img-responsive" />
                        </div>
                            
						<input type="hidden" name="staff_id" value="<%= s.getStaff_id() %>"></input>
                            <button type="reset" class="btn btn-dark" style="float: left;" value="reset">Reset</button>
                            <button type="submit" class="btn btn-success" style="float: right;"
                                value="submit">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<% } %>