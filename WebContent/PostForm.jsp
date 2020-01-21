<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <title>Post</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
  <link href="styles/PostForm.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form class="decor"  method="post" action="${pageContext.request.contextPath}/NewPost">
  <div class="form-left-decoration"></div>
  <div class="form-right-decoration"></div>
  <div class="circle"></div>
  <div class="form-inner">
    <h3>New Post</h3>
    <input type="text" name="titolo" placeholder="Title">
    <input type="text" name="img"placeholder="Insert image..">
    <textarea id="msg" name="messaggio" cols="20" rows="5" placeholder="Submit your text post here..."></textarea> 
    <input type="submit" value="Conferma">
  </div>
</form>
</body>
</html>
