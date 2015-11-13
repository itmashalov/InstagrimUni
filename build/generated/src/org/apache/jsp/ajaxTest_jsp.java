package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ajaxTest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>JSP and Servlet using AJAX</title>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("function getXMLObject()  //XML OBJECT\n");
      out.write("{\n");
      out.write("   var xmlHttp = false;\n");
      out.write("   try {\n");
      out.write("     xmlHttp = new ActiveXObject(\"Msxml2.XMLHTTP\")  // For Old Microsoft Browsers\n");
      out.write("   }\n");
      out.write("   catch (e) {\n");
      out.write("     try {\n");
      out.write("       xmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\")  // For Microsoft IE 6.0+\n");
      out.write("     }\n");
      out.write("     catch (e2) {\n");
      out.write("       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false\n");
      out.write("     }\n");
      out.write("   }\n");
      out.write("   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {\n");
      out.write("     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers\n");
      out.write("   }\n");
      out.write("   return xmlHttp;  // Mandatory Statement returning the ajax object created\n");
      out.write("}\n");
      out.write("\n");
      out.write("var xmlhttp = new getXMLObject();\t//xmlhttp holds the ajax object\n");
      out.write("\n");
      out.write("function ajaxFunction() {\n");
      out.write("  var getdate = new Date();  //Used to prevent caching during ajax call\n");
      out.write("  if(xmlhttp) {\n");
      out.write("       var data=document.getElementById(\"butt\").value;\n");
      out.write("       \n");
      out.write("    xmlhttp.open(\"POST\",\"AddCommentServlet?comment=\" + data,true); //gettime will be the servlet name\n");
      out.write("    xmlhttp.onreadystatechange  = handleServerResponse;\n");
      out.write("    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n");
      out.write("    xmlhttp.send();\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("\n");
      out.write("function handleServerResponse() {\n");
      out.write("   if (xmlhttp.readyState == 4) {\n");
      out.write("     if(xmlhttp.status == 200) {\n");
      out.write("       document.getElementById(\"test\").innerHTML =xmlhttp.responseText; //Update the HTML Form element\n");
      out.write("     }\n");
      out.write("     else {\n");
      out.write("        alert(\"Error during AJAX call. Please try again\");\n");
      out.write("     }\n");
      out.write("   }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<body>\n");
      out.write("<form name=\"myForm\">\n");
      out.write("Server Time:<input type=\"text\" name=\"time\" id=\"butt\" value=\"lal\"/>\n");
      out.write("<br />\n");
      out.write("<input   type=\"button\" onmouseover=\"javascript:ajaxFunction();\" value=\"Click to display Server Time on Textbox\"/>\n");
      out.write("<br />\n");
      out.write("</form>\n");
      out.write("    <p  id=\"test\">\n");
      out.write("    </p>\n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("</head>\n");
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
