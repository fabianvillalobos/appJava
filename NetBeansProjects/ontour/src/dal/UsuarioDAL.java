/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import ConexionJB.Conexion;
import dto.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author diego.cifuentes
 */
public class UsuarioDAL {
    
    public int AgregarUsuario(UsuarioDTO usuarioDTO) throws SQLException, ClassNotFoundException{  
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_InsertaUsuario(?,?,?,?,?)}");
        cstmt.setString(1,usuarioDTO.getLoginUsr());
        cstmt.setString(2, usuarioDTO.getPassUsr());
        cstmt.setInt(3,usuarioDTO.getIdTipoUsuario());
        cstmt.setString(4,String.valueOf(usuarioDTO.getActivo()));
        cstmt.registerOutParameter(5, Types.INTEGER);
        cstmt.execute();
        return cstmt.getInt(5);
    }
    
    public ResultSet listarUsuario() throws SQLException, ClassNotFoundException{
        Connection con = new Conexion().abrirOracle();
        Statement stmt;
        ResultSet result;
        String query = "SELECT * FROM USUARIO";
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        result = stmt.executeQuery(query);        
        return result;
    }
    
    public boolean eliminarUsuario(int userID) throws SQLException, ClassNotFoundException{
        Connection con = new Conexion().abrirOracle();
        Statement stmt;
        ResultSet result;
        String query = "DELETE FROM USUARIO WHERE ID_USR = "+userID;
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        result = stmt.executeQuery(query);
        con.commit();
        con.close();
        return true;
    }
}
