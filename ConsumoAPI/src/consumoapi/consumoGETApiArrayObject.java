package consumoapi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


public class consumoGETApiArrayObject {
    public void consumoApiArrayObj(){
        try {
            //Solicitar peticion
            URL url= new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            //otener cdigo de respuesta
            int responseCode=conn.getResponseCode();
            if(responseCode!=200){
                throw new RuntimeException("Ocurrio un error "+ responseCode);
            }else{
                StringBuilder infotmationString =new StringBuilder();
                Scanner scanner=new Scanner(url.openStream());
                while(scanner.hasNext()){
                    infotmationString.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(infotmationString);
                JSONArray jsonArray=new JSONArray(infotmationString.toString());
                 //Accede a los datos del objeto JSONObject
                JSONObject jsonObject=jsonArray.getJSONObject(0);
                System.out.println(jsonObject.getString("userId"));
                
                
                
                
                
                
            }
        }catch(Exception ex){
            ex.addSuppressed(ex);
        }
    }
        
}
