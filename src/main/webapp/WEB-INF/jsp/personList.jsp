<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div>
    <form  method="post" action="controlservlet">
        <div class="toolbar">
            <div class="toolbar_inner">
                <a name="block"><img src="http://cdn.onlinewebfonts.com/svg/download_320758.png" width="25" height="25" alt="block"></a>
                <input type="submit" name="block" value="block" />
                <a name="block"><img src="http://cdn.onlinewebfonts.com/svg/img_15042.png" width="25" height="25" alt="unblock"></a>
                <input type="submit" name="unblock" value="unblock" />
                <a name="block"><img src="http://cdn.onlinewebfonts.com/svg/img_198571.png" width="25" height="25" alt="delete"></a>
                <input type="submit" name="delete" value="delete" />

            </div>
            <div class="toolbar_inner2">
                <a href="${pageContext.request.contextPath}/authentication">Back to main</a>
            </div>
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
            <c:forEach  items="${persons}" var ="person">
                <tr>
                    <td><input type="checkbox" name="checkbox" id="checkbox" value="${person.id}" /></td>
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
        document.getElementById('select_all')
            .addEventListener('click', function (e) {
                var els = document.querySelectorAll(
                    'input[name=checkbox]'
                );

                Array.prototype.forEach.call(els, function(cb){
                    cb.checked = e.target.checked;
                });
            })
        ;
    </script>
</div>
</body>

</html>