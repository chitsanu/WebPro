package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product Page</title>\n");
      out.write("        <style>\n");
      out.write("            .Wrapper{\n");
      out.write("                display:grid;\n");
      out.write("                grid-template-columns: 20% 60% 20%;\n");
      out.write("                \n");
      out.write("                grid-gap: 1em;\n");
      out.write("                margin-left: 1em;\n");
      out.write("                margin-right: 1em;\n");
      out.write("                margin-bottom: 1em;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            h1{\n");
      out.write("                padding :1em;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .show{\n");
      out.write("                display:grid;\n");
      out.write("                grid-template-columns: 25% 25% 25% 25%;\n");
      out.write("                \n");
      out.write("                padding: 1em;\n");
      out.write("            }\n");
      out.write("            .productbd{\n");
      out.write("                display:grid;\n");
      out.write("                padding : 1em;\n");
      out.write("            }\n");
      out.write("            .product{\n");
      out.write("                display:grid ;\n");
      out.write("                padding-top: 2em; \n");
      out.write("                margin-top : 1em;\n");
      out.write("                justify-content: flex-start;\n");
      out.write("                 align-content: center;\n");
      out.write("            }\n");
      out.write("            .productimage{\n");
      out.write("                 display:grid ;\n");
      out.write("                 height: 500px;\n");
      out.write("                 width:600px;\n");
      out.write("                 align-content: center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/Header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <h1>Product Page</h1>\n");
      out.write("        <div class=\"Wrapper\">\n");
      out.write("            <div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"show\">\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${products}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("p");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <div class=\"productbd\">\n");
          out.write("                <div class=\"showProduct\">\n");
          out.write("\n");
          out.write("                    <div class=\"productimage\">\n");
          out.write("\n");
          out.write("                        <img src=\"Pic/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productcode}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(".jpeg\" width=\"70%\"><br>\n");
          out.write("\n");
          out.write("                    </div>\n");
          out.write("                \n");
          out.write("                    <div class=\"product\">\n");
          out.write("\n");
          out.write("                        <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p> <br>\n");
          out.write("                        <p>Price: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productprice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" Baht</p><br>\n");
          out.write("                        <a href=\"AddItems?productCode=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productcode}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                            <input type=\"button\" class=\"btn btn-outline-success\" value=\"Add to cart\"/>\n");
          out.write("                        </a>\n");
          out.write("\n");
          out.write("                    </div>\n");
          out.write("\n");
          out.write("                </div>   \n");
          out.write("                </div>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
