
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
            setTimeout(function () {

                document.getElementById('ib-container').style.display = "table";
                $("#ib-container").animate({top: "120%",
                    opacity: '1.0'}, 2000);
            }, 100);

            var active;
            function enterImage(id, height) {
                if (id != active) {
                    leaveImage();
                    setTimeout(function () {

                        var idForm = id * 2.3;
                        var idImg = id * 2.4;
                        var idComN = id * 2.2;
                        active = id;
                        document.getElementById(idComN).style.display = "none";

                        document.getElementById(idImg).style.clip = "auto";

                        var image = document.getElementById(idImg);
                        var imgW = image.naturalWidth;
                        var imgH = image.naturalHeight;

                        if (imgW > 1600) {
                            imgW = imgW / 4;
                        }
                        if (imgH > 1080) {
                            imgH = imgH / 4;
                        }
                        document.getElementById(id).style.position = "absolute";
                        document.getElementById("close").style.visibility = "visible";



                        $('#' + id).animate({width: imgW,
                            height: 25 * (height + 10) + imgH,
                            left: "50%",
                            marginLeft: -imgW / 2, }, 1000);


                        setTimeout(function () {
                            document.getElementById(idForm).style.display = "table";
                            document.getElementById(idForm).style.marginTop = imgH + "px";
                        }, 500);
                        setTimeout(function () {
                            document.getElementById(idImg).style.width = imgW + "px";
                            document.getElementById(idImg).style.height = imgH + "px";
                        }, 200);

                    }, 100);
  $('body').scrollTop(0);
                }

            }

            function leaveImage() {
                id = active;
                setTimeout(function () {
                    var idForm = id * 2.3;
                    var idImg = id * 2.4;
                    var idComN = id * 2.2;

                    document.getElementById(idComN).style.display = "table";
                    document.getElementById("close").style.visibility = "hidden";

                    var image = document.getElementById(idImg);
                    var imgW = image.naturalWidth;
                    var imgH = image.naturalHeight;

                    while (imgW > 200) {
                        imgW = imgW / 1.1;
                        imgH = imgH / 1.1;

                    }


                    document.getElementById(idImg).style.width = imgW + "px";
                    document.getElementById(idImg).style.height = imgH + "px";

                    document.getElementById(idForm).style.display = "none";

                    document.getElementById(id).style.position = "static";
                    document.getElementById(idImg).style.clip = "rect(0px,200px,100px,0px)";
                    $('#' + id).animate({width: "200px",
                        left: "0%",
                        marginLeft: "47px",
                        height: '120px'}, 1000);
                }, 100);
            }

        </script>
    </head>
    <body   >

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
            <a href="#" id="close" onclick="leaveImage();" style="position:absolute;color:white;visibility:hidden">Close</a>
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
                    java.util.LinkedList<Image> images = (java.util.LinkedList<Image>) request.getAttribute("images");
                    // List images = (List) request.getAttribute("images");
                    Iterator<Image> it = images.iterator();
                    while (it.hasNext()) {
                        Image p = (Image) it.next();
                %>

                <article  style="height:120px;width:200px;margin-left:47px;" id='<%=p.getId()%>' onclick="javascript:;
                        enterImage(<%=p.getId()%>,<%=p.getCommentsCount(p.getId())%>)"  >
                    <header> 
                        <%

                            out.print("<img src=" + p.getPath() + " width=200px  style='margin-top: 8px;clip: rect(0px,200px,100px,0px); position: absolute;' id='" + p.getId() * 2.4 + "'/>");
                            out.print("<br><p style='position: absolute;margin-top: 90px;' id='" + p.getId() * 2.2 + "'> comments number: " + p.getCommentsCount(p.getId()) + "</p>");
                        %>
                        <div style="display:none;margin-top: 10px; position: absolute;"  id='<%=p.getId() * 2.3%>'>
                            <form name="myForm"   method="post" action="AddCommentServlet">
                                <input type="hidden"   name="u"  value="<%=   session.getAttribute("user")%>"> 
                                <input type="hidden"   name="id"  value="<%=   p.getId()%>"> 

                                <textarea name="comment"  rows="4" cols="30" autofocus>      </textarea>
                                <br>
                                <input type="submit" value="Post Comment"> </td>
                            </form>
                            <%
                                //out.print("<br>"+  p.getId()); 
                                List comments = p.getComments(p.getId());
                                List users = p.getUsers(p.getId());
                                for (int i = 0; i < comments.size(); i++) {
                                    out.print("<br>" + users.get(i) + ": " + comments.get(i));
                                }

                            %>
                        </div>
                    </header>
                </article>
                <%                    }
                %>




            </section>
        </div>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript">
                    $(function () {

                        var $container = $('#ib-container'),
                                $articles = $container.children('article'),
                                timeout;

                        $articles.on('mouseenter', function (event) {

                            var $article = $(this);
                            clearTimeout(timeout);
                            timeout = setTimeout(function () {

                                if ($article.hasClass('active'))
                                    return false;

                                $articles.not($article.removeClass('blur').addClass('active'))
                                        .removeClass('active')
                                        .addClass('blur');

                            }, 65);

                        });

                        $container.on('mouseleave', function (event) {

                            clearTimeout(timeout);
                            $articles.removeClass('active blur');

                        });

                    });
        </script>
    </body>
</html>