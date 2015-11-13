 

import java.io.*;

import java.text.*;

import java.util.*;

import javax.servlet.*;

import javax.servlet.http.*;

public class gettime extends HttpServlet {
 
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
                String sParam1 = request.getParameter("comment");
		Date df = new Date();
		out.println(df.getTime());
                List test= new ArrayList();
                int i=10;
                while(i>0){
                    i=i-1;
                    test.add("test");
                }
                for(int j=0;j<=test.size();j++){
                    out.println("<br> " +test.get(i) );
                }
                out.println("<br>"+sParam1);
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		doPost(request,response);
	}
}