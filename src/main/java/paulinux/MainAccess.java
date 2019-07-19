package paulinux;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class MainAccess{

    public static String marketID;
    public static String endpoint;
    public static String usr;
    public static String pswd;
    public static String ticker;
    public static String author;

    public static void main(String[] args) throws Exception{


            try (InputStream input = new FileInputStream ("src/main/java/configuration/config.properties")){

                Properties prop =new Properties();
                prop.load(input);

                // *** upload variables in cfg file

                marketID        =prop.getProperty("ra.marketID");
                endpoint        =prop.getProperty("ra.endpoint");
                usr             =prop.getProperty("ra.usr");
                pswd            =prop.getProperty("ra.pswd");
                ticker          =prop.getProperty("ra.exampleTicker");
                author          =prop.getProperty("ra.author");


                // RESTSession newConnection = new RESTSession();
                System.out.println("Author :"+author);


                // print outputs
                System.out.println("\nREST Outputs:....");
                System.out.println("\nTOKEN->>>>>>>>>>:"+ RESTSession.getToken());

                String instruments = RESTSession.getInstruments();
                System.out.println("Todos los contratos "+instruments);

                String instDetails = RESTSession.getInstrumentDetail(ticker);
                System.out.println("Details for "+ticker+" "+instDetails);


            }catch (IOException ex){
                System.out.println("Some error loading config.properties");
            }

        }
}