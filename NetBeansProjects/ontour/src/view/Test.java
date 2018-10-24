/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ConexionJB.Conexion;
import controller.*;
import dal.*;
import dto.*;
import java.sql.*;
/**
 *
 * @author diego.cifuentes
 */
public class Test {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        //UsuarioDTO usuarioDto = new UsuarioDTO("test1", "test1", 1, 'T');
        //UsuarioDAL usuarioDAL = new UsuarioDAL();
        //int idUsr = usuarioDAL.AgregarUsuario(usuarioDto);
        //System.out.println(idUsr);
        UsuarioPersonaDTO usrPersonaDTO = new UsuarioPersonaDTO();
        usrPersonaDTO = new ConUsuario().verUsuarioPersona(4);
        System.out.println(usrPersonaDTO.getApellidoPat());
    }
}
