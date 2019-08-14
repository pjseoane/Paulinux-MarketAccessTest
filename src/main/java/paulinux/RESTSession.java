package paulinux;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Base64;

final class RESTSession {

    private static String marketID=MainAccess.marketID;
    private static String endpoint=MainAccess.endpoint;
    private static String usr=MainAccess.usr;
    private static String pswd=MainAccess.pswd;
    //private static String ticker;


    private static String url;
    private static String token=null;




    static String getToken() throws Exception{



        if (token == null){
            url=    endpoint+ "auth/getToken";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            String userCredentials = usr+":"+pswd;
            //System.out.println("User Credentials: "+userCredentials);
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", basicAuth);
            con.setDoOutput(true);
            token=con.getHeaderField("X-Auth-Token");
        }

        return token;
    }

    @NotNull
    private static String doGET(String url) throws Exception{
        RESTSession.url = url;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("X-Auth-Token",token);
        con.setRequestMethod("GET");

        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputline;
        StringBuilder content = new StringBuilder();

        while ((inputline = in.readLine()) != null) {
            content.append(inputline);
        }
        in.close();
        con.disconnect();
        return content.toString();

    }


    @NotNull
    public static String getInstruments()throws Exception{
        url = endpoint+ "rest/instruments/all";

        return doGET(url);
    }
    @NotNull
    public static String getInstrumentDetail(String symbol)throws Exception{
        url = endpoint + "rest/instruments/detail?symbol=" + symbol + "&marketId=" + marketID;
        return doGET(url);
    }

    @NotNull
    public static String getInstrumentDetailsAll() throws Exception{
        url = endpoint + "rest/instruments/details";
        return doGET(url);
    }


    public static String getMarketData(String marketID, String symbol, int depth) throws Exception{
        url=endpoint+"rest/marketdata/get?marketId=" + marketID + "&symbol=" + symbol + "&entries=BI,OF,LA,OP,CL,SE,OI&depth=" + depth;
        return doGET(url);
    }

}
