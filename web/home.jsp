<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Person"%>
<%@page import="Model.Task"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TooDoo</title>
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

        <div style="margin: 2em 4em 0 4em">
            <div class="row">
                <ul class="collapsible col s4" data-collapsible="accordion">
                    <li>
                        <div class="collapsible-header">
                            <i class="material-icons">date_range</i>
                            Timeline
                        </div>
                        <div class="collapsible-body">
                            <p>
                                <input class="with-gap" name="group1" type="radio" id="rad1" />
                                <label for="rad1">Today</label>
                            </p>
                            <p>
                                <input class="with-gap" name="group1" type="radio" id="rad2" />
                                <label for="rad2">This Week</label>
                            </p>
                            <p>
                                <input class="with-gap" name="group1" type="radio" id="rad3" />
                                <label for="rad3">This Month</label>
                            </p>
                            <p>
                                <input class="with-gap" name="group1" type="radio" id="rad4" />
                                <label for="rad4">This Year</label>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="collapsible-header">
                            <i class="material-icons">place</i>
                            Something
                        </div>
                        <div class="collapsible-body"><p>${Notify}</p></div>
                    </li>
                </ul>

                <!--TEXTFIELD-->
                <div>
                <form action="Control" method="POST" class="col s8">
                <div>
                        <div class="row" style="margin-top: 1em">
                            <div class="input-field col s12">
                                <input name="taskAdd" id="task" type="text" class="validate" value="${presentTask}">
                            </div>
                            ${Notify}   
                            <div style="float: right; margin-right: 1em">
                                <button type="submit" class="waves-effect waves-light yellow darken-2 btn" name="button" value="${buttonName}">${buttonName}</button></div>
                        </div>
                </div>
                    <center>    
                        <table class="tasks" id="sortable" style="width: 850px">    
                            <tr class="ui-state-default">
                                <th></th>
                                <th></th>
                                <th></th>
                            </tr>
                            <c:forEach var="taskList" items="${Tasks}">
                                <tr class="card yellow lighten-3 ui-state-default" style="margin-bottom: 5px">
                                    <td class="card-content cursor-move">${taskList.task}</td>
                                    <td class="card-content" style="float: right">
                                        <button type="submit" name="button" id="editButton" class="waves-effect waves-light amber accent-4 btn" value="prepareUpdate,${taskList.task}"><i class="material-icons"></i></button>
                                    </td>
                                    <td class="card-content" style="margin: 0 3px 0 3px">
                                        <button type="submit" name="button" id="deleteButton" class="waves-effect waves-light deep-orange darken-1 btn" value="Delete,${taskList.task}"><i class="material-icons"></i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </center>
                    </form>
                </div>
            </div>

        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </body>
</html>
