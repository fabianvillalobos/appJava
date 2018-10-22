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
import dto.SeguroDTO;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
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

    public List<Vuelo> getVuelos(String v_origen, int v_pasajeros, String v_destino, Date v_fecha) throws MalformedURLException, IOException, ParseException {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String v_salida = df.format(v_fecha);
        String laUrl = "http://ontour.somee.com/wsproveedores.asmx/json_getVuelos?origen="
                +v_origen+"&destino="+v_destino+"&salida="+v_salida+"&pasajeros="+v_pasajeros;
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

                int id = gsonObj.get("id").getAsInt();
                char aerolinea = gsonObj.get("aerolinea").getAsCharacter();
                String origen = gsonObj.get("origen").getAsString();
                String destino = gsonObj.get("destino").getAsString();
                String salida = gsonObj.get("salida").getAsString();
                
                String str = salida.replace("/Date(", "").replace(")/", ""); 
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                Date d_salida = new Date(Long.parseLong(str));
               
                
                int duracion = gsonObj.get("duracion").getAsInt();
                int capacidad = gsonObj.get("capacidad").getAsInt();
                int ocupados = gsonObj.get("ocupados").getAsInt();
                char activo = gsonObj.get("activo").getAsCharacter();
                int precio = gsonObj.get("precio").getAsInt();
                
                Vuelo vuelo = new Vuelo(id,aerolinea,origen,destino,d_salida,duracion,capacidad,ocupados,activo,precio);
                vuelos.add(vuelo);
            }
        }
        
        return vuelos;
        
    }
    
    
}
