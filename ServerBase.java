import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ServerBase {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        // Create server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create a context (route)
        server.createContext("/hello", new HTTPResquestHandler());

        server.setExecutor(null); // default executor
        server.start();

        System.out.println("Server running at http://localhost:" + port + "/hello");
    }

    
}