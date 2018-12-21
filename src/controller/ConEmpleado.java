/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.EmpleadoDAL;
import dto.EmpleadoDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ConEmpleado implements ActionListener{
    public ConEmpleado(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void crearEmpleado(EmpleadoDTO empleadoDTO) throws SQLException{
        EmpleadoDAL empleadoDal = new EmpleadoDAL();
         try {
            empleadoDal.agregarEmpleado(empleadoDTO);
             
            //empleadoDal.agregarEmpleado();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
