<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mondstadt</title>
    
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cerulean/bootstrap.min.css"
        integrity="sha384-3fdgwJw17Bi87e1QQ4fsLn4rUFqWw//KU0g8TvV6quvahISRewev6/EocKNuJmEw" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="https://m.w3newbie.com/you-tube.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
    <link href="style.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
</head>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><img src="3.png"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home.jsp">Home</a>
                    </li>
                    <% if(session.getAttribute("status") != null) { %>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Guest
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="register.jsp">Guest Registration</a>
                            <a class="dropdown-item" href="records.jsp">Guest Records</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Room/Bed
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="roomstatus.jsp">Room/Bed List</a>
                            <a class="dropdown-item" href="addroom.jsp">Add New Room</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Staff
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="staffrecords.jsp">Staff Records</a>
                            <a class="dropdown-item" href="staffregister.jsp">Add New Staff</a>
                        </div>
                    </li><% } %>
                    <li class="nav-item">
                        <ul class="navbar-nav navbar-right">
    	<% 	if(session.getAttribute("status") != null) {
    			if(session.getAttribute("status").equals("loggedin")) { %>
    				<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a></li>
    	<%		}
    		}
	    	else { %>
	    		<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
	    <%  } %>
    </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
	
	<%
		if(session.getAttribute("success") != null) {	%>
			<div class="alert alert-success alert-dismissible fade show" role="alert">
			  <%=session.getAttribute("success") %>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
	<%		session.removeAttribute("success");
		}
	%>
	
	<%
		if(session.getAttribute("danger") != null) {	%>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
			  <%=session.getAttribute("danger") %>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
	<%		session.removeAttribute("danger");
		}
	%>
</div>	
    <body class="all-browsers">