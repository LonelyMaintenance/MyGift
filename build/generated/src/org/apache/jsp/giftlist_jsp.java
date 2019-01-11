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
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <style>\n");
      out.write("            body,h1,h2,h3,h4,h5,h6 {font-family: \"Lato\", sans-serif}\n");
      out.write("            .w3-bar,h1,button {font-family: \"Montserrat\", sans-serif}\n");
      out.write("            .fa-anchor,.fa-coffee {font-size:200px}\n");
      out.write("        </style>\n");
      out.write("        <title>Gifts</title>\n");
      out.write("    </head>\n");
      out.write("<header class=\"w3-container w3-red w3-center\" style=\"padding:128px 16px\">\n");
      out.write("            <h1 class=\"w3-margin w3-jumbo\">Gift list</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");


        //int m=obj.cube(5);  
        //out.print("cube of 5 is "+m);
        try {
            GiftsBean e = new GiftsBean();
            List<Gift> list = event.getData();
            out.println("<body>");
            out.println("<h1>Activate a gift!</h1>");
            for (int i = 0; i < list.size(); i++) {

                out.println("<td>");
                out.println("<span>");
                out.println("<a href=\"chosengift.jsp?giver=" + (list.get(i).getGiver()) + "&id=" + list.get(i).getId() + "&amount=" + (list.get(i).getAmount()) + "\">" + String.format(list.get(i).getAmount() + " from " + list.get(i).getGiver()) + "</a>");
                out.println("</span>");
                out.println("</td><br>");

            }
            out.println("<a href=\"index.html\">Get back to main</a>");
            out.println("<a href=\"logout.jsp\">Log out</a>");
            out.println("</body>");
        } catch (IndexOutOfBoundsException e) {
            out.println("<body>");

            out.println("<td>");
            out.println("<span>");
            out.println("<h1>No records available</h1>");
            out.println("</span>");
            out.println("</td><br>");
            out.println("</header>");
            out.println("</body>");

        }
    
      out.write("  \n");
      out.write("\n");
      out.write("    <footer class=\"w3-container w3-padding-64 w3-center w3-opacity\">  \n");
      out.write("            <p>Powered by <a href=\"https://www.w3schools.com/w3css/default.asp\" target=\"_blank\">w3.css</a></p>\n");
      out.write("        </footer>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
