/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import ConexionJB.Conexion;
import dto.ClienteDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author diego.cifuentes
 */
public class ClienteDAL {
    
    public void agregarCliente(ClienteDTO clienteDTO) throws SQLException, ClassNotFoundException{
        
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_InsertCliente(?,?,?,?,?,?,?,?,?,?)}");
        cstmt.setInt(1,clienteDTO.getNumrutCli());
        cstmt.setString(2,String.valueOf(clienteDTO.getDrutCli()));
        cstmt.setString(3,clienteDTO.getNombreCli());
        cstmt.setString(4,clienteDTO.getApellidoPatCli());
        cstmt.setString(5,clienteDTO.getApelliddoMatCli());
        cstmt.setString(6,clienteDTO.getMailCli());
        cstmt.setString(7,String.valueOf(clienteDTO.getActivo()));
        cstmt.setString(8,clienteDTO.getDireccionCli());
        cstmt.setDate(9,new java.sql.Date(clienteDTO.getFechaNacimientoCli().getTime()));
        cstmt.setString(10,clienteDTO.getFonoCli());
        cstmt.execute();
    }
      public JComboBox listarClienteSinUsuarios() throws SQLException, ClassNotFoundException{
        JComboBox listadoClientes = new JComboBox();
        Connection con = new Conexion().abrirOracle();
        Statement stmt;
        ResultSet result;
        CallableStatement cstmt = con.prepareCall("{CALL ontour.SP_LISTACLIENTESSINUSUARIO(?)}");
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.executeUpdate();
        result = (ResultSet)cstmt.getObject(1);
           
        while(result.next()){                     
         listadoClientes.addItem(result.getString("datos_cliente")); 
        }
        return listadoClientes;     
      }
      
      public void actualizarClienteSinUsuario(int numrut_param, int usr_param) throws ClassNotFoundException, SQLException{
          Connection con = new Conexion().abrirOracle();
          CallableStatement cstmt = con.prepareCall("{CALL ontour.SP_UPDATEUSERCLI(?,?)}");
          cstmt.setInt(1, numrut_param);
          cstmt.setInt(2, usr_param);
          cstmt.execute();
      }
}
