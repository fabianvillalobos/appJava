/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UsuarioDAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.UsuarioNuevo;
import dto.*;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
/**
 *
 * @author luisponce
 */
public class ConUsuarioNuevo implements ActionListener{
    
    private final UsuarioNuevo viewUsuarioNuevo;
    
    public ConUsuarioNuevo(){
        viewUsuarioNuevo = new UsuarioNuevo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean btnAddActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {   
        
        // TODO add your handling code here:
        String nombreUsuario = viewUsuarioNuevo.txtUserName.getText();
        String password = viewUsuarioNuevo.pswClave.getSelectedText();
        String passwordRe = viewUsuarioNuevo.pswRepetirClave.getSelectedText();
        int tipoUsuario = viewUsuarioNuevo.cbTipoUsuario.getSelectedIndex();
//        
        String nombre = viewUsuarioNuevo.txtNombre.getText();
        String segundoNombre = viewUsuarioNuevo.txtSegundoNombre.getText();
        String apellidoMaterno = viewUsuarioNuevo.txtApellidoMaterno.getText();
        String apellidoPaterno = viewUsuarioNuevo.txtApellidoPaterno.getText();
        
        String dRut = viewUsuarioNuevo.txtDRut.getText();
        String email = viewUsuarioNuevo.txtEmail.getText();
        String fechaNacimiento = viewUsuarioNuevo.txtFechaNacimiento.getText();
        String direccion = viewUsuarioNuevo.txtDireccion.getText();
        
        String errores = "";
        if (
                nombreUsuario.trim().isEmpty() || 
                password.trim().isEmpty() ||
                passwordRe.trim().isEmpty() ||
                nombre.trim().isEmpty() ||
                apellidoMaterno.trim().isEmpty() ||
                apellidoPaterno.trim().isEmpty() ||
                dRut.trim().isEmpty() ||
                email.trim().isEmpty() ||
                fechaNacimiento.trim().isEmpty() ||
                direccion.trim().isEmpty() ||
                viewUsuarioNuevo.txtNumRut.toString().trim().isEmpty() ||
                viewUsuarioNuevo.txtTelefono.toString().trim().isEmpty()
            ) {
            errores += "Todos los campos deben ser llenados";
            JOptionPane.showMessageDialog(viewUsuarioNuevo, errores);
        }else{
            String telefono = viewUsuarioNuevo.txtTelefono.getText();
            int numRut = Integer.parseInt(viewUsuarioNuevo.txtNumRut.getText());
            
            UsuarioDTO usuarioDto = new UsuarioDTO(nombreUsuario, password, tipoUsuario,'T');
            UsuarioDAL usuarioDAL = new UsuarioDAL();
            
            int usrId = usuarioDAL.AgregarUsuario(usuarioDto); // RETORNAR EL USRID RECIEN CREADO 
            /*
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                Date fechaNacimientoFormat = formatter.parse(fechaNacimiento);
                
                if (tipoUsuario == 3) { //CLIENTE = 3 CAMBIAR LUEGO NO DEBERIA SER EN DURO
                    
                ClienteDTO clienteDTO = new ClienteDTO(numRut, dRut.charAt(0),nombre, apellidoPaterno, apellidoMaterno,email,'T',usrId,direccion, fechaNacimientoFormat, telefono);             
                //AGREGAR ACA METODO QUE LLAME AL DAL DE CLIENTE
                }else{
                        EmpleadoDTO empleadoDTO = new EmpleadoDTO(numRut, dRut.charAt(0),nombre, apellidoPaterno, apellidoMaterno,email,direccion,'T',usrId, fechaNacimientoFormat, telefono);
                        //AGREGAR ACA METODO QUE LLAME AL DAL DEL EMPLEADO
                    }
                
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
            
            */
        }
        return true;
    }  
}
