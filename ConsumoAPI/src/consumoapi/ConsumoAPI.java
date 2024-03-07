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
        consumoGETApiObject apiObj=new consumoGETApiObject();
        consumoGETApiArrayObject apiArrObj=new consumoGETApiArrayObject();
        consumoPOSTApi apiPost =new consumoPOSTApi();
        //apiObj.consumoApiObj();
        //apiArrObj.consumoApiArrayObj();
        apiPost.ConsumoApiPost();
    }
    
}
