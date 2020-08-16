<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<a href="${pageContext.request.contextPath}/authentication">Back to main</a>

<form action="regservlet" method=post>
    <p><strong>Please Enter Login: </strong>
        <input type="text" name="login" size="25">
    <p><p><strong>Please Enter Password: </strong>
    <input type="password" size="15" name="password">
    <p><strong>Please Enter Mail: </strong>
        <input type="text" name="mail" size="25">
    <p><p>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>

</body>

</html>