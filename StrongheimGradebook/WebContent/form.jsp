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
        <li><a href="GetAvg">Avg Grade</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
  <h2>Assignment Grade</h2>
  <form class="form-horizontal" role="form" method="post" action="AddToList">
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="studentid">Student ID:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="studentid" placeholder="Enter Student ID" name="studentid">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="assignmentname">Assignment Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="assignmentname" placeholder="Enter Assignment Name" name="assignmentname">
      </div>
    </div> 
   
    <div class="form-group">
      <label class="control-label col-sm-2" for="type">Assignment Type:</label>
      <div class="col-sm-10">
					<select id="type" name="type" REQUIRED>
						<option value="homework">Homework</option>
						<option value="quiz">Quiz</option>
						<option value="test">Test</option>
						<option value="project">Project</option>
					</select> 
      </div>
    </div> 
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="assignmentdate">Assignment Date:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="assignmentdate" placeholder="Enter Assignment Date" name="assignmentdate">(MM/DD/YYYY)
      </div>
    </div> 
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="grade">Grade:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="grade" name="grade" placeholder="Enter grade">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <input type="submit" value="Submit" id="submit">
      </div>
    </div>
  </form>
</div>

</body>
</html>
