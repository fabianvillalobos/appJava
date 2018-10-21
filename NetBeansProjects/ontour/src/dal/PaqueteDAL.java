/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import ConexionJB.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author luisponce
 */
public class PaqueteDAL {
    
    public ResultSet listarPaquetes() throws SQLException, ClassNotFoundException{
        Connection con = new Conexion().abrirOracle();
        ResultSet result;
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_ListaPaqueteViaje(?)}");
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);   
        cstmt.executeUpdate();
        result = (ResultSet)cstmt.getObject(1);
        return result;
    }
}
