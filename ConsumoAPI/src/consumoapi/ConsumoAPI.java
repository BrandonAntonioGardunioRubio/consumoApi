package consumoapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


public class ConsumoAPI {


    public static void main(String[] args) {
        //Endpoint
        //https://jsonplaceholder.typicode.com/posts/1
        try {
            // Solicitar petición
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Obtener código de respuesta
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Ocurrió un error: " + responseCode);
            } else {
                // Leer el flujo de entrada de manera eficiente con BufferedReader
                StringBuilder informationString = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        informationString.append(line);
                    }
                }

                // Imprimir el JSON obtenido
                System.out.println(informationString);

                // Parsear el JSON
                JSONObject jsonObject = new JSONObject(informationString.toString());

                // Acceder a los datos del objeto JSONObject
                int userId = jsonObject.getInt("userId");
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");

                // Imprimir los datos
                System.out.println("userId: " + userId);
                System.out.println("id: " + id);
                System.out.println("title: " + title);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        try{
//            //Solicitar peticion
//            URL url= new URL("https://jsonplaceholder.typicode.com/posts/1");
//            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.connect();
//            //otener cdigo de respuesta
//            int responseCode=conn.getResponseCode();
//            if(responseCode!=200){
//                throw new RuntimeException("Ocurrio un error "+ responseCode);
//            }else{
//                StringBuilder infotmationString =new StringBuilder();
//                Scanner scanner=new Scanner(url.openStream());
//                while(scanner.hasNext()){
//                    infotmationString.append(scanner.nextLine());
//                }
//                scanner.close();
//                System.out.println(infotmationString);
//                //JSONArray jsonArray=new JSONArray(infotmationString.toString());
//                //JSONObject jsonObject=jsonArray.getJSONObject(0);
//                //System.out.println(jsonObject.getString("userId"));
//                JSONObject jsonObject=new JSONObject(infotmationString.toString());
//                // Accede a los datos del objeto JSONObject
//                int userId = Integer.parseInt(jsonObject.getString("userId"));
//                int id = Integer.parseInt(jsonObject.getString("id"));
//                String title = jsonObject.getString("title");
//                System.out.println("userId"+userId);
//                System.out.println("id"+id);
//                System.out.println("title"+title);
//                
//                
//                
//            }
//        }catch(Exception ex){
//            ex.addSuppressed(ex);
//        }
    }
    
}
