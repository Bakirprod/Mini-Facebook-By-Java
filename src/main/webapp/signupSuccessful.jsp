<%--
  Created by Seriaa Bakir--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>Sign Up - Success</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    body  {
      background-color: #f0f2f5;
    }

    a {
      text-decoration: none;
    }
    .signupsuccess {
      margin-top: 20%;
      margin-left: 10%;
      margin-right: 10%;
    }
    .logo {
      color: #1877f2;
      font-weight: bold;
    }
    .Facebook {
      font-size: 27px;
      line-height: 28px;
      width: auto;
      font-weight: 400;
    }
    .btn-primary:hover {
      background-color: #1b64c1;
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

  </style>
</head>
<body>
<main role="main" class="flex-shrink-0" id="left">
  <div class="container">
    <h1 class="mt-5"><img src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" alt="facebook"></h1>
    <p class="lead">Facebook helps you connect and share<br> with the people in your life.</p>
  </div>
</main>

<div class="container mt-5">
  <div class="row signupsuccess">
    <div class="col-lg-5">

      <div class="shadow p-3 mb-5 bg-body rounded text-center">

        <h3 class="mt-4 mb-3">Sign Up Successful</h3>
        <p class="mb-4">You can login now to connect and share with Friends and Families.</p>

        <a href= "Login.jsp" class="btn btn-primary btn-lg mt-3 mb-3">
          Login </a>

      </div>

    </div>

  </div>

</div>

</body>
</html>

