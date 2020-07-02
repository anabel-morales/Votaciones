/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Conexion;
import DAO.DAOperaciones;
import Modelo.ApplicationErrorException;
import Modelo.Partido;
import Modelo.Votante;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anabe
 */
public class ControladorVotar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Conexion miConexion = Conexion.Connect();
            Connection Conexion = (Connection) miConexion.getConexion();
            if (request.getParameter("Votar") != null) {
                HttpSession session = request.getSession(true);
                Votante objVotante = (Votante) session.getAttribute("objVotante");

                String siglas = request.getParameter("siglas");
                Partido objPartido = new Partido(siglas);

                session.setAttribute("PartidoVotado", objPartido);
                DAOperaciones objOperaciones = new DAOperaciones();

                try {
                    Conexion.setAutoCommit(false);
                    objOperaciones.votar(objVotante, Conexion);
                    objOperaciones.registrarVoto(objPartido, Conexion);
                    Conexion.commit();
                    Conexion.setAutoCommit(true);
                } catch (ApplicationErrorException AE) {
                    response.sendRedirect("./VISTAS/Solucion.jsp?codigo=error-registro-voto");
                } catch (SQLException SQLE) {
                    out.println(SQLE.getMessage());

                    if (Conexion != null) {
                        try {
                            Conexion.rollback();

                        } catch (SQLException SQLE2) {
                            out.println(SQLE2.getMessage());
                        }
                    }
                }
//                String agradecimiento = "GRACIAS POR VOTAR. HAS VOTADO A" + siglas + "";
                response.sendRedirect("./VISTAS/Solucion.jsp?codigo=correcto-registro-voto");
            } else {
                response.sendRedirect("./VISTAS/Menu.jsp");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("./VISTAS/Solucion.jsp?codigo=error-registro-voto");
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
