package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \n");
      out.write("\t    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/buttons.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/demo.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("\t\t <script type=\"text/javascript\" src=\"scripts/jquery/jquery-2.1.1.js\"  ></script>\n");
      out.write("\t\t<script src=\"js/modernizr.custom.34978.js\"></script>\t\n");
      out.write("\t\n");
      out.write("\t\t<script> \n");
      out.write("\t\t \t\tsetTimeout(function(){\n");
      out.write("\t\n");
      out.write("\t\t\t\t\tdocument.getElementById('ib-container').style.display =\"table\";\n");
      out.write("\t\t\t\t$(\"#ib-container\").animate({top\t: \"120%\",\n");
      out.write("\t\t\t\t\t\t\t\t\topacity: '1.0' },2000);\n");
      out.write("\t\t\t\t},500); \n");
      out.write("\t\t\t\t\t \n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tsetTimeout(function(){\n");
      out.write("\t//document.getElementById('ib-container').style.display =\"none\";\n");
      out.write("\t\t\t\t$(\"#ib-container\").animate({ \n");
      out.write("\t\t\t\t\t\t\t\t\topacity: '0.0' },1000);\n");
      out.write("\t\t\t\t},1500); \n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tsetTimeout(function(){\n");
      out.write("\t\t\t\t$(\"#ib-container\").animate({ \n");
      out.write("\t\t\t\t\t\t\t\t\topacity: '1.0' },1000);\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t\t},2500); \n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tsetTimeout(function(){\t\t\t\t\t\t\n");
      out.write("\t\t\t\tvar audio = new Audio('audio_file.mp3');\n");
      out.write("              //  audio.play();\n");
      out.write("\t\t\t\t},3600); \n");
      out.write("\t\t\t \n");
      out.write("\t\t\t function test(){\n");
      out.write("\t\t\t\t alert('lal');\n");
      out.write("\t\t\t }\n");
      out.write("\t\t\t \n");
      out.write("\t\t\t \n");
      out.write("\t\t\t setTimeout(function(){\n");
      out.write("\t\n");
      out.write("\t\t\t\t\tdocument.getElementById('save').style.display =\"table\";\n");
      out.write("\t\t\t\t$(\"#save\").animate({top\t: \"300%\",\n");
      out.write("\t\t\t\t\t\t\t\t\topacity: '1.0' },5000);\n");
      out.write("\t\t\t\t},500); \n");
      out.write("\t\t\t \n");
      out.write("\t\t\t function submitForm(){\n");
      out.write("\t\t\t\t$('#ff').submit();\n");
      out.write("\t\t\t }\n");
      out.write("\t    </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\t  \n");
      out.write("\t\t \n");
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
      out.write("\t\t\t<header>\n");
      out.write("\t\t\t\t<h1>JAVA WEB UNI PROJECT <span>MYINSTAGALLERY</span></h1>\n");
      out.write("\t\t\t\t<h2>Using jsp,mvc framework, jquery,mysql and more. </h2>\n");
      out.write("\t\t\t</header>\n");
      out.write("\t\t\t\t  ");

                if (session.getAttribute("is_logged") == "True") {
          
      out.write("   \n");
      out.write("\t\t  \n");
      out.write("\t\t  <section class=\"ib-container\" id=\"ib-container\" style=\"\n");
      out.write("\t\t\t position: absolute;\n");
      out.write("\t\t\t width:1200px;     \n");
      out.write("\t\t\t top:900%;  \n");
      out.write("\t\t\t left:0;\n");
      out.write("\t\t\t right:0;\n");
      out.write("\t\t\t margin-left:auto;\n");
      out.write("\t\t\t margin-right:auto;\n");
      out.write("\t\t\t \n");
      out.write("\t\t\t opacity:0.1; display:none;\" >\n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t\t <article  style=\"height:60px;margin-left:47px;\">\n");
      out.write("\t\t\t\t\t<header> \n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t <form action=\"GalleryServlet\" method=\"get\" id=\"ff\">\n");
      out.write("        \n");
      out.write("   \n");
      out.write("\t\t\t\t\t\t<h3><a  href=\"javascript: submitForm();\" style=\"font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;\">Gallery</a></h3>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t   </form>\n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\t\t\t  </article>\n");
      out.write("\t\t\t  <article  style=\"height:60px;margin-left:47px;\">\n");
      out.write("\t\t\t\t\t<header> \n");
      out.write("\t\t\t\t\t\t<h3><a  href=\"login.jsp\" style=\"font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;\">My Profile</a></h3>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\t\t\t  </article>\n");
      out.write("\t    \t  <article  style=\"height:200px;width:200px;margin-left:47px;\">\n");
      out.write("\t\t\t\t\t<header>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t      \n");
      out.write("                    ");
 if (session.getAttribute("uploaded") == "True") {
                    
      out.write("\n");
      out.write("                    Image Uploaded Successfully, You can Visit Gallery(link) to see your images.\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (session.getAttribute("uploaded") == "False") {
                    
      out.write("\n");
      out.write("                    No Image Selected!!!\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                     ");
 if (session.getAttribute("uploaded") == "TooBig") {
                     
      out.write("\n");
      out.write("                    The Selected Image is Larger than 10MB!\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (session.getAttribute("uploaded") == null){
                    
      out.write("\n");
      out.write("                    hello ");
      out.print(   session.getAttribute("user"));
      out.write("\n");
      out.write("                     Upload Your Picture Here\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write(" \t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t \t<form name=\"myForm\"  method=\"post\" action=\"UploadImageServlet\"   enctype=\"multipart/form-data\" >\n");
      out.write("                \t\t\t<br><input type=\"text\" name=\"nametag\" placeholder=\"Nametag\" size=\"50\"/>\n");
      out.write("\t\t\t\t\t\t\t <br>\n");
      out.write("\t\t\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <br>\n");
      out.write("\t\t\t\t\t\t\t\t\t</td> \n");
      out.write("\t\t\t\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\tPublic Pic:\n");
      out.write("\t\t\t\t\t\t\t\t\t</td> \n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t \t\t<input type=\"checkbox\" name=\"type\" style=\"width:35px;float:left;\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\tProfile Pic:\n");
      out.write("\t\t\t\t\t\t\t\t\t</td> \n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t \t\t<input type=\"checkbox\" name=\"profile\" style=\"width:35px;float:left;\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t</table> \n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t<br><input type=\"file\" name=\"photo\" size=\"50\"/></td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t \t \n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t  \n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t </article>\n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t\t\t \n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t   <article  style=\"height:60px;margin-left:47px;\">\n");
      out.write("\t\t\t\t\t<header> \n");
      out.write("\t\t\t\t\t\t<h3><a target=\"_blank\" href=\"login.jsp\" style=\"font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;\">Find Friends</a></h3>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\t\t\t  </article>\n");
      out.write("\t\t\t    <article  style=\"height:60px;margin-left:47px;\">\n");
      out.write("\t\t\t\t\t<header> \n");
      out.write("\t\t\t\t\t\t<h3><a  href=\"LogoutServlet\" style=\"font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;\">Log out</a></h3>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\t\t\t  </article>\n");
      out.write("\t\t\t  \n");
      out.write("\t\t\t</section>\n");
      out.write("\t\t\t\t </section>\n");
      out.write("\t\t\t<div style=\"position:absolute;width:175px;height:60px;left:50%;top:900%; margin-left:-87.5px;\" id=\"save\">\n");
      out.write("\t\t \t <button type=\"submit\"  onclick=\"document.forms[1].submit();\"  class=\"button button--nina button--border-thin button--round-s\" data-text=\"Save\" id=\"myButton\">\n");
      out.write("\t\t\t\t\t\t<span>S</span><span>a</span><span>v</span><span>e</span>  \n");
      out.write("\t\t\t </button>\n");
      out.write("\t\t\t </div>\n");
      out.write("\t\t\t  \n");
      out.write("\t\t\t\t\t\t \n");
      out.write("\t\t  \n");
      out.write("\t\t  ");

              }  else{
				
          
      out.write(" \n");
      out.write("\t\t\t<section class=\"ib-container\" id=\"ib-container\" style=\"\n");
      out.write("\t\t\t position: absolute;\n");
      out.write("\t\t\t width:380px;     \n");
      out.write("\t\t\t top:900%;  \n");
      out.write("\t\t\t left:0;\n");
      out.write("\t\t\t right:0;\n");
      out.write("\t\t\t margin-left:auto;\n");
      out.write("\t\t\t margin-right:auto;\n");
      out.write("\t\t\t \n");
      out.write("\t\t\t opacity:0.1; display:none;\" >\n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t\t<article  style=\"height:60px;\">\n");
      out.write("\t\t\t\t\t<header> \n");
      out.write("\t\t\t\t\t\t<h3><a target=\"_blank\" href=\"login.jsp\" style=\"font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;\">Log in</a></h3>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\t\t\t  </article>\n");
      out.write("\t\t\t\t<article style=\"height:60px;\">\n");
      out.write("\t\t\t\t\t<header> \n");
      out.write("\t\t\t\t\t\t<h3><a target=\"_blank\" href=\"register.jsp\" style=\"font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:70px;padding-top:17px;\">Register</a></h3>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t    </article>\n");
      out.write("\t\t\t </section>\n");
      out.write("\t\t\t \t \n");
      out.write("\t\t\t \n");
      out.write("\t\t\t");

               }
				
          
      out.write("  \n");
      out.write("        </div>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("\t\t\t$(function() {\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar $container\t= $('#ib-container'),\n");
      out.write("\t\t\t\t\t$articles\t= $container.children('article'),\n");
      out.write("\t\t\t\t\ttimeout;\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t$articles.on( 'mouseenter', function( event ) {\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\tvar $article\t= $(this);\n");
      out.write("\t\t\t\t\tclearTimeout( timeout );\n");
      out.write("\t\t\t\t\ttimeout = setTimeout( function() {\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\tif( $article.hasClass('active') ) return false;\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t$articles.not( $article.removeClass('blur').addClass('active') )\n");
      out.write("\t\t\t\t\t\t\t\t .removeClass('active')\n");
      out.write("\t\t\t\t\t\t\t\t .addClass('blur');\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t}, 65 );\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t$container.on( 'mouseleave', function( event ) {\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\tclearTimeout( timeout );\n");
      out.write("\t\t\t\t\t$articles.removeClass('active blur');\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t\n");
      out.write("\t\t</script>\n");
      out.write("\t\t \n");
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
