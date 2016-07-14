<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<body>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
 
<ul>

<div class="row">
  <div class="col-lg-4">
  <li><a class="active" href="#bullhorn">Bullhorn</a></li>
  <li><a href="#news">News</a></li>
  </div>
  
<div class="col-lg-4">Minion Fans!</div>  

 <div class="col-lg-4">  
      <div class="container">
      <h2>Button States</h2>
      <a class="Profile" href="<%=request.getContextPath()%>/Profile">My Profile</a>
      <a class="SignOut" href="<%=request.getContextPath()%>/SignOut">SignOut</a>
      </div>
 </div>  
   
</div>

</ul>


<li><a href="ProfileServlet?userid=${user.bhuserid}&action=viewprofile"><img alt="${user.username}" src="${gravatarURL}"/>&nbsp;${user.username}</a></li>


</body>
</html>

