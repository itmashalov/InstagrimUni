/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function takenusr(){
    alert("Sorry but wy in Dunasdasdasdasde");
      return false;
}

function validateForm(){
 var x=document.forms["myForm"]["usr"].value
 var y=document.forms["myForm"]["pass"].value 
 var z=document.forms["myForm"]["re-pass"].value;
 var nam=document.forms["myForm"]["name"].value;
 var address=document.forms["myForm"]["address"].value;
 var postcode=document.forms["myForm"]["postcode"].value;
 var phone=document.forms["myForm"]["phone"].value;
    
    document.getElementById("pchk").innerHTML
    
    
   
    if ((postcode.substring(0,2)!=="DD") && (postcode.substring(0,2)!=="dd") && (postcode.substring(0,2)!=="Dd") && (postcode.substring(0,2)!=="dD") ){ 
      alert("Sorry but we make deliveries only in Dundee");
      return false;
    }
 
    if (phone==null || phone==""){ 
      alert("The Phone must be filled out");
      return false;
    }
    if (postcode==null || postcode==""){ 
      alert("The Post Code must be filled out");
      return false;
    }
    if (address==null || address==""){ 
      alert("The address must be filled out");
      return false;
    }
    if (nam==null || nam==""){ 
      alert("The Name must be filled out");
      return false;
    }
    if (x==null || x==""){ 
      alert("The username must be filled out");
      return false;
    }
     else{
        if((x.length)<4){
         alert("The lenght of the username must be longer than 6 charecters");
         return false;
        }
     }
     if (y==null || y==""){ 
      alert("Password must be filled out");
     return false;
     }   
     else{
        if((y.length)<6){
        alert("The lenght of the password must be longer than 6 charecters");
        return false;
        }
     }  
     
     if (y!=z){   
      
        alert("The password doesn't match");
        return false;
     }
      var mail=document.forms["myForm"]["email"].value;
      var atpos=mail.indexOf("@");
      var dotpos=mail.lastIndexOf(".");

      if (atpos<1 || dotpos<atpos+2 || dotpos+2>=mail.length){
        alert("invalid e-mail !");
      }
    
    
 }
 function usrcheck1(){

 var x=document.forms["myForm"]["usr"].value;

 if((x.length)<3){
  document.getElementById("uchk").innerHTML="must be at least 4 characters long";
 }
 else{
  document.getElementById("uchk").innerHTML="ok";
 }


}
function passcheck1(){

 var y=document.forms["myForm"]["pass"].value;
 
 if((y.length)<5){
  document.getElementById("pchk").innerHTML="must be at least 6 characters long";
 } 
 
 else{
  document.getElementById("pchk").innerHTML="ok";
 }

}
function passcheck2(){

var z=document.forms["myForm"]["re-pass"].value;
var y=document.forms["myForm"]["pass"].value;
if (y!=z){  
      
   document.getElementById("repass").innerHTML="The password doesn't match";
}
else{
  document.getElementById("repass").innerHTML="ok";
 }




}

function namecheck(){

var x=document.forms["myForm"]["name"].value;

if (x== null || x==""){  
      
   document.getElementById("nam").innerHTML="You Must fill that field";
}
else{
  document.getElementById("nam").innerHTML="ok";
 }

}
function addrcheck(){

var x=document.forms["myForm"]["address"].value;

if (x== null || x==""){  
      
   document.getElementById("addr").innerHTML="You Must fill that field";
}
else{
  document.getElementById("addr").innerHTML="ok";
 }

}
function postcheck(){

var x=document.forms["myForm"]["postcode"].value;


if ((x!= null || x!="") && x.length>1){
  if(x.substring(0,2)=="dd" || x.substring(0,2)=="DD" || x.substring(0,2)=="dD"|| x.substring(0,2)=="Dd"){
      document.getElementById("pcode").innerHTML="ok";
      
  }
  else{
    document.getElementById("pcode").innerHTML="Sorry but we make deliveries only in Dundee";
  }
 }
 else{
  document.getElementById("pcode").innerHTML="You Must fill that field";
 }

}
function phonecheck(){

var x=document.forms["myForm"]["phone"].value;

if (x== null || x==""){  
      
   document.getElementById("phonechk").innerHTML="You Must fill that field";
}
else{
  document.getElementById("phonechk").innerHTML="ok";
 }

}


function mailchk(){

 var x=document.forms["myForm"]["email"].value
 var atpos=x.indexOf("@");
 var dotpos=x.lastIndexOf(".");

 if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
  document.getElementById("mchk").innerHTML="invalid e-mail !";
 }
 else{
  document.getElementById("mchk").innerHTML="ok";
 }

}