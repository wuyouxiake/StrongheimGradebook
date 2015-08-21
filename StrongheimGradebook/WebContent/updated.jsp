<!DOCTYPE html>
<html lang="en">
<head>
  <title>Weights Updated</title>
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
<h1>Successful!</h1>
<table class="table table-condensed">
    <thead>
      <tr>
        <th>Homework: </th>
        <th>Quiz: </th>
        <th>Test: </th>
        <th>Project: </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${homework}</td>
        <td>${quiz}</td>
        <td>${test}</td>
        <td>${project}</td>
      </tr>
    </tbody>
  </table>
  <a href="index.jsp">Go back to home page</a>
</body>
</html>