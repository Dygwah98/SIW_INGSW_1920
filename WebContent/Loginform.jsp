<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>Nuovo</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/LoginForm.css" rel="stylesheet" type="text/css" />
</head>

<body>

<script type="text/javascript" src="js/1.js">
</script>

<div class="login-page">

<div class="form">

<form class="register-form">

 <input type="text" placeholder="name">
 <input type="password" placeholder="password">
 <input type="text" placeholder="email address">
 <button>create</button>

  <p class="message">Already registered? <a href="#">Sign In</a></p>
</form>


<form class="login-form" method="post" action="${pageContext.request.contextPath}/login">
   <input type="text" placeholder="username"/>
      <input type="password" placeholder="password"/>
       <button type="submit" id="btnLogin">LOGIN!</button>
      <p class="message">Not registered? <a href="RegistrationForm.html">Create an account</a></p>
    </form>
  </div>
</div>



</body>
</html>
