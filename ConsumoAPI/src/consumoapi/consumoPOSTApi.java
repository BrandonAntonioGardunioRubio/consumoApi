package consumoapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;


public class consumoPOSTApi {
    public void ConsumoApiPost(){
        try{
            //Preparamos la URL a la que vamos a realizar nuestra peticion
            URL url = new URL("https://gogodev.net/ejercicios/testjava.php");
            //Preparar la infromacion a enviar
            Map<String,Object> params= new LinkedHashMap<>();
            params.put("elm","Hola Mundo");
            //Codificar los datos a enviar.
            StringBuilder postData= new StringBuilder();
            //&elm=Hola Mundo
            for(Map.Entry<String,Object> param:params.entrySet()){
                if(postData.length()!=0){
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            //Establecer un HTTPURLConnection con la configuracion necesaria para realizar el envio
            byte[] postBytes=postData.toString().getBytes("UTF-8");
            //Enviamos la informacion
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Lenght", String.valueOf(postBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytes);
            //Recepcionar la respuesta
            Reader in =new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            for(int c=in.read();c!=-1;c=in.read()){
                System.out.println((char) c);
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
