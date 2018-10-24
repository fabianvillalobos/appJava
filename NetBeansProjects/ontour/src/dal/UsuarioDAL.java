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
import javax.swing.JComboBox;

import oracle.jdbc.OracleTypes;
/**
 *
 * @author diego.cifuentes
 */
public class UsuarioDAL {
    
    public int actualizarUsuario(UsuarioDTO usuarioDTO) throws SQLException, ClassNotFoundException{  
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_ActualizaUsuario(?,?,?,?)}");
        cstmt.setInt(1,usuarioDTO.getIdUsr());
        cstmt.setString(2,usuarioDTO.getLoginUsr());
        cstmt.setString(3, usuarioDTO.getPassUsr());
        cstmt.setInt(4,usuarioDTO.getIdTipoUsuario());
        cstmt.execute();
        return cstmt.getInt(5);
    }
    
    
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
    
    public JComboBox listarTipoUsuario() throws SQLException, ClassNotFoundException{
        JComboBox tipoUsuarios = new JComboBox();
        Connection con = new Conexion().abrirOracle();
        Statement stmt;
        ResultSet result;
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_ListaTipoUsuarios(?)}");
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);   
        cstmt.executeUpdate();
        result = (ResultSet)cstmt.getObject(1);
           
        while(result.next()){                     
         tipoUsuarios.addItem(result.getString("DESC_TIPO_USUARIO")); 
        }
        return tipoUsuarios;
    }
    
    public ResultSet listarUsuario() throws SQLException, ClassNotFoundException{
        Connection con = new Conexion().abrirOracle();
        ResultSet result;
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_ListaUsuarios(?)}");
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);   
        cstmt.executeUpdate();
        result = (ResultSet)cstmt.getObject(1);
        
        return result;
    }
    
    public boolean eliminarUsuario(int userID) throws SQLException, ClassNotFoundException{
        Connection con = new Conexion().abrirOracle();
        //Statement stmt;
        //ResultSet result;        
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_EliminaUsuario(?)}");
        cstmt.setInt(1,userID);
        cstmt.execute();
        con.close();
        
        return true;
    }
    
    public UsuarioPersonaDTO obtenerUsuarioPersonaPorId(int idUsr) throws SQLException, ClassNotFoundException{
    
        Connection con = new Conexion().abrirOracle();
        ResultSet result;
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_ObtenerUsuarioPersonaPorId(?,?)}");
        cstmt.setInt(1,idUsr);
        cstmt.registerOutParameter(2, OracleTypes.CURSOR);   
        cstmt.executeUpdate();
        result = (ResultSet)cstmt.getObject(2);
        
        UsuarioPersonaDTO usrPerDTO = new UsuarioPersonaDTO();
        
        result.next(); 
        usrPerDTO.setLoginUsr(result.getString("login_usr"));
        usrPerDTO.setPassUsr(result.getString("pass_usr"));
        usrPerDTO.setIdTipoUsuario(result.getInt("id_tipo_usuario")); 
        usrPerDTO.setUsuarioactivo(result.getString("usuario_activo").charAt(0)); 
        usrPerDTO.setNumrut(result.getInt("numrut"));  
        usrPerDTO.setDrut(result.getString("drut").charAt(0)); 
        usrPerDTO.setNombre(result.getString("nombre")); 
        usrPerDTO.setApellidoPat(result.getString("apellido_pat")); 
        usrPerDTO.setApelliddoMat(result.getString("apellido_mat"));  
        usrPerDTO.setMail(result.getString("mail") ); 
        usrPerDTO.setActivo(result.getString("activo").charAt(0));
        usrPerDTO.setIdUsr(result.getInt("id_usr") ); 
        usrPerDTO.setDireccion(result.getString("direccion"));
        usrPerDTO.setFechaNacimiento(result.getDate("fecha_nacimiento"));
        usrPerDTO.setFono(result.getString("fono")); 
        

        return usrPerDTO;
    }
    
    public boolean obtenerUsuarioPorLogin(String login, String hash) throws SQLException, ClassNotFoundException{
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.SP_VALIDAUSUARIO(?,?,?}");
        cstmt.setString(1,login);
        cstmt.setString(2,hash);
        cstmt.registerOutParameter(3, Types.CHAR);  
        System.out.println(login+hash);
        cstmt.execute();
        if (cstmt.getString(3).charAt(0)=='T') {
            System.out.println(cstmt.getString(3).charAt(0));
            return true;
        }else{
            System.out.println(cstmt.getString(3).charAt(0));
            return false;
        }
    }
}