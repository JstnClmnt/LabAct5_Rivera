<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign up</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="css/styles.css">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body style="background-color: #b3e5fc">
        <div class="reg-wrap">
            <form action="Register" method="POST" class="col-s12 row z-depth-1" style="padding: 2em 2em; background-color: white">
                <h5>Sign up</h5><br>
                <div class="row">
                    <div class="input-field col s12">
                        <input name="firstname" id="firstname" type="text" class="validate">
                        <label for="firstname">First Name</label>
                    </div>
                    <div class="input-field col s12">
                        <input name="lastname" id="lastname" type="text" class="validate">
                        <label for="lastname">Last Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input name="username" id="username" type="text" class="validate">
                        <label for="username">Username</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="password" id="password" type="password" class="validate">
                        <label for="password">Password</label>
                    </div>
                </div>
                
                <center><button class="waves-effect waves-light yellow darken-2 btn">Submit</button></center>
            </form>
        </div>

        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>
    </body>
</html>
