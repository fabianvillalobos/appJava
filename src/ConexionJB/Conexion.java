/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionJB;

import java.sql.*;

/**
 *
 * @author diego.cifuentes
 */
public class Conexion {

    public Connection abrirOracle() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@35.199.67.113:1521:xe", "ontour", "ontour");
        return con;
    }
    
}
