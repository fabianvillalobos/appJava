/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ConexionJB.Conexion;
import dal.UsuarioDAL;
import dto.UsuarioDTO;
import dto.UsuarioPersonaDTO;
import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author diego.cifuentes
 */
public class Test {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        //UsuarioDTO usuarioDto = new UsuarioDTO("test1", "test1", 1, 'T');
        UsuarioDAL usuarioDAL = new UsuarioDAL();
        //int idUsr = usuarioDAL.AgregarUsuario(usuarioDto);
        //System.out.println(idUsr);
        UsuarioPersonaDTO usrPersonaDTO = new UsuarioPersonaDTO();
        usrPersonaDTO = usuarioDAL.obtenerUsuarioPersonaPorId(4);
        
    }
}
