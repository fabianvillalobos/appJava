/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import ConexionJB.Conexion;
import dto.*;
import java.sql.*;
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
}
