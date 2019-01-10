package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import web.Gift;
import bean.GiftsBean;
import java.util.List;

public final class giftlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      bean.GiftsBean event = null;
      synchronized (_jspx_page_context) {
        event = (bean.GiftsBean) _jspx_page_context.getAttribute("event", PageContext.PAGE_SCOPE);
        if (event == null){
          event = new bean.GiftsBean();
          _jspx_page_context.setAttribute("event", event, PageContext.PAGE_SCOPE);
        }
      }
      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("        <title>Gifts</title>\n");
      out.write("    </head>index\n");
      out.write("    <body>\n");
      out.write("        <h1>Activate a gift!</h1>\n");
      out.write("     \n");
      out.write("   \n");
  
    // <option value="1">1</option>
   // <option value="2">2</option>
   // <option value="3">3</option>
    
//int m=obj.cube(5);  
//out.print("cube of 5 is "+m);
GiftsBean e = new GiftsBean();
List<Gift> list = event.getData();



for(int i = 0; i < list.size(); i++){
        out.println("<td>");
        out.println("<span>");
       out.println("<a href=\"chosengift.jsp?giver="+(list.get(i).getGiver())+"&id="+list.get(i).getId()+"\">"+String.format(list.get(i).getAmount()+ " from "+list.get(i).getGiver())+"</a>");
        out.println("</span>");
        out.println("</td><br>");
        
}


      out.write("  \n");
      out.write("  \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("  \n");
      out.write("           \n");
      out.write("     \n");
      out.write("</body>");
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
