
<%@page import="Models.Image"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
				},100); 
				
				function enterImage(id,height){
					setTimeout(function(){
                                            
                                            var idForm=id*2.3;
                                    document.getElementById(idForm).style.display ="table";
				$('#'+id).animate({width	: "400px",
									height: 200*(height+1) },1000);
				},100); 
				}
				
		 		function leaveImage(id){
					setTimeout(function(){
                                                 var idForm=id*2.3;
                                        document.getElementById(idForm).style.display ="none";
				$('#'+id).animate({width	: "200px",
									height: '120px' },1000);
				},100); 
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
			<section class="ib-container" id="ib-container" style="
			 position: absolute;
			 width:100%;     
			 top:900%;  
			 left:0;
			 right:0;
			 margin-left:auto;
			 margin-right:auto;
			 
			 opacity:0.1; display:none;" >
				  
		 <%
                java.util.LinkedList<Image> images =  (java.util.LinkedList<Image>) request.getAttribute("images");     
               // List images = (List) request.getAttribute("images");
                Iterator<Image> it = images.iterator();
                while (it.hasNext()) {
				 Image p = (Image) it.next();
                    %>
                    <article  style="height:120px;width:200px;margin-left:47px;" id='<%=p.getId()%>' onclick="javascrtip:enterImage(<%=p.getId()%>,<%=p.getCommentsCount(p.getId())%>)" onmouseleave="javascrtip:leaveImage(<%=p.getId()%>)">
			<header> 
                    <%	
                    
                     out.print("<br><img src='" + p.getPath()+"'/>");
                      out.print("<br> comments number: "+  p.getCommentsCount(p.getId())); 
                     %>
                        <form name="myForm" style="display:none;"  id='<%=p.getId()*2.3%>'  method="post" action="AddCommentServlet">
                      <input type="hidden"   name="u"  value="<%=   session.getAttribute("user")%>"> 
                      
                        <textarea name="comment"  rows="4" cols="30" autofocus>      </textarea>
                     
                      <input type="submit" value="Post Comment"> </td>
                      </form>
                     <%
                     //out.print("<br>"+  p.getId()); 
                     List comments =p.getComments(p.getId());
                     for(int i=0;i<comments.size();i++){
                         out.print("<br>"+  comments.get(i)); 
                     }
                       
                    %>
                        </header>
                    </article>
                <%
                }
            %>
					 
					 
				 
			 
			</section>
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