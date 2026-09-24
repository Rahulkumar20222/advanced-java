package com.advancedjava.http;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8085), 0
        );

        server.createContext("/", exchange -> {

            String response = "Hello from Simple HTTP Server!";

            exchange.sendResponseHeaders(200, response.length());

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(response.getBytes());
            }
        });

        server.start();

        System.out.println("HTTP Server started at http://localhost:8085");
    }
}