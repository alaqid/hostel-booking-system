<% if(session.getAttribute("status") != null) { %>
  <jsp:include page="header.jsp"></jsp:include>
    <body>
    <!-- Form -->
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="Addroom" method="post" id="form-register"><br>
                    <h1 class="text-center" style="color:black;">
                        Add New Room
                    </h1>
                    <div class="form-group">
                        <label for="room">
                            Room Number
                        </label>
                        <input type="number" name="room" id="room" class="form-control form control-lg"
                            placeholder="Enter room number" required><br>
                        <label for="bed">
                            Number of Bed
                        </label>
                        <input type="number" name="bed" id="bed" class="form-control form control-lg"
                            placeholder="Enter number of bed" required><br>
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