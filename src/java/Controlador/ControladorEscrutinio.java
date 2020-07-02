/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Conexion;
import DAO.DAOperaciones;
import Modelo.ApplicationErrorException;
import Modelo.Parametros;
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
public class ControladorEscrutinio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Conexion miConexion = Conexion.Connect();
            Connection Conexion = (Connection) miConexion.getConexion();
            HttpSession session = request.getSession(true);
            DAOperaciones objOperaciones = new DAOperaciones();
            if (request.getParameter("Abierto") != null) {
                objOperaciones.AbrirEscrutinio(Conexion);
                response.sendRedirect("./VISTAS/Solucion.jsp?codigo=abierto");
            } else if (request.getParameter("Cerrado") != null) {
                objOperaciones.CerrarEscrutinio(Conexion);
                response.sendRedirect("./VISTAS/Solucion.jsp?codigo=cerrado");
            } else if (request.getParameter("Finalizar") != null) {
                objOperaciones.FinalizarEscrutinio(Conexion);
                response.sendRedirect("./VISTAS/Solucion.jsp?codigo=finalizar");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("./VISTAS/Solucion.jsp?codigo=error-registro-voto");
        } catch (ApplicationErrorException AE) {
            response.sendRedirect("./VISTAS/Solucion.jsp?codigo=error-login-votante");
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
