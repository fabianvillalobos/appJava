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
import java.sql.SQLException;
import java.sql.Types;

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
    
}
