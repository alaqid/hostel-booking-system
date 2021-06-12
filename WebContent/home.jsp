 <jsp:include page="header.jsp"></jsp:include>
 <body>
    <!--- Image Slider -->
	<div id="slides" class="carousel slide" data-ride="carousel">
		<ul class="carousel-indicators">
			<li data-target="#slides" data-slide-to="0" class="active"></li>
			<li data-target="#slides" data-slide-to="1"></li>
			<li data-target="#slides" data-slide-to="2"></li>
		</ul>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="back1.jpg">
				<div class="carousel-caption">
					<h1 class="display-2">Mondstadt</h1>
					<h3>Hostel Management System</h3>					
					<button type="button" class="btn btn-outline-light btn-lg" >
						Get Started
                    </button>
                    </div>
			</div>
			<div class="carousel-item">
				<img src="back2.jpg">
			</div>
			<div class="carousel-item">
				<img src="back.png">
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>