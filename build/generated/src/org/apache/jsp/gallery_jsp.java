package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.Image;
import java.util.Iterator;
import java.util.List;

public final class gallery_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>MyInstaGallery University Project</title>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"> \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n");
      out.write("        <meta name=\"description\" content=\"Item Blur Effect with CSS3 and jQuery - Using Box Shadows, Transform and Transitions\" />\n");
      out.write("        <meta name=\"keywords\" content=\"blur, css3, transition, jquery, box shadow, text shadow, articles, scale, transform, animation\" />\n");
      out.write("        <meta name=\"author\" content=\"Codrops\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/buttons.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/demo.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"scripts/jquery/jquery-2.1.1.js\"  ></script>\n");
      out.write("        <script src=\"js/modernizr.custom.34978.js\"></script>\t\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            setTimeout(function () {\n");
      out.write("\n");
      out.write("                document.getElementById('ib-container').style.display = \"table\";\n");
      out.write("                $(\"#ib-container\").animate({//top: \"120%\",\n");
      out.write("                    opacity: '1.0'}, 2000);\n");
      out.write("            }, 100);\n");
      out.write("\n");
      out.write("            var active;\n");
      out.write("            function enterImage(id, height) {\n");
      out.write("                if (id !== active) {\n");
      out.write("                    leaveImage();\n");
      out.write("                    setTimeout(function () {\n");
      out.write("\n");
      out.write("                        var idForm = id * 2.31111;\n");
      out.write("                        var idImg = id * 2.41111;\n");
      out.write("                        var idComN = id * 2.21111;\n");
      out.write("                        active = id;\n");
      out.write("                        document.getElementById(idComN).style.display = \"none\";\n");
      out.write("\n");
      out.write("                        document.getElementById(idImg).style.clip = \"auto\";\n");
      out.write("\n");
      out.write("                        var image = document.getElementById(idImg);\n");
      out.write("                        var imgW = image.naturalWidth;\n");
      out.write("                        var imgH = image.naturalHeight;\n");
      out.write("\n");
      out.write("                        if (imgW > 1600) {\n");
      out.write("                            imgW = imgW / 4;\n");
      out.write("                            imgH = imgH / 4;\n");
      out.write("                        }\n");
      out.write("                        if (imgH > 1080) {\n");
      out.write("                            imgH = imgH / 4;\n");
      out.write("                            imgW = imgW / 4;\n");
      out.write("                        }\n");
      out.write("                        document.getElementById(id).style.position = \"absolute\";\n");
      out.write("                        document.getElementById(\"close\").style.visibility = \"visible\";\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        $('#' + id).animate({width: imgW,\n");
      out.write("                            height: 25 * (height + 10) + imgH,\n");
      out.write("                            left: \"50%\",\n");
      out.write("                            marginLeft: -imgW / 2, }, 1000);\n");
      out.write("\n");
      out.write("\n");
      out.write("                        setTimeout(function () {\n");
      out.write("                            document.getElementById(idForm).style.display = \"table\";\n");
      out.write("                            document.getElementById(idForm).style.marginTop = imgH + \"px\";\n");
      out.write("                        }, 500);\n");
      out.write("                        setTimeout(function () {\n");
      out.write("                            document.getElementById(idImg).style.width = imgW + \"px\";\n");
      out.write("                            document.getElementById(idImg).style.height = imgH + \"px\";\n");
      out.write("                        }, 200);\n");
      out.write("\n");
      out.write("                    }, 100);\n");
      out.write("                    $('body').scrollTop(0);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function leaveImage() {\n");
      out.write("                id = active;\n");
      out.write("                setTimeout(function () {\n");
      out.write("                    var idForm = id * 2.31111;\n");
      out.write("                    var idImg = id * 2.41111;\n");
      out.write("                    var idComN = id * 2.21111;\n");
      out.write("\n");
      out.write("                    document.getElementById(idComN).style.display = \"table\";\n");
      out.write("                    document.getElementById(\"close\").style.visibility = \"hidden\";\n");
      out.write("\n");
      out.write("                    var image = document.getElementById(idImg);\n");
      out.write("                    var imgW = image.naturalWidth;\n");
      out.write("                    var imgH = image.naturalHeight;\n");
      out.write("\n");
      out.write("                    while (imgW > 200) {\n");
      out.write("                        imgW = imgW / 1.1;\n");
      out.write("                        imgH = imgH / 1.1;\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("\n");
      out.write("                    document.getElementById(idImg).style.width = imgW + \"px\";\n");
      out.write("                    document.getElementById(idImg).style.height = imgH + \"px\";\n");
      out.write("\n");
      out.write("                    document.getElementById(idForm).style.display = \"none\";\n");
      out.write("\n");
      out.write("                    document.getElementById(id).style.position = \"static\";\n");
      out.write("                    document.getElementById(idImg).style.clip = \"rect(0px,200px,100px,0px)\";\n");
      out.write("                    $('#' + id).animate({width: \"200px\",\n");
      out.write("                        left: \"0%\",\n");
      out.write("                        marginLeft: \"47px\",\n");
      out.write("                        height: '140px'}, 1000);\n");
      out.write("                }, 100);\n");
      out.write("                active = null;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            function getXMLObject()  //XML OBJECT\n");
      out.write("            {\n");
      out.write("                var xmlHttp = false;\n");
      out.write("                try {\n");
      out.write("                    xmlHttp = new ActiveXObject(\"Msxml2.XMLHTTP\")  // For Old Microsoft Browsers\n");
      out.write("                }\n");
      out.write("                catch (e) {\n");
      out.write("                    try {\n");
      out.write("                        xmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\")  // For Microsoft IE 6.0+\n");
      out.write("                    }\n");
      out.write("                    catch (e2) {\n");
      out.write("                        xmlHttp = false   // No Browser accepts the XMLHTTP Object then false\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {\n");
      out.write("                    xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers\n");
      out.write("                }\n");
      out.write("                return xmlHttp;  // Mandatory Statement returning the ajax object created\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var xmlhttp = new getXMLObject();\t//xmlhttp holds the ajax object\n");
      out.write("\n");
      out.write("            function ajaxFunction(id) {\n");
      out.write("                var getdate = new Date();  //Used to prevent caching during ajax call\n");
      out.write("                if (xmlhttp) {\n");
      out.write("                 \n");
      out.write("                    var comment = document.getElementById(\"comment\").value;\n");
      out.write("\n");
      out.write("                    xmlhttp.open(\"POST\", \"AddCommentServlet?comment=\" + comment, true); //gettime will be the servlet name\n");
      out.write("                    xmlhttp.onreadystatechange = handleServerResponse;\n");
      out.write("                    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n");
      out.write("                    xmlhttp.send();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function handleServerResponse() {\n");
      out.write("                if (xmlhttp.readyState == 4) {\n");
      out.write("                    if (xmlhttp.status == 200) {\n");
      out.write("                        document.getElementById(\"comments\").innerHTML = xmlhttp.responseText; //Update the HTML Form element\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        alert(\"Error during AJAX call. Please try again\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body   >\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <a href=\"http://tympanus.net/Tutorials/ExperimentsBackgroundClipText/\">\n");
      out.write("                    <strong>User Guide for:</strong>MyInstaGallery\n");
      out.write("                </a>\n");
      out.write("                <span class=\"right\">\n");
      out.write("                    <a href=\"http://tympanus.net/codrops/2011/12/14/item-blur-effect-with-css3-and-jquery/\">\n");
      out.write("                        <strong>About Me</strong>\n");
      out.write("                    </a>\n");
      out.write("                </span>\n");
      out.write("                <div class=\"clr\"></div>\n");
      out.write("            </div>\n");
      out.write("            <header>\n");
      out.write("                <h1>JAVA WEB UNI PROJECT <span>MYINSTAGALLERY</span></h1>\n");
      out.write("                <h2>Using jsp,mvc framework, jquery,mysql and more. </h2>\n");
      out.write("            </header>\n");
      out.write("            <a href=\"#\" id=\"close\" onclick=\"leaveImage();\" style=\"position:absolute;color:white;visibility:hidden\">Close</a>\n");
      out.write("            <section class=\"ib-container\" id=\"ib-container\" style=\"\n");
      out.write("                     position: absolute;\n");
      out.write("                     width:100%;     \n");
      out.write("                     top:120%;  \n");
      out.write("                     left:0;\n");
      out.write("                     right:0;\n");
      out.write("                     margin-left:auto;\n");
      out.write("                     margin-right:auto;\n");
      out.write("\n");
      out.write("                     opacity:0.1; display:none;\" >\n");
      out.write("\n");
      out.write("                ");

                    java.util.LinkedList<Image> images = (java.util.LinkedList<Image>) request.getAttribute("images");
                    // List images = (List) request.getAttribute("images");
                    Iterator<Image> it = images.iterator();
                    while (it.hasNext()) {
                        Image p = (Image) it.next();
                
      out.write("\n");
      out.write("\n");
      out.write("                <article  style=\"height:140px;width:200px;margin-left:47px;\" id='");
      out.print(p.getId());
      out.write("' onclick=\"javascript:enterImage(");
      out.print(p.getId());
      out.write(',');
      out.print(p.getCommentsCount(p.getId()));
      out.write(");ajaxFunction('comment'+");
      out.print(p.getId() * 2.31111);
      out.write(")\"  >\n");
      out.write("                    <header> \n");
      out.write("                        ");

                            out.print("<p>" + p.getTag() + "</p>");
                            out.print("<img src=" + p.getPath() + " width=200px  style='margin-top: 8px;clip: rect(0px,200px,100px,0px); position: absolute;' id='" + p.getId() * 2.41111 + "'/>");
                            out.print("<br><p style='position: absolute;margin-top: 90px;' id='" + p.getId() * 2.21111 + "'> comments " + p.getCommentsCount(p.getId()) + "</p>");
                        
      out.write("\n");
      out.write("                        <div style=\"display:none;margin-top: 10px; position: absolute;\"  id='");
      out.print(p.getId() * 2.31111);
      out.write("'>\n");
      out.write("                            <form name=\"myForm\"   method=\"post\" >\n");
      out.write("                                <input type=\"hidden\"   name=\"u\"  value=\"");
      out.print(   session.getAttribute("user"));
      out.write("\"> \n");
      out.write("                                <input type=\"hidden\"   name=\"id\"  value=\"");
      out.print(   p.getId());
      out.write("\"> \n");
      out.write("\n");
      out.write("                                <textarea   id=\"comment");
      out.print(p.getId() * 2.31111);
      out.write("\"  rows=\"4\" cols=\"30\" autofocus>      </textarea>\n");
      out.write("                                <br>\n");
      out.write("                                <input type=\"button\" onclick=\"javascript:ajaxFunction('comment'+");
      out.print(p.getId() * 2.31111);
      out.write("));\" value=\"Post Comment\"> </td>\n");
      out.write("                            </form>\n");
      out.write("                            <p  id=\"comments\">\n");
      out.write("                            </p>\n");
      out.write("                            ");

                                //out.print("<br>"+  p.getId()); 
                                List comments = p.getComments(p.getId());
                                List users = p.getUsers(p.getId());
                                for (int i = 0; i < comments.size(); i++) {
                                    out.print("<br>" + users.get(i) + ": " + comments.get(i));
                                }

                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </header>\n");
      out.write("                </article>\n");
      out.write("                ");
                    }
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                    $(function () {\n");
      out.write("\n");
      out.write("                        var $container = $('#ib-container'),\n");
      out.write("                                $articles = $container.children('article'),\n");
      out.write("                                timeout;\n");
      out.write("\n");
      out.write("                        $articles.on('mouseenter', function (event) {\n");
      out.write("\n");
      out.write("                            var $article = $(this);\n");
      out.write("                            clearTimeout(timeout);\n");
      out.write("                            timeout = setTimeout(function () {\n");
      out.write("\n");
      out.write("                                if ($article.hasClass('active'))\n");
      out.write("                                    return false;\n");
      out.write("\n");
      out.write("                                $articles.not($article.removeClass('blur').addClass('active'))\n");
      out.write("                                        .removeClass('active')\n");
      out.write("                                        .addClass('blur');\n");
      out.write("\n");
      out.write("                            }, 65);\n");
      out.write("\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                        $container.on('mouseleave', function (event) {\n");
      out.write("\n");
      out.write("                            clearTimeout(timeout);\n");
      out.write("                            $articles.removeClass('active blur');\n");
      out.write("\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                    });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
