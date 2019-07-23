package paulinux;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

//import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.*;
import org.json.simple.JSONObject;


public class MainAccess{

    static String marketID;
    static String endpoint;
    static String usr;
    static String pswd;


    public static void main(String[] args) throws Exception{

            try (InputStream input = new FileInputStream ("src/main/java/configuration/config.properties")){

                Properties prop =new Properties();
                prop.load(input);

                // *** upload variables in cfg file

                marketID        =prop.getProperty("ra.marketID");
                endpoint        =prop.getProperty("ra.endpoint");
                usr             =prop.getProperty("ra.usr");
                pswd            =prop.getProperty("ra.pswd");
                String ticker   =prop.getProperty("ra.exampleTicker");
                String author   =prop.getProperty("ra.author");

                // RESTSession newConnection = new RESTSession();
                System.out.println("Author :"+author);


                // print outputs
                System.out.println("\nREST Outputs:....");
                System.out.println("\nTOKEN->>>>>>>>>>:"+ RESTSession.getToken());

                String instruments = RESTSession.getInstruments();
                System.out.println("Todos los contratos "+instruments);

                String instDetails = RESTSession.getInstrumentDetail(ticker);
                System.out.println("Details for "+ ticker +" "+instDetails);

                // String instDetailsAll = RESTSession.getInstrumentDetailsAll();
                // System.out.println("Details for all "+instDetailsAll);

                String marketData = RESTSession.getMarketData(marketID, ticker,1);
                System.out.println("Market Data for: "+ ticker +" "+marketData);
                System.out.println();
                System.out.println("Parsing JSON: ");

                Object obj = new JSONParser().parse(marketData);

                JSONObject jo = (JSONObject) obj;

                System.out.println("JSON obj: "+jo);
                System.out.println("depth: "+jo.get("depth"));
                System.out.println("marketData: "+jo.get("marketData"));

                JSONObject mData=(JSONObject) jo.get("marketData");
                System.out.println("Bid: "+mData.get("BI"));


                //------------
                JSONArray ja = (JSONArray) mData.get("BI");
                System.out.println("Array length"+ja);


            }catch (IOException ex){
                System.out.println("Some error loading config.properties");
            }

        }
}