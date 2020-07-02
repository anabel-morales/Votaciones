
package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    private java.sql.Connection conexion;
    private static Conexion conexionunica = null;
    
    public Conexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bd_votantes";
        this.conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, "root", "");
    }

    public synchronized static Conexion Connect() throws ClassNotFoundException, SQLException {
        if (conexionunica == null) {
            conexionunica = new Conexion();
        }
        return conexionunica;
    }

    public java.sql.Connection getConexion() {
        return conexion;
    }

    public void destroy() throws SQLException {
        conexion.close();
    }
}
