<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Slider - Colorpicker</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
  #red, #green, #blue {
    float: left;
    clear: left;
    width: 300px;
    margin: 15px;
  }
  #swatch {
    width: 120px;
    height: 100px;
    margin-top: 18px;
    margin-left: 350px;
    background-image: none;
  }
  #red .ui-slider-range { background: #ef2929; }
  #red .ui-slider-handle { border-color: #ef2929; }
  #green .ui-slider-range { background: #8ae234; }
  #green .ui-slider-handle { border-color: #8ae234; }
  #blue .ui-slider-range { background: #729fcf; }
  #blue .ui-slider-handle { border-color: #729fcf; }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script>
  $( function() {
	  
    function hexFromRGB(r, g, b) {
      var hex = [
        r.toString( 16 ),
        g.toString( 16 ),
        b.toString( 16 )
      ];
      $.each( hex, function( nr, val ) {
        if ( val.length === 1 ) {
          hex[ nr ] = "0" + val;
        }
      });
      return hex.join( "" ).toUpperCase();
    }
    function refreshSwatch() {
      var red = $( "#red" ).slider( "value" ),
        green = $( "#green" ).slider( "value" ),
        blue = $( "#blue" ).slider( "value" ),
        hex = hexFromRGB( red, green, blue );
      $( "#swatch" ).css( "background-color", "#" + hex );
      $( "#colour" ).css( "background-color", "#" + hex );
    }
 
    $( "#red, #green, #blue" ).slider({
      orientation: "horizontal",
      range: "min",
      max: 255,
      value: 127,
      slide: refreshSwatch,
      change: refreshSwatch
    });
    $( "#red" ).slider( "value", 255 );
    $( "#green" ).slider( "value", 140 );
    $( "#blue" ).slider( "value", 60 );
  } );
  </script>
</head>
<body id="colour">
<h1>Resturant List</h1>
<div class="container">

<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr><th>ResturantId</th><th>RestName</th><th>RestAddress</th><th>RestDescription<th></tr>
    </thead>
    <tbody>
    
    <c:forEach var="post" items="${posts}">
    
       <tr>
<!--        <td><a href="ResturantDetails?resturantid=1">Resturant Name</a> -->
       <td><a href="ResturantList?resturantid=<c:out value="${post.resturantid}"/>"name="linkresturandid" >${post.resturantid}</a></td>
        <td><c:out value="${post.restname}"/></td>
        <td><c:out value="${post.restaddress}" /></td>
        <td><c:out value="${post.restdescription}" /></td>
        </tr>
      
    </c:forEach>
    
    
    </tbody>
    </table>

</div>

<body class="ui-widget-content" style="border:0;">
 

 
<div id="red"></div>
<div id="green"></div>
<div id="blue"></div>
 

 
 
</body>

</body>
</html>