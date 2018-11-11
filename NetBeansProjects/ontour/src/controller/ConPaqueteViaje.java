/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.PaqueteDAL;
import dal.UsuarioDAL;
import dto.Alojamiento;
import dto.Bus;
import dto.PaqueteViajeDTO;
import dto.Seguro;
import dto.Servicio;
import dto.Vuelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.JDatePanel;
/**
 *
 * @author luisponce
 */
public class ConPaqueteViaje implements ActionListener{
    
    private final PaqueteDAL paqueteDAL = new PaqueteDAL();
            
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
        if (v_transporte == 0) {
            //Vuelo
            String col[] = {"ID","Aerolinea","Origen","Destino","Fecha Salida","Precio","Duracion","Capacidad"};
            DefaultTableModel model = new DefaultTableModel(col, 0);
                        
            List<Vuelo> vuelos = this.paqueteDAL.getVuelos(v_origen, v_pasajeros, v_destino, v_fecha);
            if (!vuelos.isEmpty()) {
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
            } else{
                Object[] data = {"No se han encontrado vuelos"};
                model.addRow(data);
            }
            return model;
        }else{
            //Buses
            String col[] = {"ID","Linea","Origen","Destino","Fecha Salida","Precio","Duracion"};
            DefaultTableModel model = new DefaultTableModel(col, 0);
                        
            List<Bus> buses = this.paqueteDAL.getBuses(v_origen, v_pasajeros, v_destino, v_fecha);
            
            for (int i = 0; i < buses.size(); i++) {
                int id = buses.get(i).getId();
                char linea = buses.get(i).getLinea();
                String origen = buses.get(i).getOrigen();
                String destino = buses.get(i).getDestino();
                Date salida = buses.get(i).getSalida();
                int precio = buses.get(i).getPrecio();
                int duracion = buses.get(i).getDuracion();
                
                Object[] data = {id, linea, origen, destino, salida,precio,duracion};
                System.out.println(id+linea+origen+destino+salida+precio+duracion);
                model.addRow(data);
            }
            return model;
        }
    }

    public DefaultTableModel cargarEstadia(String v_destino, int v_pasajeros) throws IOException, MalformedURLException, ParseException {
        //Estadia
        String col[] = {"ID","Nombre","Direccion","Ciudad","Pais","Precio","Servicios"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        
        String v_ciudad = v_destino.substring(0, v_destino.indexOf(","));
        String v_pais = v_destino.substring(v_destino.lastIndexOf(',')+1).trim();
        
        List<Alojamiento> alojamientos = this.paqueteDAL.getAlojamientos(v_ciudad, v_pais, v_pasajeros);

        for (int i = 0; i < alojamientos.size(); i++) {
            int id = alojamientos.get(i).getId();
            String nombre = alojamientos.get(i).getNombre();
            String direccion = alojamientos.get(i).getDireccion();
            String ciudad = alojamientos.get(i).getCiudad();
            String pais = alojamientos.get(i).getPais();
            String servicios = alojamientos.get(i).getServicios();
            int precio = alojamientos.get(i).getPrecio();
            
            Object[] data = {id, nombre, direccion, ciudad, pais, precio, servicios};
            System.out.println(id+nombre+direccion+ciudad+pais+servicios+precio);
            model.addRow(data);
        }
        return model;       
    }

    public DefaultTableModel cargarSeguros()  throws IOException, MalformedURLException, ParseException {
        //Seguros
        String col[] = {"ID","Nombre","Empresa","Descripcion","Precio"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
                
        List<Seguro> seguros = this.paqueteDAL.getSeguros();

        for (int i = 0; i < seguros.size(); i++) {
            int id = seguros.get(i).getId();
            String nombre = seguros.get(i).getNombre();
            String empresa = seguros.get(i).getEmpresa();
            String descripcion = seguros.get(i).getDesc();
            int precio = seguros.get(i).getPrecio();
            
            Object[] data = {id, nombre, empresa, descripcion, precio};
            System.out.println(id+nombre+empresa+descripcion+precio);
            model.addRow(data);
        }
        return model;       
    }

    public String calcularPrecio(JTable listadoViajes, JTable listadoEstadia, JTable listadoSeguros) {
        int valor = 0;
        int valor2 = 0;
        int valor3 = 0;
        int precioTotal = 0;
        int row = listadoViajes.getSelectedRow();
        if(row>=0){
           valor = (int) listadoViajes.getModel().getValueAt(row, 5); 
        }

        row = listadoEstadia.getSelectedRow();
        if (row>=0) {
          valor2 = (int) listadoEstadia.getModel().getValueAt(row, 5);   
        }
        
        row = listadoSeguros.getSelectedRow();
        if (row>=0) {
           valor3 = (int) listadoSeguros.getModel().getValueAt(row, 4);
        }
        
        precioTotal = valor+valor2+valor3;
        String precioFormat = String.valueOf(precioTotal);
        
        return precioFormat;
    }

    public boolean nuevoPaquete(String descripcion, int precio, ArrayList<Servicio> servicios) throws SQLException, ClassNotFoundException {
        PaqueteViajeDTO paqueteViaje = new PaqueteViajeDTO(descripcion,precio,'T',new Date());
        int id_paqueteViaje = this.paqueteDAL.nuevoPaqueteViaje(paqueteViaje);
        
        for (int i = 0; i < servicios.size(); i++) {
            int id_servicio = this.paqueteDAL.nuevoServicio(servicios.get(i));
            this.paqueteDAL.nuevoServicioPaquete(id_servicio, id_paqueteViaje, 'T');
        }

        return true;
    }

    public int obtenerWS(JTable listado) {
        int row = listado.getSelectedRow();
        int id = 0;
        
        if(row>=0){
           id = (int) listado.getModel().getValueAt(row, 0); 
        }
        return id;
    }

    public void limpiarCampos(JTextArea descripcion, JTextField origen, JTextField numPasajeros, JTextField destino, JTable viajes, JDatePanel fechaIda, JDatePanel fechaRegreso, JLabel precio, JComboBox transporte, JTable listadoEstadia, JTable listadoSeguros, JTable listadoViajes) {
        descripcion.setText("");
        origen.setText("Ciudad, País");
        numPasajeros.setText("");
        destino.setText("Ciudad, País");
    }

    public boolean fechaValida(JDatePanel fecha) throws ParseException {
        String day = String.valueOf(fecha.getModel().getDay()); 
        String month = String.valueOf(fecha.getModel().getMonth()+1);
        String year = String.valueOf(fecha.getModel().getYear());
        String salida = day+"-"+month+"-"+year;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSalida = formatter.parse(salida);
        Date fechaActual;
        fechaActual = formatter.parse(formatter.format(new Date()));
        fechaActual.setHours(0);
        fechaActual.setMinutes(0);
        fechaActual.setSeconds(0);
        System.out.println(fechaActual.toString());
        System.out.println(fechaSalida.toString());
        
        return fechaActual.compareTo(fechaSalida) <= 0;
    }
    
    public Date getCalendarFecha(JDatePanel fecha) throws ParseException{
        String day = String.valueOf(fecha.getModel().getDay()); 
        String month = String.valueOf(fecha.getModel().getMonth()+1);
        String year = String.valueOf(fecha.getModel().getYear());
        String salida = day+"-"+month+"-"+year;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSalida = formatter.parse(salida);
        return fechaSalida;
    }

    public boolean fechaValidaRegreso(JDatePanel fechaR, JDatePanel fechaI) throws ParseException {
        String day = String.valueOf(fechaR.getModel().getDay()); 
        String month = String.valueOf(fechaR.getModel().getMonth()+1);
        String year = String.valueOf(fechaR.getModel().getYear());
        String salida = day+"-"+month+"-"+year;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaRegreso = formatter.parse(salida);
        
        day = String.valueOf(fechaI.getModel().getDay()); 
        month = String.valueOf(fechaI.getModel().getMonth()+1);
        year = String.valueOf(fechaI.getModel().getYear());
        salida = day+"-"+month+"-"+year;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaIda = formatter.parse(salida);

        return fechaRegreso.compareTo(fechaIda) >= 0;
    }

    public List<Servicio> getServiciosElegidos(BigDecimal numeroPaquete) throws ClassNotFoundException, SQLException {
        int idPaquete = numeroPaquete.intValue();
        List<Servicio> servicios = this.paqueteDAL.getServiciosElegidos(idPaquete);
        return servicios;
    }

    public DefaultTableModel getVueloConId(int idWs) throws IOException {
        //Vuelo
            String col[] = {"ID","Aerolinea","Origen","Destino","Fecha Salida","Precio","Duracion","Capacidad"};
            DefaultTableModel model = new DefaultTableModel(col, 0);
                        
            List<Vuelo> vuelos = this.paqueteDAL.getVuelosConId(idWs);
            if (!vuelos.isEmpty()) {
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
            } else{
                Object[] data = {"No se han encontrado vuelos"};
                model.addRow(data);
            }
            return model;
    }

    public DefaultTableModel getBusConId(int idWs) throws IOException {
        String col[] = {"ID","Linea","Origen","Destino","Fecha Salida","Precio","Duracion"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        List<Bus> buses = this.paqueteDAL.getBusesConId(idWs);
        for (int i = 0; i < buses.size(); i++) {
            int id = buses.get(i).getId();
            char linea = buses.get(i).getLinea();
            String origen = buses.get(i).getOrigen();
            String destino = buses.get(i).getDestino();
            Date salida = buses.get(i).getSalida();
            int precio = buses.get(i).getPrecio();
            int duracion = buses.get(i).getDuracion();
            Object[] data = {id, linea, origen, destino, salida,precio,duracion};
            System.out.println(id+linea+origen+destino+salida+precio+duracion);
            model.addRow(data);
        }
        return model;
    }

    public DefaultTableModel getEstadiaConId(int idWs) throws IOException {
        //Estadia
        String col[] = {"ID","Nombre","Direccion","Ciudad","Pais","Precio","Servicios"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        List<Alojamiento> alojamientos = this.paqueteDAL.getAlojamientosConId(idWs);
        for (int i = 0; i < alojamientos.size(); i++) {
            int id = alojamientos.get(i).getId();
            String nombre = alojamientos.get(i).getNombre();
            String direccion = alojamientos.get(i).getDireccion();
            String ciudad = alojamientos.get(i).getCiudad();
            String pais = alojamientos.get(i).getPais();
            String servicios = alojamientos.get(i).getServicios();
            int precio = alojamientos.get(i).getPrecio();
            Object[] data = {id, nombre, direccion, ciudad, pais, precio, servicios};
            System.out.println(id+nombre+direccion+ciudad+pais+servicios+precio);
            model.addRow(data);
        }
        return model;
    }

    public DefaultTableModel getSeguroConId(int idWs) throws IOException, IOException {
        //Seguros
        String col[] = {"ID","Nombre","Empresa","Descripcion","Precio"};
        DefaultTableModel model = new DefaultTableModel(col, 0);  
        List<Seguro> seguros = this.paqueteDAL.getSeguroConId(idWs);
        for (int i = 0; i < seguros.size(); i++) {
            int id = seguros.get(i).getId();
            String nombre = seguros.get(i).getNombre();
            String empresa = seguros.get(i).getEmpresa();
            String descripcion = seguros.get(i).getDesc();
            int precio = seguros.get(i).getPrecio();
            Object[] data = {id, nombre, empresa, descripcion, precio};
            System.out.println(id+nombre+empresa+descripcion+precio);
            model.addRow(data);
        }
        return model;
    }

    public boolean eliminarPaqueteViaje(int idPaqueteTuristico) throws ClassNotFoundException, SQLException {
        return this.paqueteDAL.eliminarPaqueteViaje(idPaqueteTuristico);
    }
}
