package paulinux;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



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


            }catch (IOException ex){
                System.out.println("Some error loading config.properties");
            }

        }
}