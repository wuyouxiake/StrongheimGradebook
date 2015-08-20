<!DOCTYPE html>
<html lang="en">
<head>
  <title>Gradebook</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Mackleberry</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
         <li><a href="GetList">Current List</a></li>
        <li><a href="form.jsp">Add Record</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container">
  <h3>Welcome to Professor Strongheim's Gradebook</h3>
</div>
<form action="allavg" method="get">
	<input type="hidden" name="action" value="homework">
	<input type="submit" value="Homework AVG" id="submit">
</form>

<form action="allavg" method="get">
	<input type="hidden" name="action" value="quiz">
	<input type="submit" value="Quiz AVG" id="submit">
</form>

<form action="allavg" method="get">
	<input type="hidden" name="action" value="test">
	<input type="submit" value="Test AVG" id="submit">
</form>

<form action="allavg" method="get">
	<input type="hidden" name="action" value="project">
	<input type="submit" value="Project AVG" id="submit">
</form>
<br>
<form action="allassignment" method="get">
	<input type="hidden" name="action" value="homework">
	<input type="submit" value="All Homework" id="submit">
</form>

<form action="allassignment" method="get">
	<input type="hidden" name="action" value="quiz">
	<input type="submit" value="All Quiz" id="submit">
</form>

<form action="allassignment" method="get">
	<input type="hidden" name="action" value="test">
	<input type="submit" value="All Test" id="submit">
</form>

<form action="allassignment" method="get">
	<input type="hidden" name="action" value="project">
	<input type="submit" value="All Project" id="submit">
</form>


//highst and lowest homework
<form action="high_low_for_one" method="get">
	<input type="hidden" name="action" value="homework">
	<input type="hidden" name="method" value="high">
	<input type="submit" value="Highest Homework" id="submit">
</form>
<form action="high_low_for_one" method="get">
	<input type="hidden" name="action" value="homework">
	<input type="hidden" name="method" value="low">
	<input type="submit" value="Lowest Homework" id="submit">
</form>
<br>
//highst and lowest quiz
<form action="high_low_for_one" method="get">
	<input type="hidden" name="action" value="quiz">
	<input type="hidden" name="method" value="high">
	<input type="submit" value="Highest Quiz" id="submit">
</form>
<form action="high_low_for_one" method="get">
	<input type="hidden" name="action" value="quiz">
	<input type="hidden" name="method" value="low">
	<input type="submit" value="Lowest Quiz" id="submit">
</form>

<br>
//highst and lowest test
<form action="high_low_for_one" method="get">
	<input type="hidden" name="action" value="test">
	<input type="hidden" name="method" value="high">
	<input type="submit" value="Highest Test" id="submit">
</form>
<form action="high_low_for_one" method="get">
	<input type="hidden" name="action" value="test">
	<input type="hidden" name="method" value="low">
	<input type="submit" value="Lowest Test" id="submit">
</form>
<br>
//highst and lowest project
<form action="high_low_for_one" method="get">
	<input type="hidden" name="action" value="project">
	<input type="hidden" name="method" value="high">
	<input type="submit" value="Highest Project" id="submit">
</form>
<form action="high_low_for_one" method="get">
	<input type="hidden" name="action" value="project">
	<input type="hidden" name="method" value="low">
	<input type="submit" value="Lowest Project" id="submit">
</form>
	



</body>
</html>

