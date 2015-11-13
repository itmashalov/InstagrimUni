<html>
<head>
<title>JSP and Servlet using AJAX</title>
<script type="text/javascript">

function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}

var xmlhttp = new getXMLObject();	//xmlhttp holds the ajax object

function ajaxFunction() {
  var getdate = new Date();  //Used to prevent caching during ajax call
  if(xmlhttp) {
       var data=document.getElementById("butt").value;
       
    xmlhttp.open("POST","AddCommentServlet?comment=" + data,true); //gettime will be the servlet name
    xmlhttp.onreadystatechange  = handleServerResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send();
  }
}

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
       document.getElementById("test").innerHTML =xmlhttp.responseText; //Update the HTML Form element
     }
     else {
        alert("Error during AJAX call. Please try again");
     }
   }
}
</script>
<body>
<form name="myForm">
Server Time:<input type="text" name="time" id="butt" value="lal"/>
<br />
<input   type="button" onmouseover="javascript:ajaxFunction();" value="Click to display Server Time on Textbox"/>
<br />
</form>
    <p  id="test">
    </p>
    
</body>
</head>
</html>