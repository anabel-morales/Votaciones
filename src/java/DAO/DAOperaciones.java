package DAO;

import Modelo.ApplicationErrorException;
import Modelo.Electo;
import Modelo.Escaños;
import Modelo.Parametros;
import Modelo.Partido;
import Modelo.Votante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class DAOperaciones {

    public void insertarVotante(Votante _objVotante, Connection _Conexion) throws ApplicationErrorException {
        try {
            String sql = "INSERT INTO votante(nif, nombre, apellidos, domicilio, fechanac, password, votado, rol) VALUES(?, ?, ?, ?, ?, AES_ENCRYPT(?, 'anabel'), ?, ?)";
            PreparedStatement PrepStm = _Conexion.prepareStatement(sql);
            PrepStm.setString(1, _objVotante.getNif());
            PrepStm.setString(2, _objVotante.getNombre());
            PrepStm.setString(3, _objVotante.getApellidos());
            PrepStm.setString(4, _objVotante.getDomicilio());
            PrepStm.setDate(5, java.sql.Date.valueOf(_objVotante.getFechanac()));
            PrepStm.setString(6, _objVotante.getPassword());
            PrepStm.setString(7, _objVotante.getVotado());
            PrepStm.setString(8, _objVotante.getRol());

            //SE HACE EXECUTEUPDATE PORQUE ES UN INSERT
            int filas = PrepStm.executeUpdate();
            if (filas != 1) {
                throw new ApplicationErrorException("VOTANTE NO INSERTADO", 0, "DAOperaciones.insertar");
            }

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN LA INSERCIÓN DE VOTANTES");
        }
    }

    public Votante buscarVotante(String _nif, String _password, Connection _conexion) throws ApplicationErrorException {
        try {
            PreparedStatement PrepStm = _conexion.prepareStatement("SELECT * FROM votante WHERE nif=? AND AES_DECRYPT(password,'anabel')=?");
            PrepStm.setString(1, _nif);
            PrepStm.setString(2, _password);

            ResultSet rs = PrepStm.executeQuery();
            if (rs.next()) {
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String domicilio = rs.getString("domicilio");
                LocalDate fechanac = rs.getDate("fechanac").toLocalDate();
                String password = rs.getString("password");
                String votado = rs.getString("votado");
                String rol = rs.getString("rol");

                return new Votante(nif, nombre, apellidos, domicilio, fechanac, password, votado, rol);

            } else {
                throw new ApplicationErrorException("NO SE HA ENCONTRADO EL VOTANTE", 0, "DAOperaciones.buscarVotante()");
            }
        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN EL SELECT");
        }
    }

    public void borrarVotante(String _nif, String _password, Connection _Conexion) throws ApplicationErrorException {
        try {
            String sql = "DELETE FROM votante WHERE nif=? AND votado='NV' AND AES_DECRYPT(password,'anabel')=?";
            PreparedStatement PrepStm = _Conexion.prepareStatement(sql);
            PrepStm.setString(1, _nif);
            PrepStm.setString(2, _password);

            //SE HACE EXECUTEUPDATE PORQUE ES UN DELETE
            int filasBorradas = PrepStm.executeUpdate();
            if (filasBorradas != 1) {
                throw new ApplicationErrorException("VOTANTE NO BORRADO", 0, "DAOperaciones.borrarVotante");
            }

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN EL BORRADO DE VOTANTES");
        }
    }

    public void modificarVotante(Votante _objVotante, Connection _Conexion) throws ApplicationErrorException {
        try {
            String sql = "UPDATE votante SET nombre=?, apellidos=?, domicilio=?, fechanac=?, password=AES_ENCRYPT(?,'anabel') WHERE nif=?";
            PreparedStatement PrepStm = _Conexion.prepareStatement(sql);
            PrepStm.setString(1, _objVotante.getNombre());
            PrepStm.setString(2, _objVotante.getApellidos());
            PrepStm.setString(3, _objVotante.getDomicilio());
            PrepStm.setDate(4, java.sql.Date.valueOf(_objVotante.getFechanac()));
            PrepStm.setString(5, _objVotante.getPassword());
            PrepStm.setString(6, _objVotante.getNif());

            //SE HACE EXECUTEUPDATE PORQUE ES UN INSERT
            int filas = PrepStm.executeUpdate();
            if (filas != 1) {
                throw new ApplicationErrorException("VOTANTE NO MODIFICADO", 0, "DAOperaciones.modificarVotante");
            }

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN LA MODIFICACIÓN DE VOTANTES");
        }
    }

    public ArrayList<Votante> getCenso(Connection _Conexion) throws ApplicationErrorException {
        ArrayList<Votante> ListadoCenso = new ArrayList<>();
        try {
            Statement s = _Conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM votante");

            while (rs.next()) {
                ListadoCenso.add(
                        new Votante(
                                rs.getString("nif"),
                                rs.getString("nombre"),
                                rs.getString("apellidos"),
                                rs.getString("domicilio"),
                                rs.getDate("fechanac").toLocalDate(),
                                rs.getString("password"),
                                rs.getString("votado"),
                                rs.getString("rol")
                        )
                );
            }
        } catch (SQLException ex) {
            throw new ApplicationErrorException(ex.getMessage(), ex.getErrorCode(), "ERROR SQL - LISTADO CENSO");
        }

        return ListadoCenso;
    }

    public ArrayList<Partido> getPartidos(Connection _Conexion) throws ApplicationErrorException {

        ArrayList<Partido> ArrayPartidos = new ArrayList<>();
        try {
            Statement s = _Conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM partido");

            while (rs.next()) {
                ArrayPartidos.add(
                        new Partido(
                                rs.getString("nombrepartido"),
                                rs.getString("siglas"),
                                rs.getString("logo"),
                                rs.getInt("votos")
                        )
                );
            }
        } catch (SQLException ex) {
            throw new ApplicationErrorException(ex.getMessage(), ex.getErrorCode(), "ERROR SQL - LISTADO PARTIDOS");
        }

        return ArrayPartidos;
    }

    public void votar(Votante _votante, Connection _conexion) throws ApplicationErrorException {
        int resultado;
        try {
            Statement s = _conexion.createStatement();
            resultado = s.executeUpdate("UPDATE votante SET votado='V' WHERE nif='" + _votante.getNif() + "'");
            if (resultado != 1) {
                throw new ApplicationErrorException("NO SE HA VOTADO CORRECTAMENTE", 0, "DAOperaciones.votar()");
            }
        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN VOTAR");
        }
    }

    public void registrarVoto(Partido _partido, Connection _conexion) throws ApplicationErrorException {
        int resultado;
        try {
            Statement s = _conexion.createStatement();
            resultado = s.executeUpdate("UPDATE partido SET votos=votos+1 WHERE siglas='" + _partido.getSiglas() + "';");
            if (resultado != 1) {
                throw new ApplicationErrorException("NO SE HA SUMADO EL VOTO AL PARTIDO", 0, "DAOperaciones.registarVoto()");
            }
        } catch (SQLException EX) {
            String mensaje = EX.getMessage();
            int codigo = EX.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN LA SENTENCIA SQL");
        }
    }

    public Parametros obtenerParametros(Connection _Conexion) throws ApplicationErrorException {

        Parametros Param = new Parametros();
        try {
            Statement s = _Conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM parametros");

            while (rs.next()) {
                Param.setId(rs.getInt("id"));
                Param.setCircunscripcion(rs.getString("circunscripcion"));
                Param.setCandidatos(rs.getInt("candidatos"));
                Param.setTipoConsulta(rs.getString("tipoConsulta"));
                Param.setFechaConsulta(rs.getDate("fechaConsulta").toLocalDate());
                Param.setEstadoEscrutiño(rs.getString("estadoEscrutiño"));

            }
        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "OBTENER PARAMETROS ERROR");
        }

        return Param;
    }

    public ArrayList<Electo> getEscaños(int _numescaños, Connection _Conexion) throws ApplicationErrorException {

        ArrayList<Partido> ArrayPartidos = new ArrayList<>();
        ArrayList<Electo> ArrayElecto = new ArrayList<>();
        String sql = "SELECT * FROM partido";

        try {
            Statement s = _Conexion.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombrepartido = rs.getString("nombrepartido");
                String siglas = rs.getString("siglas");
                String logo = rs.getString("logo");
                Integer votos = rs.getInt("votos");
                Partido objPartido = new Partido(id, nombrepartido, siglas, logo, votos);
                ArrayPartidos.add(objPartido);
            }
            //ORDENAMOS ARRAYLIST PARTIDOS
            ArrayPartidos.sort(Collections.reverseOrder());

            //CREAMOS ARRAYLIST ESCAÑOS
            ArrayList<Escaños> ArrayEscaños = new ArrayList<>();
            //RECORREMOS
            for (int i = 0; i < _numescaños; i++) {
                int id_partido = ArrayPartidos.get(0).getId();
                String siglas = ArrayPartidos.get(0).getSiglas();
                String logo = ArrayPartidos.get(0).getLogo();
                //LOS VOTOS SE LOS INCREMENTAMOS DIRECTAMENTE AL OBJETO
                Escaños objEscaño = new Escaños(id_partido, siglas, logo, 1);

                //HAY QUE TENER LOS METODOS EQUALS Y HASH EN LA CLASE
                int indice = ArrayEscaños.indexOf(objEscaño);
                if (indice == -1) {
                    ArrayEscaños.add(objEscaño);
                } else {
                    objEscaño = ArrayEscaños.get(indice);
                    objEscaño.setNumescaños(objEscaño.getNumescaños() + 1);
                    ArrayEscaños.set(indice, objEscaño);
                }
                ArrayPartidos.get(0).setVotos(ArrayPartidos.get(0).getVotos() / 2);
                //VOLVEMOS A ORDENAR EL ARRAY
                ArrayPartidos.sort(Collections.reverseOrder());
            }
            for (Escaños objEscaño : ArrayEscaños) {
                String sql2 = "SELECT c.id ,c.nombre_apellidos, p.siglas, p.logo FROM candidatos c, partido p WHERE p.id=c.id_partido AND id_partido=" + objEscaño.getId_partido() + " AND c.orden BETWEEN 1 AND " + objEscaño.getNumescaños() + " ORDER BY orden";
                Statement sr = _Conexion.createStatement();
                ResultSet rs2 = sr.executeQuery(sql2);

                while (rs2.next()) {
                    ArrayElecto.add(
                            new Electo(
                                    rs2.getInt("id"),
                                    rs2.getString("siglas"),
                                    rs2.getString("logo"),
                                    rs2.getString("nombre_apellidos")
                            )
                    );
                }

            }
        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN EL GETESCAÑOS");
        }
        return ArrayElecto;
    }

    public void CerrarEscrutinio(Connection conexion) throws ApplicationErrorException {

        try {
            String ordensql = "UPDATE parametros SET estadoEscrutiño='Cerrado'";
            PreparedStatement ps = conexion.prepareStatement(ordensql);
            ps.executeUpdate();

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN EL CERRARESCRUTINIO");
        }
    }

    public void AbrirEscrutinio(Connection conexion) throws ApplicationErrorException {

        try {
            String ordensql = "UPDATE parametros SET estadoEscrutiño='Abierto'";
            PreparedStatement ps = conexion.prepareStatement(ordensql);
            ps.executeUpdate();

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN EL ABRIRESCRUTINIO");
        }
    }

    public void FinalizarEscrutinio(Connection conexion) throws ApplicationErrorException {

        try {
            String ordensql = "UPDATE parametros SET estadoEscrutiño='Finalizado'";
            PreparedStatement ps = conexion.prepareStatement(ordensql);
            ps.executeUpdate();

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigo = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigo, "ERROR EN EL FINALIZARESCRUTINIO");
        }
    }

}
