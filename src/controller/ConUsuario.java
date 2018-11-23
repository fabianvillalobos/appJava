/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UsuarioDAL;
import dto.*;
import hash.HashMD5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luisponce
 */
public class ConUsuario implements ActionListener{
    
    public ConUsuario(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean eliminarUsuario(int userID) throws SQLException{
        UsuarioDAL usuarioDAL = new UsuarioDAL();
        try {
            usuarioDAL.eliminarUsuario(userID);         
            return true;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }
    
    public ComboBoxModel listarTipoUsuarios() throws SQLException{
        ComboBoxModel tipoUsuario = null;
        UsuarioDAL usuarioDAL = new UsuarioDAL();
        ResultSet rs = null;
        try {
            tipoUsuario = usuarioDAL.listarTipoUsuario().getModel();
        } catch (Exception e) {
        }
        return tipoUsuario;
    }
    
    public DefaultTableModel listarUsuarios() throws SQLException{
        UsuarioDAL usuarioDAL = new UsuarioDAL();
        ResultSet rs = null;
        try {
            rs = usuarioDAL.listarUsuario();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames); 
    }
    
    public int agregarUsuario(
            JTextField usuario, JPasswordField clave, JPasswordField repetirClave, 
            JComboBox cbtipoUsuario, JTextField txtNombre, JTextField txtSegundoNombre, 
            JTextField txtApellidoMaterno, JTextField txtApellidoPaterno, JTextField txtRut, 
            JTextField txtDRut, JTextField txtFechaNacimiento, JTextField txtTelefono, 
            JTextField txtEmail, JTextField txtDireccion) 
        throws SQLException, ClassNotFoundException {
       
        String nombreUsuario = usuario.getText();
        String password = clave.getPassword().toString();
        String passwordRe = repetirClave.getPassword().toString();
        int tipoUsuario = cbtipoUsuario.getSelectedIndex();
        String nombre = txtNombre.getText();
        String segundoNombre = txtSegundoNombre.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String dRut = txtDRut.getText();
        String email = txtEmail.getText();
        String fechaNacimiento = txtFechaNacimiento.getText();
        String direccion = txtDireccion.getText();

        if (nombreUsuario.trim().isEmpty()){
            return 0;
        }else{
            String telefono = txtTelefono.getText();
            int numRut = Integer.parseInt(txtRut.getText());
            System.out.println(nombreUsuario+password+tipoUsuario+"T");
            UsuarioDTO usuarioDto = new UsuarioDTO(nombreUsuario, password, tipoUsuario,'T');
            UsuarioDAL usuarioDAL = new UsuarioDAL();
            int usrId = usuarioDAL.AgregarUsuario(usuarioDto); // RETORNAR EL USRID RECIEN CREADO 
            /*
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                Date fechaNacimientoFormat = formatter.parse(fechaNacimiento);
                
                if (tipoUsuario == 3) { //CLIENTE = 3 CAMBIAR LUEGO NO DEBERIA SER EN DURO
                    
                ClienteDTO clienteDTO = new ClienteDTO(numRut, dRut.charAt(0),nombre, apellidoPaterno, apellidoMaterno,email,'T',usrId,direccion, fechaNacimientoFormat, telefono);             
                AGREGAR ACA METODO QUE LLAME AL DAL DE CLIENTE
                }else{
                        EmpleadoDTO empleadoDTO = new EmpleadoDTO(numRut, dRut.charAt(0),nombre, apellidoPaterno, apellidoMaterno,email,direccion,'T',usrId, fechaNacimientoFormat, telefono);
                        AGREGAR ACA METODO QUE LLAME AL DAL DEL EMPLEADO
                    }
                
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
            */
            return usrId;
        }
                    
    }
    
    public UsuarioPersonaDTO verUsuarioPersona(int id) throws SQLException, ClassNotFoundException{
        
        UsuarioDAL usuarioDAL = new UsuarioDAL();
        UsuarioPersonaDTO usuarioPersonaDTO = new UsuarioPersonaDTO();
        usuarioPersonaDTO = usuarioDAL.obtenerUsuarioPersonaPorId(id);
        return usuarioPersonaDTO;
    }
    
    
    public void actualizarUsuario(
            JTextField usuario, JPasswordField clave, JPasswordField repetirClave, 
            JComboBox cbtipoUsuario, JTextField txtNombre, JTextField txtSegundoNombre, 
            JTextField txtApellidoMaterno, JTextField txtApellidoPaterno, JTextField txtRut, 
            JTextField txtDRut, JTextField txtFechaNacimiento, JTextField txtTelefono, 
            JTextField txtEmail, JTextField txtDireccion, JLabel lblIdUser) 
        throws SQLException, ClassNotFoundException {
       
        String nombreUsuario = usuario.getText();
        String password = clave.getPassword().toString();
        String passwordRe = repetirClave.getPassword().toString();
        int tipoUsuario = cbtipoUsuario.getSelectedIndex();
        String nombre = txtNombre.getText();
        String segundoNombre = txtSegundoNombre.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String dRut = txtDRut.getText();
        String email = txtEmail.getText();
        String fechaNacimiento = txtFechaNacimiento.getText();
        String direccion = txtDireccion.getText();
        int idUser = Integer.parseInt(lblIdUser.getText());

        if (nombreUsuario.trim().isEmpty()){

        }else{
            String telefono = txtTelefono.getText();
            int numRut = Integer.parseInt(txtRut.getText());
            System.out.println(nombreUsuario+password+tipoUsuario+"T");
            UsuarioDTO usuarioDto = new UsuarioDTO();
            usuarioDto.setIdTipoUsuario(tipoUsuario);
            usuarioDto.setIdUsr(idUser);
            usuarioDto.setLoginUsr(nombreUsuario);
            usuarioDto.setPassUsr(HashMD5.getHashMD5(password));
            UsuarioDAL usuarioDAL = new UsuarioDAL();
            usuarioDAL.AgregarUsuario(usuarioDto); // RETORNAR EL USRID RECIEN CREADO 
            /*
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                Date fechaNacimientoFormat = formatter.parse(fechaNacimiento);
                
                if (tipoUsuario == 3) { //CLIENTE = 3 CAMBIAR LUEGO NO DEBERIA SER EN DURO
                    
                ClienteDTO clienteDTO = new ClienteDTO(numRut, dRut.charAt(0),nombre, apellidoPaterno, apellidoMaterno,email,'T',usrId,direccion, fechaNacimientoFormat, telefono);             
                
            }
                }else{
                        EmpleadoDTO empleadoDTO = new EmpleadoDTO(numRut, dRut.charAt(0),nombre, apellidoPaterno, apellidoMaterno,email,direccion,'T',usrId, fechaNacimientoFormat, telefono);
                        AGREGAR ACA METODO QUE LLAME AL DAL DEL EMPLEADO
                    }
                
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
            */
        }
                    
    }
    
}