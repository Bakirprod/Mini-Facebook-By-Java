<%--
  Created by Seriaa Bakir--%>
  <%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>FaceBook Login - SignUp</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #F0F2F5 !important;
        }

        #left{
            margin-top: 11rem;
            margin-left: 9rem;
            width: 40rem;
        }

        .container img {
            width: 18rem;
            height: 6rem;
            margin-left: -38px;
        }
        .container p {
            margin-top: 0.5rem;
            FONT-FAMILY:SFProDisplay-Regular, Helvetica, Arial, sans-serif;
            FONT-SIZE: 28px;
            LINE-HEIGHT : 32px;
        }

        /*#loginform{*/
        /*    float: right;*/
        /*    margin-top: -15rem;*/
        /*    margin-right:-25rem;*/
        /*    height: 348px;*/
        /*    background-color: red;*/
        /*}*/

        .card {
            float: right;
            width: 25rem;
            margin-right: 15rem;
            margin-top: -15rem;
            height: 21rem;
        }
        .submitbtn{
            background-color: #1877f2;
            border: none;
            border-radius: 6px;
            font-size: 20px;
            color: white;
            line-height: 48px;
            padding: 0 16px;
            width: 100%;
        }
        .createAccountBtn {
            background-color: #36A420 !important;
            border: none;
            border-radius: 6px;
            font-size: 15px;
            color: white;
            padding: 0 16px;
            width: 60%;
            height: 13%;
            margin-top: 1rem;
            margin-left:5%;
        }
        .signup{
            background-color: #36A420 !important;
            border: none;
            border-radius: 6px;
            font-size: 20px;
            color: white;
            padding: 0 16px;
            width: 30%;
            height: 28%;
            margin-top: 1rem;
            margin-left:5%;
        }

        .dob{
            display: flex;
            justify-content: right;
            margin-left: 2rem;
            width: 20%;
        }
        #terms{
            font-size: 10px;
        }

        #errorMessage{
            color:red;
            text-align: center;
        }



    </style>
</head>
<body>
<main role="main" class="flex-shrink-0" id="left">
    <div class="container">
        <h1 class="mt-5"><img src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" alt="facebook"></h1>
        <p class="lead">Facebook helps you connect and share<br> with the people in your life.<br>Created By Seriaa Bakir</p>
    </div>
</main>

<div class="card">
    <div class="card-body">
        <form action="Check_User" method="post">
            <div class="form-group">
                <label for="Username"></label>
                <input name="username" type="text" class="form-control" id="Username" aria-describedby="emailHelp" placeholder="Username">
            </div>
            <div class="form-group">
                <label for="password"></label>
                <input name="password" type="password" class="form-control" id="password" placeholder="Password">
            </div>
            <button type="submit" class="submitbtn">Login</button>
            <br><br>
            <hr>
            <div>
                <button type="button" data-toggle="modal" data-target="#exampleModal" class="signupBtn createAccountBtn">Create New Account</button>
            </div>
            <br><br>
        </form>
    </div>
</div>

<!-- Button trigger modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Sign Up</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form action="register" method="post">

                    <!-- Grid row -->
                    <div class="form-row">

                        <!-- Default input -->
                        <div class="form-group col-md-6">
                            <label for="inputEmail4"></label>
                            <input type="text" class="form-control" id="inputEmail4" placeholder="UserName" name="username" required>
                        </div>

                    </div>

                    <!-- Grid row -->
                    <!-- Default input -->
                    <div class="form-group">
                        <label for="Phone No"></label>
                        <input type="text" class="form-control" id="Phone No" placeholder="Phone No" name="phone" required>
                    </div>

                    <!-- Default input -->
                    <div class="form-group">
                        <label for="Password"></label>
                        <input type="password" class="form-control" id="Password" placeholder="Password" name="password" required>
                    </div>

                    <!-- Grid row -->
                    <label class="dob"> Date Of Birth</label>
                    <div class="form-row">
                        <label for="birthday"></label><input type="date" id="birthday" name="dob">
                    </div>
                    <br>
                    <label class="gender">Gender</label>
                    <div class="form-row">
                        <!-- Grid row -->
                        <div id="gender">
                            <span class="_5k_3" data-type="radio" data-name="gender"></span>

                            <span class="_5k_2 _5dba"><label class="_58mt">Male</label>
                                <label><input type="radio" class="_8esa" name="gender" value="Male"></label>
                            </span>

                            <span class="_5k_3" data-type="radio" data-name="gender"></span>

                            <span class="_5k_2 _5dba"><label class="_58mt">Female</label>
                                <label><input type="radio" class="_8esa" name="gender" value="Female"></label>
                            </span><br>

                            <span id="terms">By clicking Sign Up, you agree to our Terms, Data Policy and Cookie Policy.
                                You may receive SMS notifications from us and can opt out at any time.</span><br>
                            <div>
                                <button type="submit" class="signup btn btn-primary btn-md">Sign Up</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
</body>
</html>
