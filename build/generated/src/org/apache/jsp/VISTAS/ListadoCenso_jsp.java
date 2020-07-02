package org.apache.jsp.VISTAS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Modelo.Votante;

public final class ListadoCenso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <link  rel=\"icon\"   href=\"../FOTOS/favicon.png\" type=\"image/png\" />\n");
      out.write("        <title>Votaciones</title>\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            *,\n");
      out.write("            *:before,\n");
      out.write("            *:after {\n");
      out.write("                -moz-box-sizing: border-box;\n");
      out.write("                -webkit-box-sizing: border-box;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                font-family: \"Roboto\";\n");
      out.write("                color: #384047;\n");
      out.write("                background-image: url(\"../FOTOS/29.jpg\");\n");
      out.write("                background-position: center; \n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("                min-height: 100vh;\n");
      out.write("                position: relative;\n");
      out.write("                -webkit-font-smoothing: antialiased;\n");
      out.write("                -moz-osx-font-smoothing: grayscale;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("\n");
      out.write("            table {\n");
      out.write("                max-width: 960px;\n");
      out.write("                margin: 10px auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            caption {\n");
      out.write("                font-size: 1.6em;\n");
      out.write("                font-weight: 400;\n");
      out.write("                padding: 10px 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            thead th {\n");
      out.write("                font-weight: 400;\n");
      out.write("                background: #8a97a0;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tr {\n");
      out.write("                background: #f4f7f8;\n");
      out.write("                border-bottom: 1px solid #fff;\n");
      out.write("                margin-bottom: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tr:nth-child(even) {\n");
      out.write("                background: #e8eeef;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            th,\n");
      out.write("            td {\n");
      out.write("                text-align: left;\n");
      out.write("                padding: 20px;\n");
      out.write("                font-weight: 300;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <caption>LISTADO DEL CENSO</caption>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">NIF</th>\n");
      out.write("                    <th scope=\"col\">Nombre</th>\n");
      out.write("                    <th scope=\"col\">Apellidos</th>\n");
      out.write("                    <th scope=\"col\">Domicilio</th>\n");
      out.write("                    <th scope=\"col\">Fecha de Nacimiento</th>\n");
      out.write("                    <th scope=\"col\">Votado</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
 HttpSession sesion = request.getSession(true);
                    ArrayList<Votante> ListadoCenso = (ArrayList) session.getAttribute("ListadoCenso");
                    for (Votante objVotante : ListadoCenso) {
                
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"row\">");
      out.print( objVotante.getNif());
      out.write("</th>\n");
      out.write("                    <td>");
      out.print( objVotante.getNombre());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( objVotante.getApellidos());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( objVotante.getDomicilio());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( objVotante.getFechaNacString());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( objVotante.getVotado());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("    </body>\n");
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
