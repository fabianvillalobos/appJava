/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.PaqueteDAL;
import dal.UsuarioDAL;
import dto.UsuarioDTO;
import dto.Vuelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.JDatePanel;
/**
 *
 * @author luisponce
 */
public class ConPaqueteViaje implements ActionListener{
    
    private PaqueteDAL paqueteDAL = new PaqueteDAL();
            
    public ConPaqueteViaje(){
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
    
    public DefaultTableModel listarPaquetes() throws SQLException{
        ResultSet rs = null;
        try {
            rs = paqueteDAL.listarPaquetes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConPaqueteViaje.class.getName()).log(Level.SEVERE, null, ex);

        }
         
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        System.out.println(rs.next());    
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

 
    public DefaultTableModel cargarViajes(String v_origen, int v_pasajeros, String v_destino, Date v_fecha, int v_transporte) throws IOException, MalformedURLException, ParseException {
        DefaultTableModel model = new DefaultTableModel();
        if (v_transporte == 0) {
            //Vuelo
            String col[] = {"ID","Aerolinea","Origen","Destino","Fecha Salida","Precio","Duracion","Capacidad"};
            List<Vuelo> vuelos = this.paqueteDAL.getVuelos(v_origen, v_pasajeros, v_destino, v_fecha);
            
            for (int i = 0; i < vuelos.size(); i++) {
                int id = vuelos.get(i).getId();
                char aerolinea = vuelos.get(i).getAerolinea();
                String origen = vuelos.get(i).getOrigen();
                String destino = vuelos.get(i).getDestino();
                Date salida = vuelos.get(i).getSalida();
                int precio = vuelos.get(i).getPrecio();
                int duracion = vuelos.get(i).getDuracion();
                int capacidad = vuelos.get(i).getCapacidad();
                Object[] data = {id, aerolinea, origen, destino, salida,precio,duracion,capacidad};
                System.out.println(id+aerolinea+origen+destino+salida+precio+duracion+capacidad);
                model.addRow(data);
            }
            
        }else{
            //Buses
            
        }
        
        return model;
    
    }
    
    
    
    
}
