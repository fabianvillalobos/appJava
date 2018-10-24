/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UsuarioDAL;
import hash.HashMD5;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author luisponce
 */
public class ConLogin {

    public boolean validarUsuario(String login, String clave) throws SQLException, ClassNotFoundException {
        UsuarioDAL usuario = new UsuarioDAL();
        String hash = HashMD5.getHashMD5(clave);
        System.out.println(hash);
        if (usuario.obtenerUsuarioPorLogin(login, hash)) {
            return true;
        }
        return false;
        
    }

    public ConLogin() {
        
    }
    
}
