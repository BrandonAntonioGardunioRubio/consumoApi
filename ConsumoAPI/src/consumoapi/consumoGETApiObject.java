package consumoapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class consumoGETApiObject {
    public void consumoApiObj(){
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
    }
}
