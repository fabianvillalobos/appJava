/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import ConexionJB.Conexion;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dto.Alojamiento;
import dto.Bus;
import dto.PaqueteViajeDTO;
import dto.Seguro;
import dto.Servicio;
import dto.Vuelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author luisponce
 */
public class PaqueteDAL {

    public ResultSet listarPaquetes() throws SQLException, ClassNotFoundException {
        Connection con = new Conexion().abrirOracle();
        ResultSet result;
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_ListaPaqueteViajeFormateado(?)}");
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.executeUpdate();
        result = (ResultSet) cstmt.getObject(1);
        return result;
    }

    public List<Vuelo> getVuelos(String o_terminal, String o_ciudad, String o_pais, int pasajeros,
            String d_terminal, String d_ciudad, String d_pais, Date v_fecha) throws MalformedURLException, IOException, ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String v_salida = df.format(v_fecha);
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getVuelos?origen_terminal="
                + o_terminal + "&origen_ciudad=" + o_ciudad + "&origen_pais=" + o_pais
                + "&destino_terminal=" + d_terminal + "&destino_ciudad=" + d_ciudad + "&destino_pais="
                + d_pais + "&salida=" + v_fecha + "&pasajeros=" + pasajeros;
        laUrl = laUrl.replaceAll(" ", "%20");
        URL oracle = new URL(laUrl);

        System.out.println(oracle.toString());
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        while ((inputLine = in.readLine()) != null) {
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();

                int vid = gsonObj.get("id").getAsInt();
                char vaerolinea = gsonObj.get("aerolinea").getAsCharacter();
                String vo_terminal = gsonObj.get("o_terminal").getAsString();
                String vo_ciudad = gsonObj.get("o_ciudad").getAsString();
                String vo_pais = gsonObj.get("o_pais").getAsString();
                String vd_terminal = gsonObj.get("d_terminal").getAsString();
                String vd_ciudad = gsonObj.get("d_ciudad").getAsString();
                String vd_pais = gsonObj.get("d_pais").getAsString();
                String salida = gsonObj.get("salida").getAsString();
                int vduracion = gsonObj.get("duracion").getAsInt();
                int vcapacidad = gsonObj.get("capacidad").getAsInt();
                int vocupados = gsonObj.get("ocupados").getAsInt();
                char vactivo = gsonObj.get("activo").getAsCharacter();
                int vprecio = gsonObj.get("precio").getAsInt();
                String str = salida.replace("/Date(", "").replace(")/", "");
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                Date d_salida = new Date(Long.parseLong(str));

                Vuelo vuelo = new Vuelo(vid, vaerolinea, vo_terminal, vo_ciudad, vo_pais, vd_terminal, vd_ciudad,
                        vd_pais, d_salida, vduracion, vcapacidad, vocupados, vactivo, vprecio);
                vuelos.add(vuelo);
            }
        }

        return vuelos;

    }

    public List<Bus> getBuses(String o_terminal, String o_ciudad, String o_pais,
            String d_terminal, String d_ciudad, String d_pais, Date v_salida,
            int v_pasajeros) throws MalformedURLException, IOException, ParseException {
        //String v_origen_cortada = o_ciudad.substring(0, o_ciudad.indexOf(","));
        //String v_destino_cortada = o_pais.substring(0, o_pais.indexOf(","));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = df.format(v_salida);
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getBuses?origen_terminal="
                + o_terminal + "&origen_ciudad=" + o_ciudad + "&origen_pais=" + o_pais + "&destino_terminal=" + d_terminal
                + "&destino_ciudad=" + d_ciudad + "&destino_pais=" + d_pais + "&salida=" + fecha + "&pasajeros="
                + v_pasajeros;
        laUrl = laUrl.replaceAll(" ", "%20");
        
        URL oracle = new URL(laUrl);

        System.out.println(oracle.toString());
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        ArrayList<Bus> buses = new ArrayList<Bus>();
        while ((inputLine = in.readLine()) != null) {
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();

                int bid = gsonObj.get("id").getAsInt();
                char blinea = gsonObj.get("linea").getAsCharacter();
                String bo_terminal = gsonObj.get("o_terminal").getAsString();
                String bo_ciudad = gsonObj.get("o_ciudad").getAsString();
                String bo_pais = gsonObj.get("o_pais").getAsString();
                String bd_terminal = gsonObj.get("d_terminal").getAsString();
                String bd_ciudad = gsonObj.get("d_ciudad").getAsString();
                String bd_pais = gsonObj.get("d_pais").getAsString();
                String salida = gsonObj.get("salida").getAsString();
                int bduracion = gsonObj.get("duracion").getAsInt();
                int bcapacidad = gsonObj.get("capacidad").getAsInt();
                int bocupados = gsonObj.get("ocupados").getAsInt();
                char bactivo = gsonObj.get("activo").getAsCharacter();
                int bprecio = gsonObj.get("precio").getAsInt();
                String str = salida.replace("/Date(", "").replace(")/", "");
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                Date d_salida = new Date(Long.parseLong(str));

                Bus bus = new Bus(bid, salida, d_salida, bduracion, bcapacidad, bocupados, bactivo, bprecio, o_terminal, o_ciudad, o_pais, d_terminal, d_ciudad, d_pais);
                buses.add(bus);
            }
        }

        return buses;
    }

    public List<Alojamiento> getAlojamientos(String v_ciudad, String v_pais, int v_pasajeros) throws MalformedURLException, IOException, ParseException {
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getAlojamientos?ciudad=" + v_ciudad + "&pais=" + v_pais + "&habitacion=" + v_pasajeros;
        laUrl = laUrl.replaceAll(" ", "%20");
        URL oracle = new URL(laUrl);
        System.out.println(oracle.toString());
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
        while ((inputLine = in.readLine()) != null) {
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();

                int id = gsonObj.get("h_id").getAsInt();
                String nombre = gsonObj.get("h_nombre").getAsString();
                String direccion = gsonObj.get("h_direccion").getAsString();
                String ciudad = gsonObj.get("h_ciudad").getAsString();
                String pais = gsonObj.get("h_pais").getAsString();
                int habitacion = gsonObj.get("h_habitacion").getAsInt();
                int precio = gsonObj.get("h_precio").getAsInt();
                char ocupada = gsonObj.get("h_ocupada").getAsCharacter();
                char activo = gsonObj.get("h_activa").getAsCharacter();
                String servicios = gsonObj.get("h_servicios").getAsString();

                Alojamiento alojamiento = new Alojamiento(id, nombre, direccion, ciudad, pais, habitacion, precio, ocupada, activo, servicios);
                alojamientos.add(alojamiento);
            }
        }
        return alojamientos;
    }

    public List<Seguro> getSeguros() throws MalformedURLException, IOException, ParseException {
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getSeguros";
        laUrl = laUrl.replaceAll(" ", "%20");
        URL oracle = new URL(laUrl);
        System.out.println(oracle.toString());
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        ArrayList<Seguro> seguros = new ArrayList<Seguro>();
        while ((inputLine = in.readLine()) != null) {
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();

                int id = gsonObj.get("se_id").getAsInt();
                String nombre = gsonObj.get("se_nombre").getAsString();
                String empresa = gsonObj.get("se_empresa").getAsString();
                String desc = gsonObj.get("se_desc").getAsString();
                String salida = gsonObj.get("se_vigencia").getAsString();
                String str = salida.replace("/Date(", "").replace(")/", "");
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                Date d_salida = new Date(Long.parseLong(str));

                char activo = gsonObj.get("se_activo").getAsCharacter();
                int precio = gsonObj.get("se_precio").getAsInt();

                Seguro seguro = new Seguro(id, nombre, empresa, desc, d_salida, activo, precio);
                seguros.add(seguro);
            }
        }
        return seguros;
    }

    public int nuevoPaqueteViaje(PaqueteViajeDTO paqueteViaje) throws SQLException, ClassNotFoundException {
        Connection con = new Conexion().abrirOracle();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = df.format(paqueteViaje.getFechaCreacionPaqviaje());

        CallableStatement cstmt = con.prepareCall("{CALL ontour.SP_INSERTAPAQUETE(?,?,?,?,?)}");
        cstmt.setString(1, paqueteViaje.getDescPaqueteviaje());
        cstmt.setInt(2, paqueteViaje.getValorPaqueteviaje());
        cstmt.setString(3, String.valueOf(paqueteViaje.getActivo()));
        cstmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
        cstmt.registerOutParameter(5, Types.INTEGER);
        cstmt.execute();
        return cstmt.getInt(5);
    }

    public int nuevoServicio(Servicio servicio) throws SQLException, ClassNotFoundException {
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.SP_INSERTASERVICIO(?,?,?,?)}");
        cstmt.setInt(1, servicio.getIdWs());
        cstmt.setString(2, String.valueOf('T'));
        cstmt.setInt(3, servicio.getIdTipoServicio());
        cstmt.registerOutParameter(4, Types.INTEGER);
        cstmt.execute();
        return cstmt.getInt(4);
    }

    public void nuevoServicioPaquete(int id_servicio, int id_paqueteViaje, char activo) throws SQLException, ClassNotFoundException {
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.SP_INSERTASERVICIOPAQUETE(?,?,?)}");
        cstmt.setInt(1, id_servicio);
        cstmt.setInt(2, id_paqueteViaje);
        cstmt.setString(3, String.valueOf(activo));
        cstmt.execute();
    }

    public List<Servicio> getServiciosElegidos(int idPaquete) throws ClassNotFoundException, SQLException {
        Connection con = new Conexion().abrirOracle();
        ResultSet result;
        System.out.println(idPaquete);
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_ListarServiciosPorPaquete(?,?)}");
        cstmt.setInt(1, idPaquete);
        cstmt.registerOutParameter(2, OracleTypes.CURSOR);
        cstmt.executeUpdate();
        result = (ResultSet) cstmt.getObject(2);
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
        while (result.next()) {
            Servicio servicio = new Servicio();
            servicio.setIdWs(result.getInt("ID_SERVICIO_WS"));
            servicio.setIdTipoServicio(result.getInt("ID_TIPO_SERVICIO"));
            servicios.add(servicio);
        }
        return servicios;
    }

    public List<Vuelo> getVuelosConId(int idWs) throws MalformedURLException, IOException {
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getVueloConID?id=" + idWs;
        URL oracle = new URL(laUrl);
        System.out.println(oracle.toString());
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        while ((inputLine = in.readLine()) != null) {
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();

                int vid = gsonObj.get("id").getAsInt();
                char vaerolinea = gsonObj.get("aerolinea").getAsCharacter();
                String vo_terminal = gsonObj.get("o_terminal").getAsString();
                String vo_ciudad = gsonObj.get("o_ciudad").getAsString();
                String vo_pais = gsonObj.get("o_pais").getAsString();
                String vd_terminal = gsonObj.get("d_terminal").getAsString();
                String vd_ciudad = gsonObj.get("d_ciudad").getAsString();
                String vd_pais = gsonObj.get("d_pais").getAsString();
                String salida = gsonObj.get("salida").getAsString();
                int vduracion = gsonObj.get("duracion").getAsInt();
                int vcapacidad = gsonObj.get("capacidad").getAsInt();
                int vocupados = gsonObj.get("ocupados").getAsInt();
                char vactivo = gsonObj.get("activo").getAsCharacter();
                int vprecio = gsonObj.get("precio").getAsInt();
                String str = salida.replace("/Date(", "").replace(")/", "");
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                Date d_salida = new Date(Long.parseLong(str));

                Vuelo vuelo = new Vuelo(vid, vaerolinea, vo_terminal, vo_ciudad, vo_pais, vd_terminal, vd_ciudad,
                        vd_pais, d_salida, vduracion, vcapacidad, vocupados, vactivo, vprecio);
                vuelos.add(vuelo);
            }
        }
        return vuelos;
    }

    public List<Bus> getBusesConId(int idWs) throws MalformedURLException, IOException {
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getBusesConID?id=" + idWs;
        URL oracle = new URL(laUrl);
        System.out.println(oracle.toString());
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        ArrayList<Bus> buses = new ArrayList<Bus>();
        while ((inputLine = in.readLine()) != null) {
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();
                int bid = gsonObj.get("id").getAsInt();
                char blinea = gsonObj.get("linea").getAsCharacter();
                String bo_terminal = gsonObj.get("o_terminal").getAsString();
                String bo_ciudad = gsonObj.get("o_ciudad").getAsString();
                String bo_pais = gsonObj.get("o_pais").getAsString();
                String bd_terminal = gsonObj.get("d_terminal").getAsString();
                String bd_ciudad = gsonObj.get("d_ciudad").getAsString();
                String bd_pais = gsonObj.get("d_pais").getAsString();
                String salida = gsonObj.get("salida").getAsString();
                int bduracion = gsonObj.get("duracion").getAsInt();
                int bcapacidad = gsonObj.get("capacidad").getAsInt();
                int bocupados = gsonObj.get("ocupados").getAsInt();
                char bactivo = gsonObj.get("activo").getAsCharacter();
                int bprecio = gsonObj.get("precio").getAsInt();
                String str = salida.replace("/Date(", "").replace(")/", "");
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                Date d_salida = new Date(Long.parseLong(str));
                Bus bus = new Bus(bid, salida, d_salida, bduracion, bcapacidad, bocupados, bactivo, bprecio, bo_terminal, bo_ciudad, bo_pais, bd_terminal, bd_ciudad, bd_pais);
                buses.add(bus);
            }
        }
        return buses;
    }

    public List<Alojamiento> getAlojamientosConId(int idWs) throws MalformedURLException, IOException {
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getAlojamientoConID?id=" + idWs;
        URL oracle = new URL(laUrl);
        System.out.println(oracle.toString());
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
        while ((inputLine = in.readLine()) != null) {
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();
                int id = gsonObj.get("h_id").getAsInt();
                String nombre = gsonObj.get("h_nombre").getAsString();
                String direccion = gsonObj.get("h_direccion").getAsString();
                String ciudad = gsonObj.get("h_ciudad").getAsString();
                String pais = gsonObj.get("h_pais").getAsString();
                int habitacion = gsonObj.get("h_habitacion").getAsInt();
                int precio = gsonObj.get("h_precio").getAsInt();
                char ocupada = gsonObj.get("h_ocupada").getAsCharacter();
                char activo = gsonObj.get("h_activa").getAsCharacter();
                String servicios = gsonObj.get("h_servicios").getAsString();
                Alojamiento alojamiento = new Alojamiento(id, nombre, direccion, ciudad, pais, habitacion, precio, ocupada, activo, servicios);
                alojamientos.add(alojamiento);
            }
        }
        return alojamientos;
    }

    public List<Seguro> getSeguroConId(int idWs) throws MalformedURLException, IOException {
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getSegurosConID?id=" + idWs;
        URL oracle = new URL(laUrl);
        System.out.println(oracle.toString());
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        ArrayList<Seguro> seguros = new ArrayList<Seguro>();
        while ((inputLine = in.readLine()) != null) {
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();
                int id = gsonObj.get("se_id").getAsInt();
                String nombre = gsonObj.get("se_nombre").getAsString();
                String empresa = gsonObj.get("se_empresa").getAsString();
                String desc = gsonObj.get("se_desc").getAsString();
                String salida = gsonObj.get("se_vigencia").getAsString();
                String str = salida.replace("/Date(", "").replace(")/", "");
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                Date d_salida = new Date(Long.parseLong(str));
                char activo = gsonObj.get("se_activo").getAsCharacter();
                int precio = gsonObj.get("se_precio").getAsInt();
                Seguro seguro = new Seguro(id, nombre, empresa, desc, d_salida, activo, precio);
                seguros.add(seguro);
            }
        }
        return seguros;
    }

    public boolean eliminarPaqueteViaje(int idPaqueteTuristico) throws ClassNotFoundException, SQLException {
        Connection con = new Conexion().abrirOracle();
        CallableStatement cstmt = con.prepareCall("{CALL ontour.sp_EliminaPaqueteViaje(?)}");
        cstmt.setInt(1, idPaqueteTuristico);
        cstmt.execute();
        con.close();
        return true;
    }
}
