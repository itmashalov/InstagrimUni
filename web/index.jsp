<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>MyInstaGallery University Project</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Item Blur Effect with CSS3 and jQuery - Using Box Shadows, Transform and Transitions" />
        <meta name="keywords" content="blur, css3, transition, jquery, box shadow, text shadow, articles, scale, transform, animation" />
        <meta name="author" content="Codrops" />
        
	    <link rel="stylesheet" type="text/css" href="css/buttons.css" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		 <script type="text/javascript" src="scripts/jquery/jquery-2.1.1.js"  ></script>
		<script src="js/modernizr.custom.34978.js"></script>	
	
		<script> 
		 		setTimeout(function(){
	
					document.getElementById('ib-container').style.display ="table";
				$("#ib-container").animate({top	: "120%",
									opacity: '1.0' },2000);
				},500); 
					 
				
				setTimeout(function(){
	//document.getElementById('ib-container').style.display ="none";
				$("#ib-container").animate({ 
									opacity: '0.0' },1000);
				},1500); 
				
				setTimeout(function(){
				$("#ib-container").animate({ 
									opacity: '1.0' },1000);
									
				 
				},2500); 
				
				setTimeout(function(){						
				var audio = new Audio('audio_file.mp3');
              //  audio.play();
				},3600); 
			 
			 function test(){
				 alert('lal');
			 }
			 
			 
			 setTimeout(function(){
	
					document.getElementById('save').style.display ="table";
				$("#save").animate({top	: "300%",
									opacity: '1.0' },5000);
				},500); 
			 
			 function submitForm(){
				$('#ff').submit();
			 }
	    </script>
    </head>
    <body>
	  
		 
        <div class="container">
            <div class="header">
                <a href="http://tympanus.net/Tutorials/ExperimentsBackgroundClipText/">
                    <strong>User Guide for:</strong>MyInstaGallery
                </a>
                <span class="right">
                    <a href="http://tympanus.net/codrops/2011/12/14/item-blur-effect-with-css3-and-jquery/">
                        <strong>About Me</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div>
			<header>
				<h1>JAVA WEB UNI PROJECT <span>MYINSTAGALLERY</span></h1>
				<h2>Using jsp,mvc framework, jquery,mysql and more. </h2>
			</header>
				  <%
                if (session.getAttribute("is_logged") == "True") {
          %>   
		  
		  <section class="ib-container" id="ib-container" style="
			 position: absolute;
			 width:1200px;     
			 top:900%;  
			 left:0;
			 right:0;
			 margin-left:auto;
			 margin-right:auto;
			 
			 opacity:0.1; display:none;" >
				 
				 
				 
				 
				 <article  style="height:60px;margin-left:47px;">
					<header> 
						
						 <form action="GalleryServlet" method="post" id="ff">
        <input type="hidden" name="user" value=<%=   session.getAttribute("user")%> >
   
						<h3><a  href="javascript: submitForm();" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;">Gallery</a></h3>
						 
						   </form>
					</header>
			  </article>
			  <article  style="height:60px;margin-left:47px;">
					<header> 
						<h3><a  href="login.jsp" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;">My Profile</a></h3>
						 
					</header>
			  </article>
	    	  <article  style="height:200px;width:200px;margin-left:47px;">
					<header>
						
						
						      
                    <% if (session.getAttribute("uploaded") == "True") {
                    %>
                    Image Uploaded Successfully, You can Visit Gallery(link) to see your images.
                    <%
                    }
                    %>

                    <% if (session.getAttribute("uploaded") == "False") {
                    %>
                    No Image Selected!!!
                    <%
                    }
                    %>
                    
                     <% if (session.getAttribute("uploaded") == "TooBig") {
                     %>
                    The Selected Image is Larger than 1MB!
                    <%
                    }
                    %>

                    <% if (session.getAttribute("uploaded") == null){
                    %>
                    hello <%=   session.getAttribute("user")%>
                     Upload Your Picture Here
                    <%
                        }
                    %>
 						
					 	<form name="myForm"  method="post" action="UploadImageServlet"   enctype="multipart/form-data" >
                			<br><input type="text" name="nametag" placeholder="Nametag" size="50"/>
							 <br>
							<table>
								<tr>
									<td>
										 <br>
									</td> 
									 
								</tr>
								<tr>
									<td>
										Public Pic:
									</td> 
									<td>
								 		<input type="checkbox" name="type" style="width:35px;float:left;">
									</td>
								</tr>
								<tr>
									<td>
										Profile Pic:
									</td> 
									<td>
								 		<input type="checkbox" name="profile" style="width:35px;float:left;">
									</td>
								</tr>
							</table> 
							
						 
							 
							<br><input type="file" name="photo" size="50"/></td>
												 	 
						</form>
						  
					</header>
					 </article>
				 
					 
				 
			   <article  style="height:60px;margin-left:47px;">
					<header> 
						<h3><a target="_blank" href="login.jsp" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;">Find Friends</a></h3>
						 
					</header>
			  </article>
			    <article  style="height:60px;margin-left:47px;">
					<header> 
						<h3><a  href="LogoutServlet" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;">Log out</a></h3>
						 
					</header>
			  </article>
			  
			</section>
				 </section>
			<div style="position:absolute;width:175px;height:60px;left:50%;top:900%; margin-left:-87.5px;" id="save">
		 	 <button type="submit"  onclick="document.forms[1].submit();"  class="button button--nina button--border-thin button--round-s" data-text="Save" id="myButton">
						<span>S</span><span>a</span><span>v</span><span>e</span>  
			 </button>
			 </div>
			  
						 
		  
		  <%
              }  else{
				
          %> 
			<section class="ib-container" id="ib-container" style="
			 position: absolute;
			 width:380px;     
			 top:900%;  
			 left:0;
			 right:0;
			 margin-left:auto;
			 margin-right:auto;
			 
			 opacity:0.1; display:none;" >
				 
				<article  style="height:60px;">
					<header> 
						<h3><a target="_blank" href="login.jsp" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;">Log in</a></h3>
						 
					</header>
			  </article>
				<article style="height:60px;">
					<header> 
						<h3><a target="_blank" href="register.jsp" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;">Register</a></h3>
						
			    </article>
			 </section>
			 	 
			 
			<%
               }
				
          %>  
        </div>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(function() {
				
				var $container	= $('#ib-container'),
					$articles	= $container.children('article'),
					timeout;
				
				$articles.on( 'mouseenter', function( event ) {
						
					var $article	= $(this);
					clearTimeout( timeout );
					timeout = setTimeout( function() {
						
						if( $article.hasClass('active') ) return false;
						
						$articles.not( $article.removeClass('blur').addClass('active') )
								 .removeClass('active')
								 .addClass('blur');
						
					}, 65 );
					
				});
				
				$container.on( 'mouseleave', function( event ) {
					
					clearTimeout( timeout );
					$articles.removeClass('active blur');
					
				});
			
			});
			
		</script>
		 
    </body>
</html>