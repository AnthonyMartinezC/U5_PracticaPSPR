package com.anthony.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorDNI {
    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("🔵 Servidor esperando conexiones en el puerto " + PUERTO);

            while (true) {
                Socket socketCliente = servidor.accept();
                System.out.println("🟢 Cliente conectado desde: " + socketCliente.getInetAddress());
                new ManejadorCliente(socketCliente).start(); // Hilo por cliente
            }
        } catch (IOException e) {
            System.err.println("❌ Error en el servidor: " + e.getMessage());
        }
    }
}
