package org.apache.jsp.VISTAS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Votante;

public final class ModificarVotante2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("       <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <link  rel=\"icon\"   href=\"../FOTOS/favicon.png\" type=\"image/png\" />\n");
      out.write("        <title>Votaciones</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("\n");
      out.write("* {\n");
      out.write("  margin: 0;\n");
      out.write(" \tpadding: 0;\n");
      out.write("}\n");
      out.write("body {\n");
      out.write("  background:#333 url(\"http://www.jmcamarket.com/materialize/img/marketylogo.png\");\n");
      out.write("  background-size: cover;\n");
      out.write("\tfont-family: \"Roboto\",\"Helvetica Neue Light\",\"Helvetica Neue\",Helvetica,Arial,\"Lucida Grande\",sans-serif,aclonica;\n");
      out.write("    font-size:14px;\n");
      out.write("\tcolor:white;\n");
      out.write("}\n");
      out.write(".h3 {\n");
      out.write("  font-family: \"aclonica\";\n");
      out.write("  font-size: 120px;\n");
      out.write("  color: orange;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" <section class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <h3 class=\"center-align\">CONTACTO</h3>\n");
      out.write("      <article class=\"col s6 offset-s3\">\n");
      out.write("        <form method=\"POST\" action=\"formulario-contacto.php\">\n");
      out.write("          <div class=\"input-field\">\n");
      out.write("            <i class=\"material-icons prefix\">perm_identity</i>\n");
      out.write("            <label for=\"nombre\">Nombre</label>\n");
      out.write("            <input type=\"text\" name=\"nombre\" required>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"input-field\">\n");
      out.write("            <i class=\"material-icons prefix\">person_pin</i>\n");
      out.write("            <label for=\"apellido\">Apellido</label>\n");
      out.write("            <input type=\"text\" name=\"apellido\" required>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"input-field\">\n");
      out.write("            <i class=\"material-icons prefix\">email</i>\n");
      out.write("            <label for=\"email\">Email</label>\n");
      out.write("            <input type=\"email\" name=\"email\" required>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"input-field\">\n");
      out.write("            <i class=\"material-icons prefix\">mode_edit</i>\n");
      out.write("            <label for=\"mensaje\">Mensaje</label>\n");
      out.write("            <textarea name=\"mensaje\" id=\"\" rows=\"10\" class=\"materialize-textarea\" length=\"140\" required></textarea>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <p class=\"center-align\">\n");
      out.write("            <button class=\"waves-effect waves-light btn\" type=\"submit\"><i class=\"material-icons right\">send</i>enviar</button>\n");
      out.write("          </p>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("      </article>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("</body>\n");
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
