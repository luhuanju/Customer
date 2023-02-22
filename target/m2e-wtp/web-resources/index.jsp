<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>My JSP Page</title>
	   <style>
      /* Center the form */
      form,h1 {
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      
      label {
        margin: 10px;
      }
      input[type="submit"] {
        margin-top: 20px;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
      input[type="submit"]:hover {
        background-color: #3e8e41;
      }
    </style>
</head>
<body>
	<h1>Enter User Data</h1>
<!-- 	<form method="post" action="dbInfo">
		<label for="name">Name:</label>
		<input type="text" id="name" name="name"><br>
		<label for="email">Id  :  </label>
		<input type="text" id="id" name="id"><br>
		<input type="submit" value="Submit">
	</form> -->
	
	<form action="register" method="post">
	
	
	  <label for="id">Id:</label>
      <input type="text" id="id" name="id"><br>
      
      
      <label for="name">Name:</label>
      <input type="text" id="name" name="name"><br>


      <label for="accountType">Account Type:</label>
      <textarea id="accountType" name="accountType"></textarea><br>
      
      <label for="address">Address:</label>
      <input type="text" id="address" name="address"><br>

      <input type="submit" value="Submit">
    </form>
</body>
</html>