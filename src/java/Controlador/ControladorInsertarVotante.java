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
import Modelo.Votante;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anabe
 */
public class ControladorInsertarVotante extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);

            String nif = request.getParameter("nif");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String domicilio = request.getParameter("domicilio");
            LocalDate fechanac = LocalDate.parse(request.getParameter("fechanac"));
            String password = request.getParameter("password");
            String votado= "NV";
            String rol= "Votante";

            Votante objVotante = new Votante(nif, nombre, apellidos, domicilio, fechanac, password, votado, rol);
            try {
                Conexion miConexion = Conexion.Connect();
                Connection conexion = (Connection) miConexion.getConexion();
                try {
                    java.sql.Connection Conexion;
                    Parametros Param = new DAOperaciones().obtenerParametros(conexion);
                    session.setAttribute("objParametros", Param);

                } catch (ApplicationErrorException AE) {
                    response.sendRedirect("./VISTAS/Solucion.jsp?codigo=parametros");
                }
                new DAOperaciones().insertarVotante(objVotante, conexion);
                session.setAttribute("objVotante", objVotante);
                response.sendRedirect("./VISTAS/Menu.jsp");
            } catch (ApplicationErrorException AE) {
                response.sendRedirect("./VISTAS/Solucion.jsp?codigo=error-insertar-votante");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("./VISTAS/Solucion.jspcodigo=error2-insertar-votante");
            }
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
