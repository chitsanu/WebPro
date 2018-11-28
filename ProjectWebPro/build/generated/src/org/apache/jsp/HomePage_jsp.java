package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Exotic Animal Food</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <style>\r\n");
      out.write("        .wrapper{\r\n");
      out.write("            display: grid;\r\n");
      out.write("        }\r\n");
      out.write("        .topic{\r\n");
      out.write("            display: grid;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("        }\r\n");
      out.write("        .image{\r\n");
      out.write("            display:Grid;\r\n");
      out.write("            \r\n");
      out.write("            justify-items: stertch;\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("        .img1{\r\n");
      out.write("            display:Grid;\r\n");
      out.write("            align-items: flex-start;\r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("        .img2{\r\n");
      out.write("            display:Grid;\r\n");
      out.write("             justify-items: center;\r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("         .img2{\r\n");
      out.write("            display:Grid;\r\n");
      out.write("             align-items: flex-end;\r\n");
      out.write("           \r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("    </style>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/Header.jsp", out, false);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"topic\">\r\n");
      out.write("            <h1>We have Foods For your Furry Friend.</h1>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"image\">\r\n");
      out.write("            <div class=\"img1\">\r\n");
      out.write("                <img src=\"Pic/img1.png\" class=\"img-thumbnail \" width=\"50%\" height=\"50%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"img2\">\r\n");
      out.write("                <img src=\"Pic/img2.jpg\" class=\"img-thumbnail \" width=\"50%\" height=\"50%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"img3\">\r\n");
      out.write("                <img src=\"Pic/img3.jpg\" class=\"img-thumbnail \" width=\"50%\" height=\"50%\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
