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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Exotic Animal Food</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .wrapper{\n");
      out.write("            display: grid;\n");
      out.write("        }\n");
      out.write("        .topic{\n");
      out.write("            display: grid;\n");
      out.write("            justify-content: center;\n");
      out.write("        }\n");
      out.write("        .image{\n");
      out.write("            display:Grid;\n");
      out.write("            \n");
      out.write("            justify-items: stertch;\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        .img1{\n");
      out.write("            display:Grid;\n");
      out.write("            align-items: flex-start;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        .img2{\n");
      out.write("            display:Grid;\n");
      out.write("             justify-items: center;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("         .img2{\n");
      out.write("            display:Grid;\n");
      out.write("             align-items: flex-end;\n");
      out.write("           \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/Header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"topic\">\n");
      out.write("            <h1>We have Foods For your Furry Friend.</h1>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"image\">\n");
      out.write("            <div class=\"img1\">\n");
      out.write("                <img src=\"Pic/img1.png\" class=\"img-thumbnail \" width=\"50%\" height=\"50%\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"img2\">\n");
      out.write("                <img src=\"Pic/img2.jpg\" class=\"img-thumbnail \" width=\"50%\" height=\"50%\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"img3\">\n");
      out.write("                <img src=\"Pic/img3.jpg\" class=\"img-thumbnail \" width=\"50%\" height=\"50%\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
