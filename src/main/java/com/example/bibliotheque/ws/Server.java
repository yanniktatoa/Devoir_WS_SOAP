package com.example.bibliotheque.ws;

import com.example.bibliotheque.ws.service.BibliothequeServiceImpl;

import javax.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        String host = System.getProperty("server.host", "localhost");
        String port = System.getProperty("server.port", "8080");
        String context = System.getProperty("server.context", "bibliotheque");
        String address = "http://" + host + ":" + port + "/" + context;
        Endpoint.publish(address, new BibliothequeServiceImpl());
        System.out.println("BibliothequeService démarré sur " + address + " (ajoutez ?wsdl pour le WSDL)");
        System.out.println("Appuyez sur Ctrl+C pour arrêter.");
    }
} 