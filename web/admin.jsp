<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Person"%>
<!DOCTYPE html>
</html>
<head>
    <title>Welcome Admin!</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
    <nav>
        <div class="nav-wrapper cyan darken-1">
            <a href="#!" class="brand-logo">Toodoo</a>
            <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="#">Something</a></li>
                <form action="Logout" method="post">
                    <li><button type="submit">Logout</button></li>
                </form>
            </ul>
            <ul class="side-nav" id="mobile-demo">
                <li><a href="#">Something</a></li>
                <li><a href="#">Component</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </div>
    </nav>
    <div style="margin: 2em 10em 0 10em">
        <h4>Toodoo Users</h4>
        <div class="row">
            <form action="Admin" method="POST">
                <table class="bordered highlight">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Username</th>
                            <th>Status</th>
                        <tr>
                    </thead>
                    <tbody>
                        <c:forEach var="personList" items="${userList}">
                            <tr>
                                <td>${personList.firstName}</td>
                                <td>${personList.lastName}</td>
                                <td>${personList.userName}</td>
                                <td><button type="submit" name="adminButton" value="${personList.userName}">${personList.status}</button></td>
                            <tr>
                         </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
</body>
</html>