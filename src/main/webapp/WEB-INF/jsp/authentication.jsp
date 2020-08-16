<html>
<head>
  <title>Login Page</title>
</head>

<h2>Hello, please log in:</h2>

<form action="${pageContext.request.contextPath}/personList" method=get>
  <p><strong>Enter Login: </strong>
    <input type="text" name="login" size="25">
  <p><p><strong>Enter Password: </strong>
  <input type="password" size="15" name="password">
  <p><p>
  <input type="submit" value="Submit">
  <input type="reset" value="Reset">
  <a href="${pageContext.request.contextPath}/registration">Registration</a>
</form>
</html>