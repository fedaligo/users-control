<html>
<head>
    <title>Login Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">USERS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<div class="navbar-text mt-3"><h2>Hello, please log in:</h2></div>

<form action="${pageContext.request.contextPath}/personList" method=get>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Enter Login:</label>
        <div class="col-sm-2">
            <input type="text" name="login" class="form-control" placeholder="Login"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Enter Password:</label>
        <div class="col-sm-2">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <p>
    <p>
  <button class="btn btn-primary" type="submit">Sign In</button>
  <button class="btn btn-primary" type="reset">Clear</button>

        <a href="${pageContext.request.contextPath}/registration">Registration</a>
</form>
</body>

</html>