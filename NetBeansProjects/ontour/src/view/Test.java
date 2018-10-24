/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.Seguro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dto.Vuelo;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {
    // http://localhost:8080/RESTfulExample/json/product/get
   
    public static void main(String[] args) throws JAXBException, MalformedURLException, IOException, ParseException {  
        
//        FOR JSON Only Object.
//        URL oracle = new URL("http://ontour.somee.com/wsproveedores.asmx/json_getSegurosConID?id=2");
//        URLConnection yc = oracle.openConnection();
//        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
//        JsonParser parser = new JsonParser();
//        String inputLine;
//        while ((inputLine = in.readLine()) != null) {               
//            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
//            for (JsonElement obj : gsonArr) {
//
//                // Object of array
//                JsonObject gsonObj = obj.getAsJsonObject();
//
//                int id = gsonObj.get("se_id").getAsInt();
//                String nombre = gsonObj.get("se_nombre").getAsString();
//                String empresa = gsonObj.get("se_empresa").getAsString();
//                String desc = gsonObj.get("se_desc").getAsString();
//                char activo = gsonObj.get("se_activo").getAsCharacter();
//                int precio = gsonObj.get("se_precio").getAsInt();
//
//                SeguroDTO seguro = new SeguroDTO();
//                seguro.setSe_id(id);
//                seguro.setSe_nombre(nombre);
//                seguro.setSe_empresa(empresa);
//                seguro.setSe_desc(desc);
//                seguro.setSe_activo(activo);
//                seguro.setSe_precio(precio);
//
//                System.out.println(seguro.toString());
//            }
//        }
        
        
//        URL oracle = new URL("http://ontour.somee.com/wsproveedores.asmx/json_getVuelos?origen=Santiago,%20Chile&destino=Calama,%20Chile&salida=2019-11-01%2000:00:00&pasajeros=2");
//        URLConnection yc = oracle.openConnection();
//        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
//        JsonParser parser = new JsonParser();
//        String inputLine;
//        while ((inputLine = in.readLine()) != null) {               
//            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
//            for (JsonElement obj : gsonArr) {
//
//                JsonObject gsonObj = obj.getAsJsonObject();
//
//                int id = gsonObj.get("id").getAsInt();
//                char aerolinea = gsonObj.get("aerolinea").getAsCharacter();
//                String origen = gsonObj.get("origen").getAsString();
//                String destino = gsonObj.get("destino").getAsString();
//                String salida = gsonObj.get("salida").getAsString();
//                
//                String str = salida.replace("/Date(", "").replace(")/", ""); 
//                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
//                Date d_salida = new Date(Long.parseLong(str));
//               
//                
//                int duracion = gsonObj.get("duracion").getAsInt();
//                int capacidad = gsonObj.get("capacidad").getAsInt();
//                int ocupados = gsonObj.get("ocupados").getAsInt();
//                char activo = gsonObj.get("activo").getAsCharacter();
//                int precio = gsonObj.get("precio").getAsInt();
//                
//                Vuelo vuelo = new Vuelo(id,aerolinea,origen,destino,d_salida,duracion,capacidad,ocupados,activo,precio);
//
//                System.out.println(vuelo.toString());
//            }
//        }


                  
            
        
            
            
      
    }
}
