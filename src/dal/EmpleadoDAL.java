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
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author diego.cifuentes
 */
public class EmpleadoDAL {
    
    public int verificarExistenciaEmpleado(int rut) throws ClassNotFoundException, SQLException{
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_BuscarRutEmpleado(?,?)}");
        cstmt.setInt(1,rut);
        cstmt.registerOutParameter(2, Types.INTEGER);
        cstmt.execute();
        return cstmt.getInt(2);
    }
    
    public String agregarEmpleado(EmpleadoDTO empleadoDTO) throws SQLException, ClassNotFoundException{
        String mensaje = "";
        if(verificarExistenciaEmpleado(empleadoDTO.getNumrutEmp())== 0){
            Connection con = new Conexion().abrirOracle();
            CallableStatement cstmt = con.prepareCall("{CALL ontour.SP_INSERTEMPLEADO_JV(?,?,?,?,?,?,?,?,?,?,?)}");
            cstmt.setInt(1,empleadoDTO.getNumrutEmp());
            cstmt.setString(2,String.valueOf(empleadoDTO.getDrutEmp())); 
            cstmt.setString(3,empleadoDTO.getNombreEmp());
            cstmt.setString(4,empleadoDTO.getApellidoPatEmp());
            cstmt.setString(5,empleadoDTO.getApelliddoMatEmp());
            cstmt.setString(6,empleadoDTO.getMailLaboral());
            cstmt.setString(7,String.valueOf(empleadoDTO.getActivo()));
            cstmt.setInt(8, empleadoDTO.getIdUsr());
            cstmt.setString(9,empleadoDTO.getDireccionEmp());
            cstmt.setDate(10,new java.sql.Date(empleadoDTO.getFechaNacimientoEmp().getTime()));
            cstmt.setString(11,empleadoDTO.getFonoEmp());
            cstmt.execute();
            mensaje="Empleado creado exitosamente";
        }else{
            mensaje="Empleado ya existe";
        }
        return mensaje;
    }
    
}
