
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HTTPResquestHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            // Check if request method is GET
            if ("GET".equals(exchange.getRequestMethod())) {

                String response = "{ \"message1\": \"Hello from the server!\", " +
                 "\"message2\": \"This is the second string.\" }";

                exchange.getResponseHeaders().set("Content-Type", "application/json");  
                exchange.sendResponseHeaders(200, response.length());

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

            } else {
                // Method not allowed
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }

