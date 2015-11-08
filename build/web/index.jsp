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