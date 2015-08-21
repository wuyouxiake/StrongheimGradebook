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
<div class="container">
<h1><b>${outputText}</b></h1>
  <h3>Physics</h3>
  <ul>
  	<li>Homework AVG: ${p_homeworkavg}</li>
  	<li>Quiz AVG: ${p_quizavg}</li>
  	<li>Test AVG: ${p_testavg}</li>
  	<li>Project AVG: ${p_projectavg}</li>
  	<li>Physics GPA: ${physicsGPA}</li>
  </ul>       
  
  <h3>Earth Science</h3>
  <ul>
  	<li>Homework AVG: ${e_homeworkavg}</li>
  	<li>Quiz AVG: ${e_quizavg}</li>
  	<li>Test AVG: ${e_testavg}</li>
  	<li>Project AVG: ${e_projectavg}</li>
  	<li>Earth Science GPA: ${earthscienceGPA}</li>
  </ul>       
  
  <h3>History</h3>
  <ul>
  	<li>Homework AVG: ${h_homeworkavg}</li>
  	<li>Quiz AVG: ${h_quizavg}</li>
  	<li>Test AVG: ${h_testavg}</li>
  	<li>Project AVG: ${h_projectavg}</li>
  	<li>History GPA: ${historyGPA}</li>
  </ul>     
  
  <h3>Math</h3>
  <ul>
  	<li>Homework AVG: ${m_homeworkavg}</li>
  	<li>Quiz AVG: ${m_quizavg}</li>
  	<li>Test AVG: ${m_testavg}</li>
  	<li>Project AVG: ${m_projectavg}</li>
  	<li>Math GPA: ${mathGPA}</li>
  </ul>     
  
</div>

</body>
</html>
