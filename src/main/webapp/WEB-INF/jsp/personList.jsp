<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Person List</title>
    <link rel="stylesheet" href="/static/style.css"/>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
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

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">USERS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item">
                <button onclick="blockClick()" type="submit" name="bl" value="bl" class="btn btn-default btn-lg ml-2">
                    <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-lock-fill" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M2.5 9a2 2 0 0 1 2-2h7a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2h-7a2 2 0 0 1-2-2V9z"/>
                        <path fill-rule="evenodd" d="M4.5 4a3.5 3.5 0 1 1 7 0v3h-1V4a2.5 2.5 0 0 0-5 0v3h-1V4z"/>
                    </svg>
                </button>
            </li>
            <li class="nav-item">
                <button onclick="unblockClick()" type="submit" name="unbl" value="unbl"
                        class="btn btn-default btn-lg ml-2">
                    <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-unlock-fill" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M.5 9a2 2 0 0 1 2-2h7a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2h-7a2 2 0 0 1-2-2V9z"/>
                        <path fill-rule="evenodd" d="M8.5 4a3.5 3.5 0 1 1 7 0v3h-1V4a2.5 2.5 0 0 0-5 0v3h-1V4z"/>
                    </svg>
                </button>
            </li>
            <li class="nav-item">
                <button onclick="deleteClick()" type="submit" name="del" value="del"
                        class="btn btn-default btn-lg ml-2">
                    <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd"
                              d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                    </svg>
                </button>
            </li>
        </ul>
        <div class="navbar-text mr-3" id="login">
        </div>
        <div>
            <form action="/">
                <button class="btn btn-primary" type="submit">Sign Out</button>
            </form>
        </div>
    </div>
</nav>


<div>
    <form method="post" action="controlservlet">

        <div hidden class="container mt-1">
            <button id="block" class="button" type="submit" name="block" value="block">Block</button>
            <button id="unblock" class="button" type="submit" name="unblock" value="unblock">UnBlock</button>
            <button id="delete" class="button" type="submit" name="delete" value="delete">Delete</button>
        </div>
        <br/>
        <table border="2" cellpadding="3" width="60%">
            <tr>
                <th><input id="select_all" type="checkbox"></th>
                <th>Id</th>
                <th>Login</th>
                <th>Password</th>
                <th>Mail</th>
                <th>Create</th>
                <th>Logged</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${persons}" var="person">
                <tr>
                    <td><input type="checkbox" name="checkbox" id="checkbox" value="${person.id}"/></td>
                    <td>${person.id}</td>
                    <td>${person.login}</td>
                    <td>${person.password}</td>
                    <td>${person.mail}</td>
                    <td>${person.create}</td>
                    <td>${person.logged}</td>
                    <td>${person.status}</td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <script>
        document.getElementById('login').innerHTML = window.location.search.slice(1).split('&')[0].split('=')[1];
        document.getElementById('select_all')
            .addEventListener('click', function (e) {
                var els = document.querySelectorAll(
                    'input[name=checkbox]'
                );

                Array.prototype.forEach.call(els, function (cb) {
                    cb.checked = e.target.checked;
                });
            })
        ;
    </script>
    <script>
        function blockClick() {
            var button = document.querySelector('#block');
            button.click();
        };

        function unblockClick() {
            var button = document.querySelector('#unblock');
            button.click();
        };

        function deleteClick() {
            var button = document.querySelector('#delete');
            button.click();
        };
    </script>
</div>
</body>

</html>