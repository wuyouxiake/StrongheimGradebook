<!DOCTYPE html>
<html lang="en">
<head>
<title>Detail</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">Strongheim</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					 <li><a href="GetList">Current List</a></li>
        			<li><a href="form.jsp">Add Record</a></li>
        			<li><a href="changeweight.jsp">Change Weight</a></li>
        			<li><a href="search.jsp">Summary by Student</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<p>Request Details for student ${studentid}</p>

<form action="studentdetail?studentid=${studentid}" method="get">
	<input type="hidden" name="action" value="all">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="submit" value="All Assignment" id="submit">
</form>

<form action="studentdetail?studentid=${studentid}" method="get">
	<input type="hidden" name="action" value="homework">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="submit" value="Homework" id="submit">
</form>

<form action="studentdetail?studentid=${studentid}" method="get">
	<input type="hidden" name="action" value="quiz">
		<input type="hidden" name="studentID" value="${studentid}">
	<input type="submit" value="Quiz" id="submit">
</form>

<form action="studentdetail" method="get">
	<input type="hidden" name="action" value="test">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="submit" value="Test" id="submit">
</form>

<form action="studentdetail?studentid=${studentid}" method="get">
	<input type="hidden" name="action" value="project">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="submit" value="Project" id="submit">
</form>	
<br>
<form action="studentavg" method="get">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="hidden" name="action" value="none">
	<input type="submit" value="All Avg" id="submit">
</form>	
 
 <form action="studentavg" method="get">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="hidden" name="action" value="homework">
	<input type="submit" value="Avg Homework" id="submit">
</form>	

<form action="studentavg" method="get">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="hidden" name="action" value="quiz">
	<input type="submit" value="Avg Quiz" id="submit">
</form>	

<form action="studentavg" method="get">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="hidden" name="action" value="test">
	<input type="submit" value="Avg Test" id="submit">
</form>	

<form action="studentavg" method="get">
	<input type="hidden" name="studentID" value="${studentid}">
	<input type="hidden" name="action" value="project">
	<input type="submit" value="Avg Project" id="submit">
</form>

<br>


</body>
</html>