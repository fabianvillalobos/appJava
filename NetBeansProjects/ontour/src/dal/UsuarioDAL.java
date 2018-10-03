/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.*;
import servicios.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
/**
 *
 * @author diego.cifuentes
 */
public class UsuarioDAL {
    
    public int AgregarUsuario(UsuarioDTO usuarioDTO) throws SQLException{
        
        ConexionServ connServ = new ConexionServ();
        Connection con = connServ.abrir();
        
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_InsertaUsuario(?,?,?,?,?)}");
        cstmt.setString(1,usuarioDTO.getLoginUsr());
        cstmt.setString(2, usuarioDTO.getPassUsr());
        cstmt.setInt(3,usuarioDTO.getIdTipoUsuario());
        cstmt.setString(4,String.valueOf(usuarioDTO.getActivo()));
        cstmt.registerOutParameter(5, Types.INTEGER);
        cstmt.execute();
               
        return cstmt.getInt(2);
    }
}
