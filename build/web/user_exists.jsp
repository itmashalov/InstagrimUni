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
	 
				$("#ib-container").animate({ 
									opacity: '0.0' },700);
				},500); 
				
				setTimeout(function(){
				$("#ib-container").animate({ 
									opacity: '1.0' },700);
									
				 
				},1000); 
			 
			 
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
			 width:220px;     
			 top:120%;  
			 left:0;
			 right:0;
			 margin-left:auto;
			 margin-right:auto;
			 
			 opacity:1.0; display:table;" >
				 
				<article  style="height:180px;width:202px;border-style: solid; border-width: 1px; border-color:red;">
					<header>
						Username Already exists!
					 	<form name="myForm" onsubmit="return validateForm()" method="post" action="RegisterServlet">
                			<br><input type="text"style="background:rgba(255,255,255,0.6)"      placeholder="Username" onKeyDown="usrcheck1()" onBlur="usrcheck1()" name="usr"> 
							<br><input type="password" style="background:rgba(255,255,255,0.6)"  placeholder="password" onKeyDown="passcheck1()" onBlur="passcheck1()" name="pass"> 
							<br><input type="password"  style="background:rgba(255,255,255,0.6)" placeholder="Retype Password" onKeyDown="passcheck2()" onBlur="passcheck2()" name="re-pass"> 
							<br><input type="text"  style="background:rgba(255,255,255,0.6)"     placeholder="Name" onKeyDown="namecheck()" onBlur="namecheck()" name="name"> 
							<br><input type="text"  style="background:rgba(255,255,255,0.6)"    placeholder="Email" onKeyDown="mailchk()" onBlur="mailchk()" name="email"> 
							 
						</form>
						  
					</header>
					 </article>
					 
					 <button type="submit" style="margin-left:42px;" onclick="document.forms[0].submit();"  class="button button--nina button--border-thin button--round-s" data-text="Sign up" id="myButton">
						<span>S</span><span>i</span><span>g</span><span>n</span> <span>U</span><span>p</span>
					</button>
				<article  style="height:60px;margin-left:36px;">
					<header> 
						<h3><a target="_blank" href="login.jsp" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;">Log in</a></h3>
						 
					</header>
			  </article>
			   
			 
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