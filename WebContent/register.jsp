<% if(session.getAttribute("status") != null) { %>
  <jsp:include page="header.jsp"></jsp:include>
    <body>
    <!-- Form -->
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="Addguest" method="post" id="form-register"><br>
                    <h1 class="text-center" style="color:black;">
                        Guest Registration
                    </h1>
                    <div class="form-group">
                        <label for="fname">
                            Name
                        </label>
                        <input type="text" name="guest_name" id="guest_name" class="form-control form control-lg"
                            placeholder="Enter guest name" required><br>
                        <label for="age">
                            Age
                        </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <label for="gender">
                            Gender
                        </label><br>
                        <input type="number" name="guest_age" id="guest_age" class="" placeholder="  Enter age" style="width: 25%"
                            required>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="guest_gender" id="guest_gender" value="male" required>
                        <label for="male">Male</label>&nbsp;&nbsp;
                        <input type="radio" name="guest_gender" id="female" value="female" required>
                        <label for="female">Female</label> <br>
                        <br><label for="email">
                            Email
                        </label>
                        <input type="email" name="guest_email" id="guest_email" class="form-control form control-lg"
                            placeholder="Enter email" required><br>
                        <label for="phone">
                            Phone Number
                        </label>
                        <input type="tel" name="guest_phone" id="guest_phone" class="form-control form control-lg"
                            placeholder="Enter phone number (e.g. 012-3456789)" pattern="[0-9]{3}-[0-9]{7,8}"
                            required><br>
                            <button type="reset" class="btn btn-dark" style="float: left;" value="reset">Reset</button>                        
                        <button type="submit" class="btn btn-success" style="float: right;"
                            value="submit">Confirm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<% } %>