package server;




import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import logic.Scrapping;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    private static Scrapping INSTANCE;
    //https://www.logicbig.com/tutorials/core-java-tutorial/http-server/http-server-basic.html
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8505), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(Main::handleRequest);

        INSTANCE = Scrapping.getINSTANCE();


        //Die Reihenfolge -> umgekehrt bleibt beim scrapenstecken [For(;;)]
        server.start();
        INSTANCE.scrapThread();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        //Was beim Server hingeschrieben wird
        String response = INSTANCE.getActURL();
        exchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }


}
