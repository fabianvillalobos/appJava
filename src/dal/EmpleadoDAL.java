/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import ConexionJB.Conexion;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author diego.cifuentes
 */
public class EmpleadoDAL {
    
    public void agregarEmpleado(EmpleadoDTO empleadoDTO) throws SQLException, ClassNotFoundException{
        
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_InsertaEmpleado(?,?,?,?,?,?,?,?,?,?)}");
        cstmt.setInt(1,empleadoDTO.getNumrutEmp());
        cstmt.setString(2,String.valueOf(empleadoDTO.getDrutEmp()));
        cstmt.setString(3,empleadoDTO.getNombreEmp());
        cstmt.setString(4,empleadoDTO.getApellidoPatEmp());
        cstmt.setString(5,empleadoDTO.getApelliddoMatEmp());
        cstmt.setString(6,empleadoDTO.getMailLaboral());
        cstmt.setString(7,String.valueOf(empleadoDTO.getActivo()));
        cstmt.setString(8,empleadoDTO.getDireccionEmp());
        cstmt.setDate(9,new java.sql.Date(empleadoDTO.getFechaNacimientoEmp().getTime()));
        cstmt.setString(10,empleadoDTO.getFonoEmp());
        cstmt.execute();
    }
    
}
