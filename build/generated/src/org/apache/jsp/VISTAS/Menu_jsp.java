package org.apache.jsp.VISTAS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <link  rel=\"icon\"   href=\"../FOTOS/favicon.png\" type=\"image/png\" />\n");
      out.write("        <title>Votaciones</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            ul li {\n");
      out.write("                background:#000;\n");
      out.write("                list-style: none;\n");
      out.write("                height: 44px;\n");
      out.write("                float:left;\n");
      out.write("                padding:10px 5px;\n");
      out.write("            }\n");
      out.write("            ul li a {\n");
      out.write("                width: 175px;\n");
      out.write("                height: 40px;\n");
      out.write("                line-height: 53px;\n");
      out.write("                border-bottom: 4px solid #636393;\n");
      out.write("                padding:0px;\n");
      out.write("                color: #fff;\n");
      out.write("                font-size:18px;\n");
      out.write("                font-weight:lighter;\n");
      out.write("                text-align:center;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("                -webkit-transition: .2s all linear;\n");
      out.write("                -moz-transition: .2s all linear;\n");
      out.write("                -o-transition: .2s all linear;\n");
      out.write("                transition: .2s all linear;\n");
      out.write("            }\n");
      out.write("            li:nth-child(1) a {\n");
      out.write("                border-color: #636393;\n");
      out.write("            }\n");
      out.write("            li:nth-child(2) a {\n");
      out.write("                border-color: #B5222D;\n");
      out.write("            }\n");
      out.write("            li:nth-child(3) a {\n");
      out.write("                border-color: #D4953C;\n");
      out.write("            }\n");
      out.write("            li:nth-child(4) a {\n");
      out.write("                border-color: #609491;\n");
      out.write("            }\n");
      out.write("            li:nth-child(5) a {\n");
      out.write("                border-color: #87A248;\n");
      out.write("            }\n");
      out.write("            li:nth-child(1) a:hover {\n");
      out.write("                border-bottom: 35px solid #636393;\n");
      out.write("                height: 9px;\n");
      out.write("            }\n");
      out.write("            li:nth-child(2) a:hover {\n");
      out.write("                border-bottom: 35px solid #B5222D;\n");
      out.write("                height: 9px;\n");
      out.write("            }\n");
      out.write("            li:nth-child(3) a:hover {\n");
      out.write("                border-bottom: 35px solid #D4953C;\n");
      out.write("                height: 9px;\n");
      out.write("            }\n");
      out.write("            li:nth-child(4) a:hover {\n");
      out.write("                border-bottom: 35px solid #609491;\n");
      out.write("                height: 9px;\n");
      out.write("            }\n");
      out.write("            li:nth-child(5) a:hover {\n");
      out.write("                border-bottom: 35px solid #87A248;\n");
      out.write("                height: 9px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <ul id=\"nav\">\n");
      out.write("            <li class=\"home\"><a href=\"#\">Darse de alta</a></li>\n");
      out.write("            <li class=\"tutorials\"><a href=\"#\">Darse de baja</a></li>\n");
      out.write("            <li class=\"about\"><a href=\"#\">Modificar Datos</a></li>\n");
      out.write("            <li class=\"news\"><a href=\"#\">Resultado Votaciones</a></li>\n");
      out.write("            <li class=\"contact\"><a href=\"#\">Votar</a></li>\n");
      out.write("            <li class=\"home\"><a href=\"#\">Escrutiño</a></li>\n");
      out.write("        </ul>\n");
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
}
