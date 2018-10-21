/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.SeguroDTO;
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
import java.net.URLConnection;

public class Test {
    // http://localhost:8080/RESTfulExample/json/product/get
   
    public static void main(String[] args) throws JAXBException, MalformedURLException, IOException {  

        URL oracle = new URL("http://ontour.somee.com/wsproveedores.asmx/getSegurosConID?id=2");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        JsonParser parser = new JsonParser();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {               
            JsonArray gsonArr = (JsonArray) parser.parse(inputLine);
            // for each element of array
            for (JsonElement obj : gsonArr) {

                // Object of array
                JsonObject gsonObj = obj.getAsJsonObject();

                // Primitives elements of object
                int id = gsonObj.get("se_id").getAsInt();
                String nombre = gsonObj.get("se_nombre").getAsString();
                String empresa = gsonObj.get("se_empresa").getAsString();
                String desc = gsonObj.get("se_desc").getAsString();
                char activo = gsonObj.get("se_activo").getAsCharacter();
                int precio = gsonObj.get("se_precio").getAsInt();

                SeguroDTO seguro = new SeguroDTO();
                seguro.setSe_id(id);
                seguro.setSe_nombre(nombre);
                seguro.setSe_empresa(empresa);
                seguro.setSe_desc(desc);
                seguro.setSe_activo(activo);
                seguro.setSe_precio(precio);

                System.out.println(seguro.toString());
            }
        }
        
      
    }
}
