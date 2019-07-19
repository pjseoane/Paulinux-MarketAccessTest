package paulinux;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Base64;

public final class RESTSession {

    public static String marketID=MainAccess.marketID;
    public static String endpoint=MainAccess.endpoint;
    public static String usr=MainAccess.usr;
    public static String pswd=MainAccess.pswd;
    public static String ticker;


    private static String url;
    private static String token=null;




    public static String getToken() throws Exception{



        if (token == null){
            url=    endpoint+ "auth/getToken";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            String userCredentials = usr+":"+pswd;
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", basicAuth);
            con.setDoOutput(true);
            token=con.getHeaderField("X-Auth-Token");
        }

        return token;
    }

    private static String doGET(String url) throws Exception{
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

    @org.jetbrains.annotations.NotNull
    public static String getInstruments()throws Exception{
        url = endpoint+ "rest/instruments/all";

        return doGET(url);
    }
    public static String getInstrumentDetail(String symbol)throws Exception{
        url = endpoint + "rest/instruments/detail?symbol=" + symbol + "&marketId=" + marketID;
        return doGET(url);
    }
}
